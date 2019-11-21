package solkka.model.util;

import java.net.URI;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiTool {
	@Value("${api.ip}")
	private String IP;
	@Value("${api.port}")
	private String PORT;
	@Value("${api.name}")
	private String NAME;

	// 예: http://10.3.17.61:8080/v2/stocks/balance-check (post)
	public JSONObject callApi(JSONObject input) throws RestClientException, ParseException {
		System.out.println(makeURI(input));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<JSONObject> request = new HttpEntity<>(input, headers);
		ResponseEntity<JSONObject> response = (new RestTemplate()).exchange(
				URI.create(
						makeURI(input)),
				HttpMethod.POST, request, JSONObject.class);
		return response.getBody();
	}
	
	public String makeURI(JSONObject input) throws ParseException {
		System.out.println(input);
		return new StringBuilder()
				.append(IP).append(":")
				.append(((JSONObject) (new JSONParser().parse(PORT))).get(input.get("cat").toString()).toString())
				.append(((JSONObject) (new JSONParser().parse(NAME))).get(input.get("name").toString()).toString())
				.toString();
	}
}
