package com.greedy.section02.mapperscan.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section02.mapperscan.model.dto.MenuDTO;
import com.greedy.section02.mapperscan.model.service.MenuService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section02/mapperscan/config/spring-context.xml");
		
		System.out.println("전체 메뉴 조회하기");
		
		MenuService menuService = context.getBean("menuService",MenuService.class);
		
		List<MenuDTO> menuList = menuService.selectMenuList();
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
	}
}
