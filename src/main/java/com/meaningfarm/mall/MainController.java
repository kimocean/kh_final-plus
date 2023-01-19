package com.meaningfarm.mall;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.meaningfarm.mall.member.MemberService;

@Controller
public class MainController {
	
	
//	@GetMapping({ "/", "/main" })
//	public String main() {
//		return "main";
//	}
	
//	@GetMapping("header")
//	public String header() {
//		return "header";
//	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
}

