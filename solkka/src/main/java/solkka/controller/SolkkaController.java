package solkka.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
