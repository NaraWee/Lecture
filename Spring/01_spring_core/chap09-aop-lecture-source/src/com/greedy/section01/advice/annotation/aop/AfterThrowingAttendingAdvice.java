package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAttendingAdvice {

	@AfterThrowing(pointcut = "execution(* com.greedy.section01.advice.annotation..*(..))", throwing = "exception")
	public void afterThrowingAttending(JoinPoint joinPoint, Throwable exception) {
		
		System.out.println("========== after throwing attending ==========");
		System.out.println(exception.getMessage());
		System.out.println("==============================================");
		
		
	}
	
}
