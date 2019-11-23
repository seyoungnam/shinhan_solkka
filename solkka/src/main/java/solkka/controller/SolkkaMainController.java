package solkka.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import solkka.model.domain.CardDataDTO;
import solkka.service.SolkkaMainService;

@RestController
public class SolkkaMainController {
	@Autowired
	SolkkaMainService mainService;
	// 실제 Front 통신 메소드 목록
	// 바디 : {"userId":"girl2019"}
	@PostMapping("/getCardData")
	public List<CardDataDTO> getCardData(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getCardData(body.get("userId").toString());
	}
	// 바디 : {"userId1":"girl2019", "userId2":"boy2019"}
	@PostMapping("/getCardDataCouple")
	public List<CardDataDTO> getCardDataCouple(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getCardDataCouple(body.get("userId1").toString(), body.get("userId2").toString());
	}
}
