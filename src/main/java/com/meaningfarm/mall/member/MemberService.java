package com.meaningfarm.mall.member;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
 
	private final MemberRepository memberRepository;
	private final AuthRepository authRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
 
	public void insert(MemberDTO memberDTO) {
		memberDTO.setMemberPw(bCryptPasswordEncoder.encode(memberDTO.getMemberPw()));
		Set<Auth> authsSet = new HashSet<Auth>();
		System.out.println("auth id 테스트 " + memberDTO.getAuthId());
		if(memberDTO.getAuthId() == 2) {
			authsSet.add(authRepository.findOneByAuthId(2L)); // id :2 ROLE_SELLER 역할
		} else {
			authsSet.add(authRepository.findOneByAuthId(3L)); // id : 3 ROLE_USER 역할
		}
		memberRepository.save(memberDTO.toEntity(authsSet));
	}
	
	public HashMap<String, Object> memberIdOverlap(String memberId) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("result", memberRepository.existsByMemberId(memberId));
		return map;
	}
	
	public Member memberPage(String memberId) {
		return memberRepository.findOneByMemberId(memberId);
	}
}