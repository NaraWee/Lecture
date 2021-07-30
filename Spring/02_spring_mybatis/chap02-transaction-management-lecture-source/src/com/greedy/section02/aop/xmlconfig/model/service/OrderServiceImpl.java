package com.greedy.section02.aop.xmlconfig.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.section02.aop.xmlconfig.model.dao.OrderMapper;
import com.greedy.section02.aop.xmlconfig.model.dto.OrderDTO;
import com.greedy.section02.aop.xmlconfig.model.dto.OrderMenuDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private SqlSessionTemplate sqlSession;
	
	
	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int registOrder(OrderDTO order) {
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		int orderResult = orderMapper.insertOrder(order);
		
		List<OrderMenuDTO> orderMenuList = order.getMenuList();
		int orderMenuResult = 0;
		
		for(OrderMenuDTO orderMenu : orderMenuList) {
			orderMenuResult += orderMapper.insertOrderMenu(orderMenu);
		}
		
		int result = 0;
		if(orderResult > 0 && orderMenuResult == orderMenuList.size()) {
			result = 1;
		}
		
		return result;
	}

}
