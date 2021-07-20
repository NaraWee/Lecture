package com.greedy.section01.javaconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/*
 * 인터페이스로 메소드를 강제화한 후 구현하여 사용하면 강제성이 부여된다.
 * 또한 결합관계를 느슨하게 만들 수 있다.
 */

/*
 * 스프링 컨테이너가 스캐닝 기능을 이용하여 해당 클래스를 bean으로 등록할 수 있도록 어노테이션을 설정한다.
 * value 속성을 이용하여 bean의 id를 설정할 수 있으며, value는 생략 가능하다.
 * 이름(id)를 설정하지 않으면 class의 앞글자를 소문자로 하여 bean으로 생성한다.
 * @Component는
 * @Controller, @Service, @Repository와 동일한 기능을 가지지만 각 계층을 표현하는 어노테이션은
 * 특정 용도에 맞는 부가적인 혜택이 있으니 계층별로 구분하여 사용하는 것이 좋다.
 * Component : 스프링에서 관리되는 객체임을 표시하기 위해 사용하는 가장 기본적인 어노테이션이다.
 * @Controller : Web MVC 코드에서 사용되는 어노테이션으로 @RequestMapping 어노테이션은 해당 어노테이션이 작성된 클래스 내에서만 사용 가능하다.
 * @Service : 비즈니스 로직이 작성된 클래스에 사용한다. 추가적인 기능은 없지만 추가적인 기능을 제공할 가능성이 있으니 계층을 명시할 때 사용한다.
 * @Repository : 플랫폼별 예외를 포착하여 PersistenceExceptionTransacttionPostProcesser가 DataAccessException으로 변환하여 다시 발생한다.
 * 계층이 명확하지 않은 경우에는 @Component를 사용한다.
 */

@Component(value="memberDAO")
public class MemberDAOImpl implements MemberDAO {

	private final Map<Integer, MemberDTO> memberMap;
	
	public MemberDAOImpl() {
		memberMap = new HashMap<Integer, MemberDTO>();
		
		memberMap.put(1, new MemberDTO(1,"user01","pass01","홍길동"));
		memberMap.put(2, new MemberDTO(2,"user02","pass02","유관순"));
	}
	
	/* 매개변수로 전달받은 회원 번호를 map에서 조회 후 리턴해주는 메소드 */
	@Override
	public MemberDTO selectMember(int sequence) {

		return memberMap.get(sequence);
	}

	/* 매개변수로 전달받은 회원 정보를 map에 추가하고 성공 실패 여부를 boolean으로 리턴하는 메소드 */
	@Override
	public boolean insertMember(MemberDTO newMember) {
		
		int before = memberMap.size();
		
		memberMap.put(newMember.getSequence(), newMember);
		
		int after = memberMap.size();
		
		return (after > before)? true: false;
	}

	
}
