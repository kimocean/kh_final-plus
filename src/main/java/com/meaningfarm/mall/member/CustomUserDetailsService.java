package com.meaningfarm.mall.member;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
 
	private final MemberRepository memberRepository;
 
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String memberId) {
 
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Member member = memberRepository.findOneByMemberId(memberId);
 
		if (member != null) {
			for (Auth auth : member.getAuths()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(auth.getAuthName())); // DB에 저장되어 있는 권한을 부여한다.
			}
			return new User(member.getMemberId(), member.getMemberPw(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("can not find User : " + memberId);
		}
	}
	
}
