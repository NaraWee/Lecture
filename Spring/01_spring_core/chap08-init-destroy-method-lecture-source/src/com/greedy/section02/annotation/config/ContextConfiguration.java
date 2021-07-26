package com.greedy.section02.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section02.annotation.Beverage;
import com.greedy.section02.annotation.Bread;
import com.greedy.section02.annotation.Product;
import com.greedy.section02.annotation.ShoppingCart;

@Configuration
@ComponentScan("com.greedy.section02.annotation")
public class ContextConfiguration {

	@Bean
	public Product carpBread() {
		return new Bread("붕어빵",1000,new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		return new Beverage("메론맛우유", 1500, 500);
	}
	
	@Bean
	public Product water() {
		return new Beverage("백두산암반수", 3000, 500);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
	
	
	
}
