package solkka.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import solkka.service.SolkkaAPIService;

@RestController
public class SolkkaAPIController {
	@Autowired
	SolkkaAPIService apiService;
	// API 통신 메소드 목록
	@PostMapping("/accountList")
	public JSONObject accountList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountList");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.accountList(body.get("number").toString()); // 주민등록번호
	}
	@PostMapping("/accountDeposit")
	public JSONObject accounDeposit(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountDeposit");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.accountDeposit(body.get("startDate").toString(), body.get("endDate").toString(), body.get("account").toString()); // 시작일, 종료일, 계좌번호
	}
	@PostMapping("/accountFund")
	public JSONObject accounFund(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountFund");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.accountFund(body.get("account").toString()); // 계좌번호
	}
	@PostMapping("/accountTrust")
	public JSONObject accounTrust(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountTrust");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.accountTrust(body.get("account").toString()); // 계좌번호
	}
	@PostMapping("/accountIsa")
	public JSONObject accountIsa(@RequestBody JSONObject body) throws RestClientException, ParseException{
		System.out.println("// accountIsa");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.accountIsa(body.get("account").toString()); // 계좌번호 
	}
	@PostMapping("/accountLoan")
	public JSONObject accountLoan(@RequestBody JSONObject body) throws RestClientException, ParseException{
		System.out.println("// accountLoan");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.accountLoan(body.get("account").toString()); // 계좌번호 
	}
	@PostMapping("/stockRemq")
	public JSONObject stockRemq(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// stockRemq");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.stockRemq(body.get("account").toString()); // 계좌번호
	}
	@PostMapping("/stockCntrList")
	public JSONObject stockCntrList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// stockCntrList");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.stockCntrList(body.get("account").toString(), body.get("ordDate").toString()); // 계좌번호, 주문일자
	}
	@PostMapping("/loanStatus")
	public JSONObject loanStatus(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// loanStatus");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.loanStatus(body.get("customer").toString()); // 고객번호
	}
	@PostMapping("/assetStatus")
	public JSONObject assetStatus(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// assetStatus");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.assetStatus(body.get("customer").toString()); // 고객번호
	}
	@PostMapping("/usedDebit")
	public JSONObject usedDebit(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// usedDebit");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.usedDebit(body.get("period").toString()); // 조회기간
	}
	@PostMapping("/usedCredit")
	public JSONObject usedCredit(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// usedCredit");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.usedCredit(body.get("period").toString()); // 조회기간
	}
	@PostMapping("/loanList")
	public JSONObject loanList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// loanList");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.loanList(body.get("number").toString()); // 주민등록번호
	}
	@PostMapping("/assetAcc")
	public JSONObject assetAcc(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// assetAcc");
		System.out.println("** 수신 데이터 : "+ body);
		return apiService.assetAcc(body.get("account").toString()); // 계좌번호
	}	
}
