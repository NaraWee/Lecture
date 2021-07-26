package com.greedy.section03.subsection02.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;

public class Handler implements InvocationHandler {

	private final GreedyStudent student;
	
	public Handler(GreedyStudent student) {
		this.student = student;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("============== 공부가 너무 하고 싶습니다. ==============");
		System.out.println("호출 대상 메소드 : " + method);
		for (Object arg : args) {
			System.out.println("전달된 인자 : " + arg);
		}
		
		method.invoke(student, args);
		System.out.println("========== 공부를 마치고 수면 학습을 시작합니다. ==========");
		
		return proxy;
	}

}
