package com.meaningfarm.mall.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
	Auth findOneByAuthId(Long AuthId);
}