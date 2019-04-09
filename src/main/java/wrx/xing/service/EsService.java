package wrx.xing.service;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-21 20:41
 */
public interface EsService {
	SearchResponse getAllData();

	Response getAllDataForRestClient();
}
