package fakeserver.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class FakeServerService {
	public JSONObject serviceCode(String code) throws Exception {
		System.out.println(code);
		switch (code) {
		case "D2004":
			return d2004();
		default:
			throw new Exception("존재하지 않는 서비스 코드");
		}
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject d2004() {
		/*
		 * {"출금계좌번호":"110184647880",
		 * 	"출금계좌번호_MASK":"110-184-647880",
		 * 	"지불가능잔액":"8140247",
		 * 	"지불가능잔액_MASK":"8,140,247" } }
		 */
		JSONObject object = new JSONObject();
		object.put("출금계좌번호", "110184647880");
		object.put("출금계좌번호_MASK", "110-184-647880");
		object.put("지불가능잔액", "8140247");
		object.put("지불가능잔액_MASK", "8,140,247");
		return object;
	}
}
