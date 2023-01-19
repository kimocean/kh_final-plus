package com.meaningfarm.mall.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
	Member findOneByMemberId(String memberId);
	boolean existsByMemberId(String memberId);
}