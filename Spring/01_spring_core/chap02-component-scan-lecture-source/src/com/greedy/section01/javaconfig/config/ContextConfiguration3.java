package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.greedy.section01.javaconfig.MemberDAO;

@Configuration
/*
 * basePackage의 기본 설정 경로를 지정하고 useDefaultFilters를 false로 하여
 * 모든 어노테이션을 스캔하지 않는다.
 * 이때 스캔할 대상 클래스만 따로 지정할 수도 있다.
 */
@ComponentScan(basePackages = "com.greedy.section01.javaconfig",
               useDefaultFilters = false,
               includeFilters = {
            		   @ComponentScan.Filter(
            				   /* exclude 필터 설정하는 방식과 동일하다. */
            				   type=FilterType.ASSIGNABLE_TYPE,
            				   classes = { MemberDAO.class }
            				   )
               })
public class ContextConfiguration3 {

}
