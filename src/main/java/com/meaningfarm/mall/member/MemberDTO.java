package com.meaningfarm.mall.member;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Integer memberZipcode;
	private Long authId;
	private Set<Long> auths;
 
	public Member toEntity(Set<Auth> auths) {
		return Member.builder().memberId(memberId).memberPw(memberPw).memberName(memberName)
				.memberPhone(memberPhone).memberEmail(memberEmail).memberAddress(memberAddress)
				.memberZipcode(memberZipcode).auths(auths).build();
	}
}
