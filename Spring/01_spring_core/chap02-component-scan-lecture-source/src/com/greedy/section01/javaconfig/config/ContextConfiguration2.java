package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.greedy.section01.javaconfig.MemberDAO;

/* excludeFilter로 스캐닝에서 제외할 타입을 기술하면 해당 타입은 스캐닝에서 제외한다. */

@Configuration
@ComponentScan(basePackages = "com.greedy.section01.javaconfig",
               excludeFilters = {
            		   @ComponentScan.Filter(
            				   /* 1. 타입으로 설정 ASSIGNABLE_TYPE -> 클래스타입으로 */
//            				   type=FilterType.ASSIGNABLE_TYPE,
//            				   classes = { MemberDAO.class }
            				   /* 2. 어노테이션 종류로 설정 */
//            				   type=FilterType.ANNOTATION,
//            				   classes = { org.springframework.stereotype.Component.class }
            				   /* 3. 표현식으로 설정 */
//            				   type=FilterType.REGEX,
//            				   pattern = {"com.greedy.section01.*"}
            				   /* 4. ASPECTJ : 포인트컷 표현식으로 클래스를 매치하는 용도 */
            				   )
            		   }
               )
public class ContextConfiguration2 {

}
