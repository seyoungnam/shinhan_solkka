package fakeserver.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fakeserver.service.FakeServerService;

@RestController
public class FakeServerController {
	@Autowired
	FakeServerService service;
	
	@PostMapping("/v2/stocks/balance-check")
	public JSONObject balanceCheck(@RequestBody JSONObject body) throws Exception {
		System.out.println("** 잔액조회");
		return service.balanceCheck(body);
	}
}