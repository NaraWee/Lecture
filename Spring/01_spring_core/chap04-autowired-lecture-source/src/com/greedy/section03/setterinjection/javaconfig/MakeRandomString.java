package com.greedy.section03.setterinjection.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {

	private RandomGenerator random;
	
	public MakeRandomString() {}
	
	@Autowired
	public void setRandom(RandomGenerator random) {
		this.random = random;
	}
	
	public String getRnadomLengthString() {
		StringBuilder sb = new StringBuilder();
		
		int randomNumber = random.getRandomNumber();
		for(int i = random.getStartNum(); i <= randomNumber; i++) {
			
			sb.append("*");
		}
		
		return sb.toString();
	}
}
