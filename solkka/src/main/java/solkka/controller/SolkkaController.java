package solkka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SolkkaController {
	@RequestMapping("/main")
	public String login(@RequestParam(value="id") String id, @RequestParam(value="password") String pw) {
		System.out.println("2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+id+pw);
		return "main";
	}
	
	@RequestMapping("/asset")
	public String asset() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		return "asset";
	}
}
