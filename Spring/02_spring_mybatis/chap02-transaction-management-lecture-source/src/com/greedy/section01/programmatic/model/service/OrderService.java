package com.greedy.section01.programmatic.model.service;

import com.greedy.section01.programmatic.model.dto.OrderDTO;

public interface OrderService {

	/* 주문을 등록하는 용도의 서비스 메소드 */
	int registOrder(OrderDTO order);
	
	int registOrder2(OrderDTO order);
}
