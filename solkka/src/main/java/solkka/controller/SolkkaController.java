package solkka.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import solkka.service.SolkkaService;

@RestController
public class SolkkaController {
	@Autowired
	SolkkaService service;
	// API 통신 메소드 목록
	// postman 테스트 콜렉션 : https://www.getpostman.com/collections/61a111dbf2ea074a02e5
	@PostMapping("/accountList")
	public JSONObject accountList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountList");
		System.out.println("** 수신 데이터 : "+ body);
		return service.accountList(body.get("number").toString()); // 주민등록번호
	}
	@PostMapping("/accountDeposit")
	public JSONObject accounDeposit(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountDeposit");
		System.out.println("** 수신 데이터 : "+ body);
		return service.accountDeposit(body.get("startDate").toString(), body.get("endDate").toString(), body.get("account").toString()); // 시작일, 종료일, 계좌번호
	}
	@PostMapping("/accountFund")
	public JSONObject accounFund(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountFund");
		System.out.println("** 수신 데이터 : "+ body);
		return service.accountFund(body.get("account").toString()); // 계좌번호
	}
	@PostMapping("/accountTrust")
	public JSONObject accounTrust(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountTrust");
		System.out.println("** 수신 데이터 : "+ body);
		return service.accountTrust(body.get("account").toString()); // 계좌번호
	}
	@PostMapping("/stockRemq")
	public JSONObject stockRemq(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// stockRemq");
		System.out.println("** 수신 데이터 : "+ body);
		return service.stockRemq(body.get("account").toString()); // 계좌번호
	}
	
	// 동성
	@PostMapping("/accountIsa")
	public JSONObject accountIsa(@RequestBody JSONObject body) throws RestClientException, ParseException{
		System.out.println("// accountIsa");
		System.out.println("** 수신 데이터 : "+ body);
		return service.accountIsa(body.get("account").toString()); // 계좌번호 
	}
	@PostMapping("/stockCntrList")
	public JSONObject stockCntrList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// stockCntrList");
		System.out.println("** 수신 데이터 : "+ body);
		return service.stockCntrList(body.get("account").toString(), body.get("ordDate").toString()); // 계좌번호
	}
	@PostMapping("/loanStatus")
	public JSONObject loanStatus(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// loanStatus");
		System.out.println("** 수신 데이터 : "+ body);
		return service.loanStatus(body.get("customer").toString()); // 계좌번호
	}
	@PostMapping("/assetStatus")
	public JSONObject assetStatus(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// assetStatus");
		System.out.println("** 수신 데이터 : "+ body);
		return service.assetStatus(body.get("customer").toString()); // 계좌번호
	}
	@PostMapping("/usedDebit")
	public JSONObject usedDebit(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// usedDebit");
		System.out.println("** 수신 데이터 : "+ body);
		return service.usedDebit(body.get("period").toString()); // 계좌번호
	}
	@PostMapping("/usedCredit")
	public JSONObject usedCredit(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// usedCredit");
		System.out.println("** 수신 데이터 : "+ body);
		return service.usedCredit(body.get("period").toString()); // 계좌번호
	}
	@PostMapping("/loanList")
	public JSONObject loanList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// loanList");
		System.out.println("** 수신 데이터 : "+ body);
		return service.loanList(body.get("number").toString()); // 주민등록번호
	}
}
