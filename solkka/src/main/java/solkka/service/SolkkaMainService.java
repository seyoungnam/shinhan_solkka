package solkka.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class SolkkaMainService {
	@Autowired
	SolkkaAPIService apiService;

	public JSONObject getCardData(String id) throws RestClientException, ParseException {
		System.out.println("ID : " + id);
		Date today = new Date();
		String period = new SimpleDateFormat("yyyyMMdd").format(calMonth(today, -3)) + new SimpleDateFormat("yyyyMMdd").format(today);
		System.out.println(period);
		System.out.println("%% 신용 결과 : " + apiService.usedCredit(period)); // 3개월 신용카드 사용 데이터 호출 (Es로 샘플 데이터 받아옴)
		System.out.println("%% 체크 결과 : " + apiService.usedDebit(period)); // 3개월 체크카드 사용 데이터 호출 (Es로 샘플 데이터 받아옴)
		return null;
	}
	
	public Date calMonth(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
	}
}