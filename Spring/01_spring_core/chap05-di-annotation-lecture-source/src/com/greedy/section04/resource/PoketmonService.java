package com.greedy.section04.resource;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PoketmonService {

	/* 기본적으로 이름으로 주입받는다. 하지만  빈의 이름이 일치하지 않으면 타입으로 주입받는다.
	 * 하지만 동일한 타입의 bean이 있는 경우에는 주입받지 못한다.
	 */
	/* 1. 같은 타입의 bean이 여러개 */
//	@Resource(name="charmander")
//	private Poketmon poketmon;
//	
//	public void poketmonAttack() {
//		poketmon.attack();
//	}
	
//	@Resource
//	@Qualifier("squirtle")
//	private List<Poketmon> poketmonList;
//	
//	public void poketmonAttack() {
//		for(Poketmon poketmon : poketmonList) {
//			poketmon.attack();
//		}
//	}
	
	/* 2. 같은 타입의 bean이 한 개 일떄 (Charmander 와 Squirtle 두 개의 @Component 주석) */
//	private Poketmon poketmon;
//	
//	/* @Resource는 생성자 주입을 하지 못한다.(애초에 에러발생) */
//	@Resource
//	public PoketmonService(Poketmon poketmon) {
//		this.poketmon = poketmon;
//	}
	
	/* @Resource는 세터 주입은 가능하다. */
	private Poketmon poketmon;
	
	@Resource
	public void setPoketmon(Poketmon poketmon) {
		this.poketmon = poketmon;
	}
	
	public void poketmonAttack() {
		poketmon.attack();
	}
}
