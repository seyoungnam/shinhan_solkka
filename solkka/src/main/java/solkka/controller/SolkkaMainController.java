package solkka.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import solkka.service.SolkkaMainService;

@RestController
public class SolkkaMainController {
	@Autowired
	SolkkaMainService mainService;
	// 실제 Front 통신 메소드 목록
	@PostMapping("/getCardData") // 프론트에서 id로 호출 -> 최근 3개월 신용 + 카드 API에서 호출 -> 통합 DB에 적재
	public JSONObject getCardData(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// getCardData");
		System.out.println("** 수신 데이터 : "+ body);
		return mainService.getCardData(body.get("userId").toString()); // 주민등록번호
	}
}
