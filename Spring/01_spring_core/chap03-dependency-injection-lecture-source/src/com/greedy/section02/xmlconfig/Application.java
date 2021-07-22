package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context.xml");
		
		MemberDTO member = context.getBean(MemberDTO.class);
		Account acc = context.getBean(Account.class);
		
		System.out.println(member);
		System.out.println(acc);
		
		System.out.println(member.getPersonAccount().getBalance());
	}

}
