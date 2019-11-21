package fakeserver.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class FakeServerService {
	@SuppressWarnings("unchecked")
	public JSONObject balanceCheck(JSONObject input) {
		JSONObject object = new JSONObject();
		object.put("출금계좌번호", "110184647880");
		object.put("출금계좌번호_MASK", "110-184-647880");
		object.put("지불가능잔액", "8140247");
		object.put("지불가능잔액_MASK", "8,140,247");
		return object;
	}
}
