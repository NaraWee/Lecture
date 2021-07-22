package com.greedy.section03.setterinjection.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section02.constinjection.javaconfig.MakeRandomString;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section03/setterinjection/xmlconfig/config/spring-context.xml");
		
		MakeRandomString randomString = context.getBean(MakeRandomString.class);
		
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
		System.out.println(randomString.getRnadomLengthString());
	}
}
