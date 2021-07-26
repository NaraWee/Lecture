package com.greedy.section01.advice.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section01/advice/xmlconfig/config/spring-context.xml");
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		Student normalStudent = context.getBean("normalStudent",Student.class);
		
		System.out.println("========== NormalStudent ==========");
		AchievementResult normalResult = normalStudent.study(new Passion(10));
		System.out.println("NormalStudent Result : " + normalResult);
		
		
		
		Student greedyStudent = context.getBean("greedyStudent",Student.class);
		
		System.out.println("========== greedyStudent ==========");
		AchievementResult greedyResult = greedyStudent.study(new Passion(10));
		System.out.println("greedyStudent Result : " + greedyResult);
		
	}
}
