package com.greedy.section05.inject;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Poketmon {

	@Override
	public void attack() {
		System.out.println("파카츄가 공격을 합니다");
	}

}
