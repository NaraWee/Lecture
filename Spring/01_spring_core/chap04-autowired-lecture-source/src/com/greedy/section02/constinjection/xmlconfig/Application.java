package com.greedy.section02.constinjection.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new GenericXmlApplicationContext("com/greedy/section02/constinjection/xmlconfig/config/spring-context.xml");
		
		MakeRandomString randomString = context.getBean(MakeRandomString.class);
		
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
	}
}
