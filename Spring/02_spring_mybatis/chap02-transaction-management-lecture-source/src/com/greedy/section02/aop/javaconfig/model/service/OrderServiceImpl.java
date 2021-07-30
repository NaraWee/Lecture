package com.greedy.section02.aop.javaconfig.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.section02.aop.javaconfig.model.dao.OrderMapper;
import com.greedy.section02.aop.javaconfig.model.dto.OrderDTO;
import com.greedy.section02.aop.javaconfig.model.dto.OrderMenuDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private SqlSessionTemplate sqlSession;
	
	
	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	/* class레벨에 작성하면 모든 public 메소드에 적용된다.
	 * 메소드 레벨에는 어노테이션 작성된 메소드만 트랜잭션 처리를 한다.
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
	               rollbackFor = {Exception.class})
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
