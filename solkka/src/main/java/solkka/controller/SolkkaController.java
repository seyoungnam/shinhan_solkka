package solkka.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import solkka.service.SolkkaService;

@RestController
public class SolkkaController {
	@Autowired
	SolkkaService service;
	
	@PostMapping("/apiTest")
	public JSONObject apiTest(@RequestBody JSONObject body) throws Exception {
		System.out.println("API TEST");
		return service.callApi(body);
	}
	
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
}