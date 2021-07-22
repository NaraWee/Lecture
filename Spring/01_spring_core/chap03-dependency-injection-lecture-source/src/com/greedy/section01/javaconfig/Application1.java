package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
	}

}
