package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.xmlconfig.GreedyStudent;

public class AroundAttendingAdvice {

	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("==================== around attending before ====================");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지 라는 마음을 가득 품고 아침 일찍 일어납니다.ㅇ.ㅇㅇ.ㅇ..ㅇ.ㅇ.~");
		System.out.println("=================================================================");
		
		/* 공부 시간을 체크하기 위해 스탑워치를 켠다. */
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		/* 원본 조인포인트를 실행한다. */
		Object result = joinPoint.proceed();
		
		System.out.println("==================== around attending after =====================");
		
		/* 만약에 Greedy학생이면 학원 문이 닫을 때 까지 열심히 스터디를 합니다. */
		if(joinPoint.getTarget() instanceof GreedyStudent) {
			System.out.println("수업이 끝나도 학원이 닫을 때까지는 끝난게 아니다. 자율적 스터디 그룹과 함께 다시 공부합시다.");
		}
		
		System.out.println("열심히 공부했으니 퇴실 카드를 찍는다.");
		
		/* 퇴실 카드를 찍고 스탑워치를 종료한다. */
		stopWatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("================================================================");
		
		return result;
		
	}
	
	private void studentAroundPointcut() {
		
	}
	
}
