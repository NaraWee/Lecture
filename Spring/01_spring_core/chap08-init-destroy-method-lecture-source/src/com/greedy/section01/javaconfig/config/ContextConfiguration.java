package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.javaconfig.Beverage;
import com.greedy.section01.javaconfig.Bread;
import com.greedy.section01.javaconfig.Owner;
import com.greedy.section01.javaconfig.Product;
import com.greedy.section01.javaconfig.ShoppingCart;

@Configuration
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
	
	/* init 메소드는 동작하지만 destroy 메소드는 현 세점에서는 동작하지 않는다.
	 * Why? 가비지컬렉터가 해당 빈을 메모리에서 지울 때 동작하게 되는데 메모리에서 지우기 전에 프로세스는 종료되기 때문에 호출 될 수 없다.
	 * --> 여기에서는 설정하는 방법만 기억해두자
	 */
	@Bean(initMethod = "openShop", destroyMethod = "closeShop")
	public Owner owner() {
		return new Owner();
	}
}
