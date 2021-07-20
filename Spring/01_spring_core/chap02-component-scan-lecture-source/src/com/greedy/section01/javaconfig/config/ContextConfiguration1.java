package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* basePackages에 등록되지 않은 패키지는 스캔에서 제외하고, 등록된 패키지 내의 @Component 어노테이션을 탐색한다.
 * 이 때 basePackage를 등록하지 않으면 현 설정클래스가 존재하는 패키지를 자동으로 basePackage로 설정한다.
 * 문자열 배열 형태로 여러 basePackage를 등록할 수 있다.
 */
@Configuration
//@ComponentScan(basePackages = "com.greedy.section01.javaconfig")
public class ContextConfiguration1 {

	
}
