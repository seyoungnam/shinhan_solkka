package solkka.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import solkka.service.SolkkaService;

@RestController
public class SolkkaController {
	@Autowired
	SolkkaService service;
	
	@PostMapping("/sign")
	public void singUp(@RequestParam("signUp") String signUp) throws Exception {
		System.out.println(signUp);
		System.out.println("singUp TEST");
	}
	@PostMapping("/logIn")
	public void logIn(@RequestParam("logIn") String logIn) throws Exception {
		System.out.println(logIn);
		System.out.println("logIn TEST");
	}

	@PostMapping("/accountList")
	public JSONObject accountList(@RequestBody JSONObject body) throws RestClientException, ParseException {
		System.out.println("// accountList");
		System.out.println(body);
		return service.accountList(body.get("number").toString());
	}
}