package solkka.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import solkka.model.util.ApiTool;

@Service
public class SolkkaService {
	@Autowired
	ApiTool apiTool;
//	[전체 계좌 조회] {"number":"901212-1*****"}
	public JSONObject accountList(String number) throws RestClientException, ParseException, org.json.simple.parser.ParseException {
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
}