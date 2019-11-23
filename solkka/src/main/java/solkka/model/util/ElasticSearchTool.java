package solkka.model.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import solkka.model.domain.CardDataDTO;

@Component
public class ElasticSearchTool {
	private static RestHighLevelClient client = null;

	@Value("${es.host}")
	private String host;
	@Value("${es.port}")
	private int port;

	public void connect() {
		client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));
	}

	public void close() throws IOException {
		client.close();
	}

	public List<CardDataDTO> searchIdAndDate(String index, String idField, String userId, String dateField, String before) throws IOException {
		connect();
		System.out.println(index);
		SearchRequest searchRequest = new SearchRequest(index);
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(QueryBuilders.boolQuery()
								.must(QueryBuilders.termQuery(idField, userId))
								.must(QueryBuilders.rangeQuery(dateField).from(before)))
								.size(1000);
		searchRequest.source(sourceBuilder);
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		List<CardDataDTO> result = new ArrayList<>();
		Map<String, Object> map = null;
		for(SearchHit hit : searchResponse.getHits().getHits()) {
			map = hit.getSourceAsMap();
			result.add(new CardDataDTO(map.get("userId").toString()
					, index.equals("sample_card_credit") ? "신용" : "체크", map.get("apprvDate").toString()
					, map.get("storeId").toString().substring(0, 2)
					, Integer.parseInt(map.get("apprvAmount").toString())
					, map.get("storeName").toString()));
		}
		close();
		return result;
	}

	public JSONArray searchId(String index, String idField, String userId) throws IOException {
		connect();
		System.out.println(index);
		SearchRequest searchRequest = new SearchRequest(index);
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(QueryBuilders.matchQuery(idField, userId))
				.size(1000);
		searchRequest.source(sourceBuilder);
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		JSONArray array = new JSONArray();
		Arrays.stream(searchResponse.getHits().getHits()).map(v -> v.getSourceAsMap()).forEach(v -> array.add(v));
		close();
		return array;
	}
}
