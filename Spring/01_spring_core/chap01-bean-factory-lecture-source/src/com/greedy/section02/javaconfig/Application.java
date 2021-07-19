package com.greedy.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		System.out.println(context);
		
		MemberDTO member = context.getBean("member",MemberDTO.class);
//		MemberDTO member = context.getBean("getMember",MemberDTO.class);    // -> name 없을때 사용
		System.out.println(member);
	}

}
