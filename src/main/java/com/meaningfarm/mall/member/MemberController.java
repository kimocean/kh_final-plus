package com.meaningfarm.mall.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping({ "/", "/main" })
	public String main() {
		return "main";
	}
	
	@GetMapping("/signup")
	public String usersignup(HttpServletRequest request) {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUp(@ModelAttribute("memberDTO") MemberDTO memberDTO) {
		memberService.insert(memberDTO);
		return "redirect:/main";
//		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		return "login";
	}
	
}
