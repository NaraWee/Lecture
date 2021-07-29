package com.greedy.section01.connection.javaconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.connection.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		System.out.println("전체 메뉴 조회하기");
		
		MenuService menuService = context.getBean("menuService",MenuService.class);
		
		List<MenuDTO> menuList = menuService.selectMenuList();
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
	}
}
