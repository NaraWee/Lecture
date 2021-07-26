package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.annotation.GreedyStudent;

@Aspect
@Component
public class AroundAttendingAdvice {

	/*
	 *  Around Advice는 가장 강력한 어드바이스이다.
	 *  이 어드바이스는 조인포인트를 완전히 장악하기 때문에
	 *  앞에 살펴 본 어드바이스 모두 Around 어드바이스로 조합할 수 있다.
	 *  심지어 원본 조인 포인트를 언제 실행할지, 실행 자체를 안할지, 계속 실행할지 여부까지도 제어한다.
	 *  
	 *  AroundAdvice의 조인포인트는 매개변수는 ProceedingJoinPoint로 고정되어 있다.
	 *  JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
	 */
	
//	@Around("execution(* com.greedy.section01.advice.annotation..*(..))")
	@Around("studentAroundPointcut()")
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
	
	/* 포인트 컷은 void형 메소드로 작성하고 표현식을 작성한 뒤 메소드 이름이 포인트컷의 이름이 된다.*/
	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))")
	private void studentAroundPointcut() {
		
	}
	
}
