package com.greedy.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

	/* bean을 등록하기 위해서는 @Bean 어노테이션을 이용한다. */
	/*
	 * @Bean(name="myName") 혹은 @Bean("myName")을 이용하여 bean의 id를 성정할 수 있다.
	 * 이 때 bean의 이름을 지정하지 않으면 메소드의 이름을 bean의 id로 자동 인식한다.
	 */
	@Bean(name="member")
	public MemberDTO getMember() {
		return new MemberDTO(1,"user01","pass01","홍길동");
	}
}
