package solkka.model.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

	public boolean deleteIndex(String index) throws IOException {
		DeleteIndexRequest request = new DeleteIndexRequest(index);
		client.indices().delete(request, RequestOptions.DEFAULT);
		return true;
	}

	public boolean createIndex(String index, String mapping) throws IOException {
		CreateIndexRequest request = new CreateIndexRequest(index);
		request.mapping(mapping, XContentType.JSON);
		client.indices().create(request, RequestOptions.DEFAULT);
		return true;
	}

	public boolean bulk(String index, List<String> dataList) throws IOException {
		BulkRequest request = new BulkRequest();
		dataList.stream().forEach(v -> request.add(new IndexRequest(index).source(v, XContentType.JSON)));
		client.bulk(request, RequestOptions.DEFAULT);
		return true; 
	}

	public List<String> search(String index, Map<String, String> queries) throws IOException {
		SearchRequest request = new SearchRequest(index);
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		queries.entrySet().stream().forEach(v -> sourceBuilder
				.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(v.getKey(), v.getValue()))));
		request.source(sourceBuilder);
		return StreamSupport.stream(client.search(request, RequestOptions.DEFAULT).getHits().spliterator(), false)
				.map(v -> v.getSourceAsString()).collect(Collectors.toList());
	}

// 업데이트 예정
// https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high-search.html#java-rest-high-search-request-building-aggs
//	public List<String> aggregation(String index, Map<String, String> queries) throws IOException {
//		SearchRequest request = new SearchRequest(index);
//		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//		queries.entrySet().stream().forEach(v -> sourceBuilder
//				.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(v.getKey(), v.getValue()))));
//		request.source(sourceBuilder);
//		return StreamSupport.stream(client.search(request, RequestOptions.DEFAULT).getHits().spliterator(), false)
//				.map(v -> v.getSourceAsString()).collect(Collectors.toList());
//	}
}
