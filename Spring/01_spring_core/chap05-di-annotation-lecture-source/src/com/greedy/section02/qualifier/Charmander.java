package com.greedy.section02.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Poketmon {

	@Override
	public void attack() {
		System.out.println("파이리가 공격을 합니다.");
	}

}
