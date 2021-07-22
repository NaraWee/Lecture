package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.javaconfig.Account;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration1 {

	@Bean
	public Account accountGenerator() {
		return new PersonalAccount(20, "110-123-45678", "1234");
	}
	
	/* 생성자를 통해 Account을 생성하는 메소드를 호출한 리턴값을 사용하여 bean을 조립할 수 있다. */
	@Bean
	public MemberDTO memberGenerator() {
		return new MemberDTO(1,"홍길동","010-1234-5678","hong123@greedy.com",accountGenerator());
	}
}
