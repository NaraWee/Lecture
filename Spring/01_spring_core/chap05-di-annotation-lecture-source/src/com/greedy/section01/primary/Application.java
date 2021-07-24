package com.greedy.section01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* 한 개의 인터페이스를 상속받은 여러 클래스를 모두 Bean으로 등록한 경우에 대해서 알아보자
		 * 여러 타입의 Bean이 존재하는 경우 자동연결시 어떠한 빈을 주입할지에 대한 여부가 확실하지 않아 에러가 발생한다.
		 * @Autowired는 타입이 일치하는 객체를 자동으로 주입하기 때문이다.
		 */
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.greedy.section01.primary");
		
		PoketmonService poketmonService = context.getBean("poketmonService",PoketmonService.class);
		
		poketmonService.poketmonAttack();
	}
}
