package wrx.xing.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-21 20:50
 */
@Configuration
public class RestEsConfig {

    @Value("${elasticsearch.rest.client.cluster-nodes}")
    private String clusterNodes;

    private RestClient restClient;

    @Bean
    public RestClient buildClient()  {
        if (!StringUtils.isEmpty(clusterNodes)) {
            String[] nodes = clusterNodes.split(",");
            HttpHost[] httpHosts = new HttpHost[nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                String[] netSocket = nodes[i].split(":");
                String address = netSocket[0];
                Integer port = Integer.valueOf(netSocket[1]);
                httpHosts[i] = new HttpHost(address, port, "http");
            }
            restClient = RestClient.builder(httpHosts).build();
        }
        return restClient;
    }

}