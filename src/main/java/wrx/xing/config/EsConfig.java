package wrx.xing.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-21 20:50
 */
@Configuration
public class EsConfig implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {
	private static final Logger logger = LoggerFactory.getLogger(EsConfig.class);

	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes ;

	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;

	private TransportClient client;


	@Override
	public void destroy() throws Exception {
		try {
			logger.info("Closing elasticSearch client");
			if (client != null) {
				client.close();
			}
		} catch (final Exception e) {
			logger.error("Error closing ElasticSearch client: ", e);
		}
	}

	@Override
	public TransportClient getObject() throws Exception {
		return client;
	}

	@Override
	public Class<?> getObjectType() {
		return TransportClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		buildClient();
	}

	protected void buildClient()  {
		try {
			PreBuiltTransportClient  preBuiltTransportClient = new PreBuiltTransportClient(settings());
			if (!StringUtils.isEmpty(clusterNodes)){
				for (String nodes:clusterNodes.split(",")) {
					String[] netSocket = nodes.split(":");
					String address = netSocket[0];
					Integer port = Integer.valueOf(netSocket[1]);
					preBuiltTransportClient.addTransportAddress(new
							InetSocketTransportAddress(InetAddress.getByName(address),port ));
				}
				client = preBuiltTransportClient;
			}
		} catch (UnknownHostException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 初始化默认的client
	 * 你可以设置client.transport.sniff为true来使客户端去嗅探整个集群的状态，
	 * 把集群中其它机器的ip地址加到客户端中，这样做的好处是一般你不用手动设置集群里所有集群的ip到连接客户端，
	 * 它会自动帮你添加，并且自动发现新加入集群的机器。
	 *
	 * 注意：当ES服务器监听使用内网服务器IP而访问使用外网IP时，不要使用client.transport.sniff为true，
	 * 在自动发现时会使用内网IP进行通信，导致无法连接到ES服务器，而直接使用addTransportAddress方法进行指定ES服务器。
	 */
	private Settings settings(){
		Settings settings = Settings.builder()
				.put("cluster.name",clusterName)
				.put("client.transport.sniff",false)
				.build();
		return settings;
	}
}
