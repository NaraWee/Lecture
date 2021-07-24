package com.greedy.section05.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PoketmonService {

	/* @Inject는 @Autowired 와 유사하게 타입을 이용해서 빈을 자동 연결한다.
	 * 마찬가지로 bean이 여러개면 모호성으로 인해 의존성을 주입할 수 없다.
	 * 컬렉션 형태로 변경하면 가능하다.
	 */
	
	/* 1. 필드 주입 */
//	@Inject
////	@Named("pikachu")		// 같은 타입의 여러 빈을 collection으로 받을 때 이걸로 bean을 선택할 수 있다.
//	@Qualifier("pikachu")	// import를 스프링용으로 하면 적용 가능
//	private Poketmon poketmon;
//	
//	public void poketmonAttack() {
//		poketmon.attack();
//	}
	
	/* 2. 생성자 주입 */
	private Poketmon poketmon;
	
//	@Inject
//	@Named("pikachu")
//	public PoketmonService(Poketmon poketmon) {
//		this.poketmon = poketmon;
//	}
	
	// 파라미터 레벨에서 사용 가능
//	@Inject
//	public PoketmonService(@Named("pikachu") Poketmon poketmon) {
//		this.poketmon = poketmon;
//	}

	/* 3. 세터 주의 */
//	@Inject
//	@Named("pikachu")
//	public void setPoketmon(Poketmon poketmon) {
//		this.poketmon = poketmon;
//	}
	
	// 파라미터 레벨에서 사용 가능
	@Inject
	public void setPoketmon(@Named("pikachu") Poketmon poketmon) {
		this.poketmon = poketmon;
	}
	
	public void poketmonAttack() {
		poketmon.attack();
	}

}
