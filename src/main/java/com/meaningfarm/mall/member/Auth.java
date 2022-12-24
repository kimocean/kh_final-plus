package com.meaningfarm.mall.member;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "auth")
public class Auth {
 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "auth_id")
	private Long authId;
 
	@Column(name = "auth_name")
	private String authName;
 
	@ManyToMany(mappedBy = "auths")
	private Set<Member> members;
}