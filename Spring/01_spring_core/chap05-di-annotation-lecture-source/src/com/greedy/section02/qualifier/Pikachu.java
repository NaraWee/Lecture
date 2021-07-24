package com.greedy.section02.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pikachu implements Poketmon {

	@Override
	public void attack() {
		System.out.println("파카츄가 공격을 합니다");
	}

}
