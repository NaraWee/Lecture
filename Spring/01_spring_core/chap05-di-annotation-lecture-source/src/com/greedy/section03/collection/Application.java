package com.greedy.section03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		/* 세 개의 빈 모두 사용해야 하는 경우
		 * 이 때는 의존성 주입을 받을 필드의 타입을 변경해야된다.
		 */
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.greedy.section03.collection");
		
		PoketmonService poketmonService = context.getBean("poketmonService",PoketmonService.class);
		
		poketmonService.poketmonAttack();
		
	}
}
