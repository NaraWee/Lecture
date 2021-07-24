package com.greedy.section01.singleton.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.singleton.javaconfig.Beverage;
import com.greedy.section01.singleton.javaconfig.Bread;
import com.greedy.section01.singleton.javaconfig.Product;
import com.greedy.section01.singleton.javaconfig.ShoppingCart;

@Configuration
public class ContextConfiguration {

	@Bean
	public Product carpBrad() {
		return new Bread("붕어빵",1000,new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		return new Beverage("딸기우유", 1500, 500);
	}
	
	@Bean
	public Product water() {
		return new Beverage("지리산암반수", 3000, 500);
	}
	
	@Bean
	@Scope("singleton") // 기본값
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
}
