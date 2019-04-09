package wrx.xing.service.impl;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wrx.xing.constant.EsConstant;
import wrx.xing.service.EsService;

import java.io.IOException;
import java.util.Collections;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-21 20:41
 */
@Service
public class EsServiceImpl implements EsService {
	@Autowired
	private TransportClient client;

	@Autowired
	private RestClient restClient;

	public SearchResponse getAllData(){
		SearchResponse response = client.prepareSearch(EsConstant.ACCOUNT_INDEX).setTypes(EsConstant.ACCOUNT_TYPE).setQuery(QueryBuilders.matchAllQuery()).get();
		return response;
	}

	public Response getAllDataForRestClient(){
		String url = "/"+EsConstant.ACCOUNT_INDEX+"/"+EsConstant.ACCOUNT_TYPE+"/_search";
		HttpEntity params = new NStringEntity("{\"query\":{\"match_all\":{}}}",
				ContentType.APPLICATION_JSON);
		try {
			return restClient.performRequest("GET", url, Collections.emptyMap(), params);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
