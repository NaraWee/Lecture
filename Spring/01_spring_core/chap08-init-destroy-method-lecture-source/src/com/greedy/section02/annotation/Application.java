package com.greedy.section02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.annotation.config.ContextConfiguration;



public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		Product carpBread = context.getBean("carpBread", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(milk);
		
		System.out.println("cart1에 담긴 내용 : " + cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(water);
		
		System.out.println("cart2에 담긴 내용 : " + cart2.getItem());
		
		System.out.println("cart1의 hashcode : " + cart1.hashCode());
		System.out.println("cart1의 hashcode : " + cart2.hashCode());
		
		/* 강제로 컨테이너를 종료시키면 폐기 메소드기 동작한다. */
		((AnnotationConfigApplicationContext) context).close();
	}

}
