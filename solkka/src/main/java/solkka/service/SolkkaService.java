package solkka.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import solkka.model.util.ApiTool;

@Service
public class SolkkaService {
	@Autowired
	ApiTool tool;

	public JSONObject accountList(String number) throws RestClientException, ParseException {
		System.out.println(number);
//		{"dataHeader":{},"dataBody":{"serviceCode":"C2010","거래구분":"9","계좌감추기여부":"1","보안계좌조회구분":"2","주민등록번호":"WmokLBDCO9/yfihlYoJFyg=="}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("serviceCode", "C2010");
		dataBodyMap.put("거래구분", "9");
		dataBodyMap.put("계좌감추기여부", "1");
		dataBodyMap.put("보안계좌조회구분", "2");
		dataBodyMap.put("주민등록번호", number);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
		return tool.callApi("bank", "accountList", "post", dataMap);
	}

}