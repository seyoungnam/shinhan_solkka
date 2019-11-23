package solkka.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
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
	// 바디 : {"userId":"girl2019", "income":5000000}
	@PostMapping("/getExpenseRate")
	public JSONObject getExpenseRate(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getExpanseRate(body.get("userId").toString(), Integer.parseInt(body.get("income").toString()));
	}
	// 바디 : {"userId1":"girl2019", "userId2":"boy2019", "incomeSum":5000000}
	@PostMapping("/getExpenseRateCouple")
	public JSONObject getExpenseRateCouple(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getExpanseRateCouple(body.get("userId1").toString(), body.get("userId2").toString(), Integer.parseInt(body.get("incomeSum").toString()));
	}
	// 바디 : {"userId":"girl2019"}
	@PostMapping("/getCardDataCat")
	public JSONObject getCardDataCat(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getCardDataCat(body.get("userId").toString());
	}
	// 바디 : {"userId1":"girl2019", "userId2":"boy2019"}
	@PostMapping("/getCardDataCatCouple")
	public JSONObject getCardDataCatCouple(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getCardDataCatCouple(body.get("userId1").toString(), body.get("userId2").toString());
	}
	// 바디 : {"userId":"girl2019"}
	@PostMapping("/getStockData")
	public JSONArray getStockData(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getStockData(body.get("userId").toString());
	}
	// 바디 : {"userId1":"girl2019", "userId2":"boy2019"}
	@PostMapping("/getStockDataCouple")
	public JSONArray getStockDataCouple(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getStockDataCouple(body.get("userId1").toString(), body.get("userId2").toString());
	}
	// 바디 : {"userId":"girl2019"}
	@PostMapping("/getCardRcmd")
	public JSONArray getCardRcmd(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getCardRcmd(body.get("userId").toString());
	}
	// 바디 : "userId1":"girl2019", "userId2":"boy2019"}
	@PostMapping("/getCardRcmdCouple")
	public JSONArray getCardRcmdCouple(@RequestBody JSONObject body) throws RestClientException, ParseException, IOException {
		return mainService.getCardRcmdCouple(body.get("userId1").toString(), body.get("userId2").toString());
	}
}
