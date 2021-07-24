package com.greedy.section01.singleton.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.singleton.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
		
		/*
		 * 현재 빈 구성은 singleton으로 설정되어있다.(기본값)
		 * singleton은 IoC컨테이너당 하나의 인스턴스만 생성한다.
		 * singleton		IoC컨테이너당 빈 인스턴스 하나를 생성한다.
		 * prototype		요청할 때마다 빈 인스턴스를 새로 만든다.
		 * request			HTTP 요청당 하나의 빈 인스턴스를 생성한다. 웹 어플리케이션 컨텍스트에만 해당된다.
		 * session			HTTP 세션당 빈 인스턴스 하나를 생성한다. 웹 어플리케이션 컨텍스트에만 해당된다.
		 * globalSession	전역 HTTP 세션당 빈 인스턴스 하나를 생성한다. 포털 어플리케이션 컨텍스트에만 해당된다.
		 */
		
		Product carpBrad = context.getBean("carpBrad", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBrad);
		cart1.addItem(milk);
		
		System.out.println("cart1에 담긴 내용 : " + cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(water);
		
		System.out.println("cart2에 담긴 내용 : " + cart2.getItem());
		
		System.out.println("cart1의 hashcode : " + cart1.hashCode());
		System.out.println("cart1의 hashcode : " + cart2.hashCode());
		
	}

}
