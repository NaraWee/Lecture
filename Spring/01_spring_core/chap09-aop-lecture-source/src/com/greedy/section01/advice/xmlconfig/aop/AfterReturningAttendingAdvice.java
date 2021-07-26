package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;

import com.greedy.section01.advice.xmlconfig.AchievementResult;

public class AfterReturningAttendingAdvice {

	public void afterReturningAttending(JoinPoint joinPoint, Object result) {
		
		System.out.println("========== after returning attending ==========");
		System.out.println("보람찬 하루일과를 끝마치고 두 다리 쭉 펴면 고향의 안방으로");
		System.out.println("오늘의 이해도 : " + ((AchievementResult) result).getUnderstandingScore());
		System.out.println("오늘의 만족도 : " + ((AchievementResult) result).getSatisfactionScore());
		
		/* 취업률 수치를 백분률로 환산해서 퍼센트로 변환해부자 */
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		System.out.println("증가된 취업률 : " + percent + "%");
		
		/* 리턴할 결과값을 변경해 줄 수 있다. */
		((AchievementResult) result).setEmployeementRate(percent);
		System.out.println("====================================");
	}
}
