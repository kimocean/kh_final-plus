package com.meaningfarm.mall.member;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.meaningfarm.mall.reply.Reply;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "MEMBER")
@DynamicUpdate
public class Member {
 
	@Id
	@Column(name = "member_id")
	private String memberId;
 
	@Column(name = "member_pw")
	private String memberPw;
 
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_phone")
	private String memberPhone;
	
	@Column(name = "member_email")
	private String memberEmail;
	
	@Column(name = "member_address")
	private String memberAddress;
	
	@Column(name = "member_zipcode")
	private Integer memberZipcode;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "auth_member", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "auth_id"))
	private Set<Auth> auths;
	
	@OneToMany(mappedBy = "member")
	private List<Reply> replyList;
 
	@Builder
	public Member(String memberId, String memberPw, String memberName, String memberPhone, String memberEmail, 
				  String memberAddress, Integer memberZipcode, Set<Auth> auths) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberZipcode = memberZipcode;
		this.auths = auths;
	}
}