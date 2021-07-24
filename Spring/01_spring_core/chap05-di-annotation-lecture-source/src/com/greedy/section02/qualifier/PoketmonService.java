package com.greedy.section02.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PoketmonService {
	
	/* 필드 주입을 이용하는 경우 */
	/*
	 * @Qualifier 어노테이션으로 의존성 주입을 하는 경우 타입이 아닌 이름(id)로 주입을 한다.
	 * @Primary로 우선권을 지정한 것보다 더 우선권을 가진다.
	 */
//	@Autowired
//	@Qualifier("squirtle")
	private Poketmon poketmon;
	
	/* 생성자 주입을 이용하는 경우 */
	@Autowired
	public PoketmonService(@Qualifier("squirtle") Poketmon poketmon) {
		this.poketmon = poketmon;
	}

	public void poketmonAttack() {
		poketmon.attack();
	}
}
