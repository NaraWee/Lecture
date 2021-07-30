package com.greedy.section01.programmatic.run;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section01.programmatic.model.dto.OrderDTO;
import com.greedy.section01.programmatic.model.dto.OrderMenuDTO;
import com.greedy.section01.programmatic.model.service.OrderService;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 프로그래밍 레벨에서 트랜잭션 처리하는 방법
		 * 
		 * 기존에 마이바티스를 이용할 때는 sqlSession의 commit(), rollback() 메소드를 이용했었다.
		 * 하지만 스프링과 연동한 환경에서는 이 메소드를 사용하면 UnsupportOperationException 예외가 발생하게된다.
		 * 스프링과 연동한 환경에서 수동으로 트랜잭션을 제어하고자 한다면 PlatformTransactionManager를 사용해야한다.
		 * 참고 : https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#transaction-programmatic
		 */
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section01/programmatic/config/spring-context.xml");
		
		OrderService orderService = context.getBean("orderService",OrderService.class);
		
		
		Scanner sc = new Scanner(System.in);
	      
	      List<OrderMenuDTO> orderMenuList = new ArrayList<>();
	      orderMenu:
	      do {
	         System.out.println("============ 트랜젝션 레스토랑 음식 주문 서비스 ==============");
	         System.out.print("어떤 메뉴를 주문하시겠습니까?(코드입력) : ");
	         int menuCode = sc.nextInt();
	         System.out.print("주문 수량을 입력해주세요 : ");
	         int amount = sc.nextInt();
	         System.out.print("다른 메뉴를 추가로 주문하시겠습니까?(Y/N) : ");
	         sc.nextLine();
	         char continueYN = sc.nextLine().toUpperCase().charAt(0);
	         
	         OrderMenuDTO orderMenu = new OrderMenuDTO();
	         orderMenu.setMenuCode(menuCode);
	         orderMenu.setAmount(amount);
	         
	         orderMenuList.add(orderMenu);
	         
	         switch(continueYN) {
	            case 'Y' : break;
	            default : break orderMenu;
	         }
	         
	      } while(true);
	      
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	      SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	      OrderDTO order = new OrderDTO();
	      order.setDate(dateFormat.format(new java.util.Date(System.currentTimeMillis())));
	      order.setTime(timeFormat.format(new java.util.Date(System.currentTimeMillis())));
	      order.setMenuList(orderMenuList);
	      
	      System.out.println(order);
	      
	      /* 트랜잭션 처리 전 */
//	      int result = orderService.registOrder(order);
	      
	      /* 트랜잭션 처리 후 */
	      int result = orderService.registOrder2(order);
	      
	      if(result > 0) {
	    	  System.out.println("메뉴 주문에 성공하셨습니다.");
	      } else {
	    	  System.out.println("메뉴 주문에 실패하셨습니다.");
	      }
	}
}
