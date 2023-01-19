package com.meaningfarm.mall.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/sample")
	public String sample() {
		return "sample";
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
	
	@GetMapping("/header")
	public String header(Model model, String memberId) {
		model.addAttribute("memberId", memberService.memberPage(memberId));
		System.out.println(memberId);
		return "header";
	}
	
	@GetMapping("/member/memberPage/{memberId}")
	public String memberPage(Model model, @PathVariable("memberId") String memberId) {
		model.addAttribute("memberId", memberService.memberPage(memberId));
		return "member/memberPage";
	}
	
	@GetMapping("/member/sellerPage")
	public String sellerPage(HttpServletRequest request) {
		return "member/sellerPage";
	}
	
	@GetMapping("/member/adminPage")
	public String adminPage(HttpServletRequest request) {
		return "member/adminPage";
	}
	
}
