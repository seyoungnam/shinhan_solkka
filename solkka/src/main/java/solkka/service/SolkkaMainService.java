package solkka.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import solkka.model.domain.CardDataDTO;
import solkka.model.util.ElasticSearchTool;

@Service
public class SolkkaMainService {
	@Autowired
	SolkkaAPIService apiService;
	@Autowired
	ElasticSearchTool searchTool;
	
	public Date calMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	public List<CardDataDTO> getCardData(String userId) throws RestClientException, ParseException, IOException {
		// API를 호출한다
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String before = new SimpleDateFormat("yyyyMMdd").format(calMonth(new Date(), -3));
		System.out.println(apiService.usedCredit(before + today));;
		// 대신 Sample Data를 호출한다
		List<CardDataDTO> result = searchTool.searchIdAndDate("sample_card_credit", "userId", userId, "apprvDate", before);
		result.addAll(searchTool.searchIdAndDate("sample_card_deposit", "userId", userId, "apprvDate", before));
		// 최근 순으로 정렬한다
		result.sort((v1, v2) -> Integer.parseInt(v2.getApprvDate()) - Integer.parseInt(v1.getApprvDate()));
		return result;
	}

	public List<CardDataDTO> getCardDataCouple(String userId1, String userId2) throws IOException, RestClientException, ParseException {
		// API를 호출한다
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String before = new SimpleDateFormat("yyyyMMdd").format(calMonth(new Date(), -3));
		System.out.println(apiService.usedCredit(before + today));;
		// 대신 Sample Data를 호출한다
		List<CardDataDTO> result = searchTool.searchIdAndDate("sample_card_credit", "userId", userId1, "apprvDate", before);
		result.addAll(searchTool.searchIdAndDate("sample_card_credit", "userId", userId2, "apprvDate", before));
		result.addAll(searchTool.searchIdAndDate("sample_card_deposit", "userId", userId1, "apprvDate", before));
		result.addAll(searchTool.searchIdAndDate("sample_card_deposit", "userId", userId2, "apprvDate", before));
		// 최근 순으로 정렬한다
		result.sort((v1, v2) -> Integer.parseInt(v2.getApprvDate()) - Integer.parseInt(v1.getApprvDate()));
		return result;
	}
}