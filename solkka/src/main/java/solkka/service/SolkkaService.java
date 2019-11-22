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
	ApiTool apiTool;
//	[전체 계좌 조회] {"number":"901212-1*****"}
	public JSONObject accountList(String number) throws RestClientException, ParseException {
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
//		http://10.3.17.61:8080/v1/account/list
		JSONObject result = apiTool.callApi("bank", "accountList", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[예적금계좌내역/계좌정보 상세조회] {"startDate":"2019-11-23", "endDate":"2019-11-23", "account":"00000000"}
	public JSONObject accountDeposit(String startDate, String endDate, String account) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"serviceCode":"D1130","정렬구분":"1","조회시작일":"20190228","조회종료일":"20190830","조회기간구분":"1","은행구분":"1","계좌번호":"230221966424"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("serviceCode", "D1130");
		dataBodyMap.put("정렬구분", "1");
		dataBodyMap.put("조회시작일", startDate);
		dataBodyMap.put("조회종료일", endDate);
		dataBodyMap.put("조회기간구분", "1");
		dataBodyMap.put("조회종료일", "1");
		dataBodyMap.put("은행구분", "1");
		dataBodyMap.put("계좌번호", account);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8080/v1/account/deposit/detail
		JSONObject result = apiTool.callApi("bank", "accountDeposit", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[펀드계좌 내역/계좌정보 상세 조회] {"account":"1234567890"}
	public JSONObject accountFund(String account) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"거래구분":"1","계좌번호":"250132675998","은행구분":"1","미기장거래":"1","직원조회":"1","정렬구분":"2"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("거래구분", "1");
		dataBodyMap.put("계좌번호", account);
		dataBodyMap.put("은행구분", "1");
		dataBodyMap.put("미기장거래", "1");
		dataBodyMap.put("직원조회", "1");
		dataBodyMap.put("정렬구분", "1");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8080/v1/account/fund/detail
		JSONObject result = apiTool.callApi("bank", "accountFund", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[신탁계좌 내역/계좌정보 상세 조회] {"account":"1234567890"}
	public JSONObject accountTrust(String account) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{ "고객번호":"0642423512", "거래구분":"1", "은행구분":"1", "계좌번호":"299011373321", "직원여부":"1","정렬구분":"1"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("고객번호", "0642423512");
		dataBodyMap.put("거래구분", "1");
		dataBodyMap.put("은행구분", "1");
		dataBodyMap.put("계좌번호", account);
		dataBodyMap.put("직원여부", "1");
		dataBodyMap.put("정렬구분", "1");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8080/v1/account/investment-trust/detail
		JSONObject result = apiTool.callApi("bank", "accountTrust", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[주식잔고] {"account":"1234567890"}
	public JSONObject stockRemq(String account) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"acct_no":"01234567890","acct_gds_code":"01","acct_pwd":"4400shinhanial%2FENC%2FPp831ci50Of3DpcOqy5ghA%3D%3D","qry_tp_code":"1","uv_tp_code":"1","stbd_tp_code":"1","adup_tp_code":"1","mrkt_tp_code":"1"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("acct_no", account);
		dataBodyMap.put("acct_gds_code", "01");
		dataBodyMap.put("acct_pwd", "4400shinhanial%2FENC%2FPp831ci50Of3DpcOqy5ghA%3D%3D");
		dataBodyMap.put("qry_tp_code", "1");
		dataBodyMap.put("uv_tp_code", "1");
		dataBodyMap.put("stbd_tp_code", "1");
		dataBodyMap.put("adup_tp_code", "1");
		dataBodyMap.put("mrkt_tp_code", "1");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8082/v1/stock/remq
		JSONObject result = apiTool.callApi("fin", "stockRemq", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
	
	// 동성
//	[ISA 계좌 내역 / 계좌정보 상세 조회] {"account":"1234567890"}
	public JSONObject accountIsa(String account) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"고객번호":"0741831215","업무구분":"01","조회구분":"00","계좌번호":"269000015682","시작일자":"20190826","종료일자":"20190926","거래유형":"99","조회건수":"00000"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("고객번호", "0741831215");
		dataBodyMap.put("업무구분", "01");
		dataBodyMap.put("조회구분", "00");
		dataBodyMap.put("계좌번호", account);
		dataBodyMap.put("시작일자", "20190826");
		dataBodyMap.put("종료일자", "20190926");
		dataBodyMap.put("거래유형", "99");
		dataBodyMap.put("조회건수", "00000");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8080/v1/account/isa/detail
		JSONObject result = apiTool.callApi("bank", "accountIsa", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[주식체결내역조회] {"account":"1234567890", "ordDate":"2019-11-23"}
	public JSONObject stockCntrList(String account, String ordDate) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"acct_no" : "01234567890","acct_gds_code" : "01","acct_pwd" : "4400shinhanial%2FENC%2FPp831ci50Of3DpcOqy5ghA%3D%3D","ord_ymd" : "20170914","cntr_dcd_tp_code" : "1","stbd_code" : "*","sell_buy_tp_code" : "0","stbd_tp_code" : "0","adup_tp_code" : "0","cash_crd_tp_code" : "0"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("acct_no", account);
		dataBodyMap.put("acct_gds_code", "01");
		dataBodyMap.put("acct_pwd", "4400shinhanial%2FENC%2FPp831ci50Of3DpcOqy5ghA%3D%3D");
		dataBodyMap.put("ord_ymd", ordDate);
		dataBodyMap.put("cntr_dcd_tp_code", "1");
		dataBodyMap.put("stbd_code", "*");
		dataBodyMap.put("sell_buy_tp_code", "0");
		dataBodyMap.put("stbd_tp_code", "0");
		dataBodyMap.put("adup_tp_code", "0");
		dataBodyMap.put("cash_crd_tp_code", "0");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8082/v1/stock/cntrlist
		JSONObject result = apiTool.callApi("fin", "stockCntrList", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[대출 예탁증권 담보대출현황] {"customer":"qkrejrghksdmscjswoek"}
	public JSONObject loanStatus(String customer) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"cust_id":"qkrejrghksdmscjswoek"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("cust_id", customer);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8082/v1/loan/status
		JSONObject result = apiTool.callApi("fin", "loanStatus", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[자산 자산현황] {"customer":"qkrejrghksdmscjswoek"}
	public JSONObject assetStatus(String customer) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"cust_id":"qkrejrghksdmscjswoek"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("cust_id", customer);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8082/v1/asst/status
		JSONObject result = apiTool.callApi("fin", "assetStatus", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[(체크)국내사용내역조회 - 체크 승인] {"period":"2019050720190805"}
	public JSONObject usedDebit(String perioid) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"nxtQyKey":"","bctag":"0","inqterm":"2019050720190805"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("nxtQyKey", "");
		dataBodyMap.put("bctag", "0");
		dataBodyMap.put("inqterm", perioid);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8081/v1/usedebitcard/searchusefordomestic
		JSONObject result = apiTool.callApi("card", "usedDebit", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[(신용)국내사용내역조회 - 일시불/할부] {"period":"2019050720190805"}
	public JSONObject usedCredit(String perioid) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{"nxtQyKey":"","inqterm":"2019050720190805","bctag":"0"}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("nxtQyKey", "");
		dataBodyMap.put("inqterm", perioid);
		dataBodyMap.put("bctag", "0");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8081/v1/usecreditcard/searchusefordomestic
		JSONObject result = apiTool.callApi("card", "usedCredit", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
//	[보험계약 대출 목록조회] {"number":"901212-1*****"}
	public JSONObject loanList(String number) throws RestClientException, ParseException {
//		{"dataHeader":{},"dataBody":{ "rdreNo":"WmokLBDCO9/yfihlYoJFyg=="}}
		Map<String, Object> dataBodyMap = new HashMap<>();
		dataBodyMap.put("rdreNo", "number");
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataHeader", new JSONObject());
		dataMap.put("dataBody", dataBodyMap);
//		http://10.3.17.61:8083/v1/loan/list
		JSONObject result = apiTool.callApi("ins", "loanList", "post", dataMap);
		System.out.println("** 송출 데이터 : " + result);
		return result;
	}
}