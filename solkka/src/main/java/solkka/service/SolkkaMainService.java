package solkka.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		// API를 호출하면서 실제적으로 Sample Data를 호출한다
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String before = new SimpleDateFormat("yyyyMMdd").format(calMonth(new Date(), -3));
		List<CardDataDTO> result = new ArrayList<>();
		System.out.println(apiService.usedDebit(before + today));;
		result.addAll(searchTool.searchIdAndDate("sample_card_credit", "userId", userId, "apprvDate", before));
		System.out.println(apiService.usedCredit(before + today));;
		result.addAll(searchTool.searchIdAndDate("sample_card_deposit", "userId", userId, "apprvDate", before));
		// 최근 순으로 정렬한다
		result.sort((v1, v2) -> Integer.parseInt(v2.getApprvDate()) - Integer.parseInt(v1.getApprvDate()));
		return result;
	}

	public List<CardDataDTO> getCardDataCouple(String userId1, String userId2) throws IOException, RestClientException, ParseException {
		// API를 호출하면서 실제적으로 Sample Data를 호출한다
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String before = new SimpleDateFormat("yyyyMMdd").format(calMonth(new Date(), -3));
		List<CardDataDTO> result = new ArrayList<>();
		System.out.println(apiService.usedCredit(before + today));;
		result.addAll(searchTool.searchIdAndDate("sample_card_credit", "userId", userId1, "apprvDate", before));
		System.out.println(apiService.usedCredit(before + today));;
		result.addAll(searchTool.searchIdAndDate("sample_card_credit", "userId", userId2, "apprvDate", before));
		System.out.println(apiService.usedDebit(before + today));;
		result.addAll(searchTool.searchIdAndDate("sample_card_deposit", "userId", userId1, "apprvDate", before));
		System.out.println(apiService.usedDebit(before + today));;
		result.addAll(searchTool.searchIdAndDate("sample_card_deposit", "userId", userId2, "apprvDate", before));
		// 최근 순으로 정렬한다
		result.sort((v1, v2) -> Integer.parseInt(v2.getApprvDate()) - Integer.parseInt(v1.getApprvDate()));
		return result;
	}
	
	public JSONObject getExpanseRate(String userId, int income) throws RestClientException, ParseException, IOException {
		Map<String, Object> one = new HashMap<>();
		one.put("01", 0.164);
		one.put("02", 0.014);
		one.put("03", 0.045);
		one.put("04", 0.175);
		one.put("05", 0.034);
		one.put("06", 0.079);
		one.put("07", 0.076);
		one.put("08", 0.046);
		one.put("09", 0.047);
		one.put("10", 0.034);
		one.put("11", 0.097);
		one.put("12", 0.056);
		Map<String, Object> two = new HashMap<>();
		two.put("01", 0.137);
		two.put("02", 0.013);
		two.put("03", 0.045);
		two.put("04", 0.111);
		two.put("05", 0.034);
		two.put("06", 0.074);
		two.put("07", 0.090);
		two.put("08", 0.052);
		two.put("09", 0.050);
		two.put("10", 0.051);
		two.put("11", 0.111);
		two.put("12", 0.058);
		Map<String, Object> three = new HashMap<>();
		three.put("01", 0.112);
		three.put("02", 0.012);
		three.put("03", 0.047);
		three.put("04", 0.092);
		three.put("05", 0.035);
		three.put("06", 0.059);
		three.put("07", 0.102);
		three.put("08", 0.047);
		three.put("09", 0.055);
		three.put("10", 0.055);
		three.put("11", 0.115);
		three.put("12", 0.061);
		Map<String, Object> four = new HashMap<>();
		four.put("01", 0.099);
		four.put("02", 0.011);
		four.put("03", 0.047);
		four.put("04", 0.074);
		four.put("05", 0.035);
		four.put("06", 0.054);
		four.put("07", 0.108);
		four.put("08", 0.039);
		four.put("09", 0.061);
		four.put("10", 0.062);
		four.put("11", 0.113);
		four.put("12", 0.057);
		Map<String, Object> five = new HashMap<>();
		five.put("01", 0.080);
		five.put("02", 0.006);
		five.put("03", 0.047);
		five.put("04", 0.058);
		five.put("05", 0.036);
		five.put("06", 0.041);
		five.put("07", 0.107);
		five.put("08", 0.031);
		five.put("09", 0.068);
		five.put("10", 0.058);
		five.put("11", 0.099);
		five.put("12", 0.056);
		Map<String, Object> rateDict = new HashMap<>();
		rateDict.put("1", one);
		rateDict.put("2", two);
		rateDict.put("3", three);
		rateDict.put("4", four);
		rateDict.put("5", five);
		
		List<CardDataDTO> cardData = getCardData(userId);
		Map<String, Object> map = new HashMap<>();
		String cat = null;
		for(CardDataDTO dto : cardData) {
			cat = dto.getCat();
			int amount = dto.getApprvAmount();
			map.putIfAbsent(cat, 0);
			map.put(cat, (Integer) map.get(cat) + amount);
		}
		int[] arr1 = {475051, 1602661, 2616274, 3883077, 7113321};
		int[] arr2 = {1318021, 2099722, 2560559, 3114833, 3985476};
		int j = 0;
		Map<String, Object> standard = null;
		for(int i = 1; i < arr1.length; i++) {
			if(arr1[i] > income) {
				standard = (Map<String, Object>) rateDict.get(String.valueOf(i+1));
				j = i - 1 ;
			} else if (i == 4) {
				standard = (Map<String, Object>) rateDict.get(String.valueOf(i+2));
				j = i;
			}
		}
		
		JSONObject object = new JSONObject();
		ArrayList<Double> list = null;
		for(Entry<String, Object> ent : map.entrySet()) {
			list = new ArrayList<>();
			double db = (double) ((Integer) ent.getValue()).intValue();
			list.add(db / 3);
			list.add((Double) standard.get(ent.getKey()) * income / arr1[j] * arr2[j]); 
			object.put(ent.getKey(), list);
		}
		return object;
	}
	
	public JSONObject getExpanseRateCouple(String userId1, String userId2, int incomeSum) throws RestClientException, ParseException, IOException {
		Map<String, Object> one = new HashMap<>();
		one.put("01", 0.164);
		one.put("02", 0.014);
		one.put("03", 0.045);
		one.put("04", 0.175);
		one.put("05", 0.034);
		one.put("06", 0.079);
		one.put("07", 0.076);
		one.put("08", 0.046);
		one.put("09", 0.047);
		one.put("10", 0.034);
		one.put("11", 0.097);
		one.put("12", 0.056);
		Map<String, Object> two = new HashMap<>();
		two.put("01", 0.137);
		two.put("02", 0.013);
		two.put("03", 0.045);
		two.put("04", 0.111);
		two.put("05", 0.034);
		two.put("06", 0.074);
		two.put("07", 0.090);
		two.put("08", 0.052);
		two.put("09", 0.050);
		two.put("10", 0.051);
		two.put("11", 0.111);
		two.put("12", 0.058);
		Map<String, Object> three = new HashMap<>();
		three.put("01", 0.112);
		three.put("02", 0.012);
		three.put("03", 0.047);
		three.put("04", 0.092);
		three.put("05", 0.035);
		three.put("06", 0.059);
		three.put("07", 0.102);
		three.put("08", 0.047);
		three.put("09", 0.055);
		three.put("10", 0.055);
		three.put("11", 0.115);
		three.put("12", 0.061);
		Map<String, Object> four = new HashMap<>();
		four.put("01", 0.099);
		four.put("02", 0.011);
		four.put("03", 0.047);
		four.put("04", 0.074);
		four.put("05", 0.035);
		four.put("06", 0.054);
		four.put("07", 0.108);
		four.put("08", 0.039);
		four.put("09", 0.061);
		four.put("10", 0.062);
		four.put("11", 0.113);
		four.put("12", 0.057);
		Map<String, Object> five = new HashMap<>();
		five.put("01", 0.080);
		five.put("02", 0.006);
		five.put("03", 0.047);
		five.put("04", 0.058);
		five.put("05", 0.036);
		five.put("06", 0.041);
		five.put("07", 0.107);
		five.put("08", 0.031);
		five.put("09", 0.068);
		five.put("10", 0.058);
		five.put("11", 0.099);
		five.put("12", 0.056);
		Map<String, Object> rateDict = new HashMap<>();
		rateDict.put("1", one);
		rateDict.put("2", two);
		rateDict.put("3", three);
		rateDict.put("4", four);
		rateDict.put("5", five);
		
		List<CardDataDTO> cardData = getCardDataCouple(userId1, userId2);
		Map<String, Object> map = new HashMap<>();
		String cat = null;
		for(CardDataDTO dto : cardData) {
			cat = dto.getCat();
			int amount = dto.getApprvAmount();
			map.putIfAbsent(cat, 0);
			map.put(cat, (Integer) map.get(cat) + amount);
		}
		int[] arr1 = {475051, 1602661, 2616274, 3883077, 7113321};
		int[] arr2 = {1318021, 2099722, 2560559, 3114833, 3985476};
		int j = 0;
		Map<String, Object> standard = null;
		for(int i = 1; i < arr1.length; i++) {
			if(arr1[i] > incomeSum) {
				standard = (Map<String, Object>) rateDict.get(String.valueOf(i+1));
				j = i - 1 ;
			} else if (i == 4) {
				standard = (Map<String, Object>) rateDict.get(String.valueOf(i+2));
				j = i;
			}
		}
		
		JSONObject object = new JSONObject();
		ArrayList<Double> list = null;
		for(Entry<String, Object> ent : map.entrySet()) {
			list = new ArrayList<>();
			double db = (double) ((Integer) ent.getValue()).intValue();
			list.add(db / 3);
			list.add((Double) standard.get(ent.getKey()) * incomeSum / arr1[j] * arr2[j]); 
			object.put(ent.getKey(), list);
		}
		return object;
	}
	public JSONObject getCardDataCat(String userId) throws RestClientException, ParseException, IOException {
		List<CardDataDTO> cardData = getCardData(userId);
		JSONObject object = new JSONObject();
		String cat = null;
		for(CardDataDTO dto : cardData) {
			cat = dto.getCat();
			object.putIfAbsent(cat, new JSONArray());
			((JSONArray) object.get(cat)).add(dto);
		}
		return object;
	}	
	public JSONObject getCardDataCatCouple(String userId1, String userId2) throws RestClientException, ParseException, IOException {
		List<CardDataDTO> cardData = getCardDataCouple(userId1, userId2);
		JSONObject object = new JSONObject();
		String cat = null;
		for(CardDataDTO dto : cardData) {
			cat = dto.getCat();
			object.putIfAbsent(cat, new JSONArray());
			((JSONArray) object.get(cat)).add(dto);
		}
		return object;
	}
	
	public JSONArray getStockData(String userId) throws RestClientException, ParseException, IOException {
		apiService.stockCntrList("account", "ordDate");
		return searchTool.searchId("sample_stock_own", "userId", userId);
	}
	
	public JSONArray getStockDataCouple(String userId1, String userId2) throws RestClientException, ParseException, IOException {
		apiService.stockCntrList("account", "ordDate");
		apiService.stockCntrList("account", "ordDate");
		JSONArray result = new JSONArray();
		result.addAll(searchTool.searchId("sample_stock_own", "userId", userId1));
		result.addAll(searchTool.searchId("sample_stock_own", "userId", userId2));
		return result;
	}
}