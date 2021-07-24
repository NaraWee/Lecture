package com.greedy.section02.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Poketmon {

	@Override
	public void attack() {
		System.out.println("꼬부기가 공격을 합니다.");
	}

}
