package fakeserver.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
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
	
	@PostMapping("/bank")
	/*
		{
		"dataHeader":
		{
		},
		"dataBody":
		{
		 "serviceCode":"D2004",
		 "출금은행구분":"1",
		 "출금계좌번호":"110-184-647880",
		 "비밀번호체크유무":"1"
		}
		}
	 */
	public JSONObject bankapi(@RequestBody String body) throws Exception {
		System.out.println("신한은행 API");
		JSONObject input = new JSONObject(new JSONParser(body).parseObject());
		return service.serviceCode(input.get("serviceCode").toString());
	}
}