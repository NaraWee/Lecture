package com.greedy.section02.constinjection.xmlconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {

	private RandomGenerator random;
	
	public MakeRandomString() {}
	
	/*
	 * 생성자 주입의 장점
	 * 1. 필드 주입이 간단하긴 하지만 단일책임의 원칙 관점에서 볼 때 필드는 많은 빈들을 주입받을 수 있다.
	 * 2. 필드에 final 키워드 사용이 가능해진다. 따라서 변경 불가능하게 사용할 수 있다.
	 * 3. 순환참조 방지 (필드 주입이나 세터 주입의 경우 메소드 실행 시점에만 발생할 수 있지만,
	 *               생성자 주입을 하면 애플리케이션 실행 시점에 확인 가능하다.)
	 * 4. DI컨테이너가 결합도가 낮기 때문에 테스트하기 좋다.
	 */
	
	@Autowired
	public MakeRandomString(RandomGenerator random) {
		/* 스프링 4.3 이후부터 생성자에 주입할 시 생성자가 한 개 뿐이라면
		 * 해당 생성자에 @Autowired 어노테이션을 생략해도 자동으로 주입해준다.
		 * @Autowired는 타입으로 일치하는 빈을 우선적으로 적용하기 때문에 이름이 달라도 상관없다.
		 */
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
