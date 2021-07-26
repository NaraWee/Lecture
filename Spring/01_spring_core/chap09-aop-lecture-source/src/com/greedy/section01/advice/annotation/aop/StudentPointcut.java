package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.annotation.Pointcut;

public class StudentPointcut {

	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void studyPointcut() {
		
		
		
	}
	
}
