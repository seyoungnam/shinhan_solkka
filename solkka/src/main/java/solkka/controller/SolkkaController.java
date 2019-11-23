package solkka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SolkkaController {
	@RequestMapping("/main")
	public String login() {
		return "main";
	}
	
	@RequestMapping("/asset")
	public String asset() {
		return "asset";
	}
	
	@RequestMapping("/conSelf")
	public String conSelf() {
		return "conSelf";
	}
	
	@RequestMapping("/conSpous")
	public String conSpous() {
		return "conSpous";
	}
	
	@RequestMapping("/couple")
	public String couple() {
		return "couple";
	}
}
