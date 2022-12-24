package com.meaningfarm.mall;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
	
	@GetMapping({ "/", "/main" })
	public String main() {
		return "main";
	}
	
}

