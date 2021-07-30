package com.greedy.section02.aop.xmlconfig.model.dao;

import com.greedy.section02.aop.xmlconfig.model.dto.OrderDTO;
import com.greedy.section02.aop.xmlconfig.model.dto.OrderMenuDTO;

public interface OrderMapper {

	/* 주문 테이블에 insert하기 위한 용도의 메소드 */
	int insertOrder(OrderDTO order);
	
	/* 주문별 메뉴 테이블에 insert 하기 위한 용도의 메소드 */
	int insertOrderMenu(OrderMenuDTO orderMenu);
}
