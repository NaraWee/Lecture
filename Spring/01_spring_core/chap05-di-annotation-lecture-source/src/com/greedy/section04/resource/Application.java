package com.greedy.section04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		/*
		 * 스프링 전용인 @Autowired 대신 자바 표준 어노테이션 @Resource로 POJO 연결
		 * 
		 * 스프링이 @Autowired를 처음 선보이고 얼마지나지 않아 자바 진영에서도 동일한 기능의 어노테이션을 여러 개 표준화했다.
		 * @Resource와 @Inject, @named
		 * 
		 * @Autowired와 @Qualifier와 같은 의미이다.
		 * 동일 타입의 여러 개의 bean이 있는 경우 대상이 모호할 때 대상을 명확하게 한다.
		 */
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.greedy.section04.resource");
		
		PoketmonService poketmonService = context.getBean("poketmonService",PoketmonService.class);
		
		poketmonService.poketmonAttack();
		
	}
}
