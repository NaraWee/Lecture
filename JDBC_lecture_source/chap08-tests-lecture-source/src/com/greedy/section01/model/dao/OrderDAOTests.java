package com.greedy.section01.model.dao;

import static com.greedy.common.JDBCTemplate.getConnection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.greedy.section01.model.dto.CategoryDTO;
import com.greedy.section01.model.dto.OrderDTO;

public class OrderDAOTests {

	private Connection con;
	private OrderDAO orderDAO;
	private OrderDTO order;
	
	@Before
	public void setUp() {
		con = getConnection();
		orderDAO = new OrderDAO();
		
		order = new OrderDTO();
		order.setDate("20/04/06");
		order.setTime("16:42:44");
		order.setTotalOrderPrice(30000);
	}
	
	@Test
	@Ignore
	public void testSelectiAllCategory() {
		
		List<CategoryDTO> categoryList = orderDAO.selectAllCategory(con);
		assertNotNull(categoryList);
	}
	
	@Test
	public void testInsertOrder() {
		int result = orderDAO.insertOrder(con, order);
		
		assertEquals(1, result);
	}
}
