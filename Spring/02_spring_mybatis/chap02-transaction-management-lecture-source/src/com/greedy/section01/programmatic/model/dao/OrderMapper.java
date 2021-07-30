package com.greedy.section01.programmatic.model.dao;

import com.greedy.section01.programmatic.model.dto.OrderDTO;
import com.greedy.section01.programmatic.model.dto.OrderMenuDTO;

public interface OrderMapper {

	/* 주문 테이블에 insert하기 위한 용도의 메소드 */
	int insertOrder(OrderDTO order);
	
	/* 주문별 메뉴 테이블에 insert 하기 위한 용도의 메소드 */
	int insertOrderMenu(OrderMenuDTO orderMenu);
}
