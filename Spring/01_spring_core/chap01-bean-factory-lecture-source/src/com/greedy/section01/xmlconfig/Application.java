package com.greedy.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		/* IoC컨테이너라 불리는 존재의 최상위 인터페이스 Bean Factory 확인 */
		/*
		 * BeanFactory란?
		 * 스프링 컨테이너의 최상위 컨테이너이며, ApplicationContext와 함께 스프링 컨테이너라고 한다.
		 * Bean의 생성과 설정, 관리 등의 역할을 맡고있다.
		 */
		
		/* 패키지이지만 물리적으로는 폴더이기 때문에 위치를 찾을 때는 하위 폴더를 구분하는 /로 해야한다.
		 * (혹은 \\로도 가능하지만 .으로는 구분 못한다.)
		 */
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section01/xmlconfig/spring-context.xml");
		
		System.out.println(context);
		
		/* 1. bean의 id를 이용해서 bean을 가져오는 방법
		 * id를 이용하는 경우 bean의 정확한 type을 유추할 수 없기 때문의 Object타입으로 반환하므로
		 * 다운캐스팅해서 사용한다.
		 */
//		MemberDTO member = (MemberDTO) context.getBean("member");
		
		/* 2. Bean의 클래스 메타 정보를 전달하여 가져오는 방법 
		 * 가져오려는 bean의 타입을 명확히 전달하기 때문에 형변환이 필요없다.
		 */
//		MemberDTO member = context.getBean(MemberDTO.class);
		
		/* 3. bean의 id와 클래스 메타정보를 전달하여 가져오는 방법
		 * 가져오려는 bean의 타입을 전달하기 때문에 형변환이 필요 없다.
		 */
		MemberDTO member = context.getBean("member",MemberDTO.class);
		
		System.out.println(member);
	}

}
