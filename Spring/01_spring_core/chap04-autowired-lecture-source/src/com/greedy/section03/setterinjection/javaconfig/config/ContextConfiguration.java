package com.greedy.section03.setterinjection.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.greedy.section03.setterinjection.javaconfig.RandomGenerator;
import com.greedy.section03.setterinjection.javaconfig.RandomNumberGenerator;

@Configuration
@ComponentScan("com.greedy.section03.setterinjection.javaconfig")
public class ContextConfiguration {

	@Bean
	public RandomGenerator randomGenerator() throws Exception {
		
		return new RandomNumberGenerator(1,10);
	}
}
