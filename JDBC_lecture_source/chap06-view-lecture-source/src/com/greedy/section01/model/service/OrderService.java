package com.greedy.section01.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.greedy.section01.model.dao.OrderDAO;
import com.greedy.section01.model.dto.CategoryDTO;
import com.greedy.section01.model.dto.MenuDTO;
import com.greedy.section01.model.dto.OrderDTO;
import com.greedy.section01.model.dto.OrderMenuDTO;

public class OrderService {

	private OrderDAO orderDAO = new OrderDAO();
	
	/**
	 * 카테고리 전체 조회용 메소드
	 * @return
	 */
	public List<CategoryDTO> selectAllCategory() {

		/* 1. Connection 생성*/
		Connection con = getConnection();
		
		/* 2. DAO의 모든 카테고리 조회용 메소드를 호출하여 결과 리턴받기 */
		List<CategoryDTO> categoryList = orderDAO.selectAllCategory(con);
		
		/* 3. 커넥션 닫기 */
		close(con);
		
		/* 4. 반환받은 값 리턴하기 */
		return categoryList;
	}

	/**
	 * <pre>
	 *  카테고리별 메뉴 조회용 메소드
	 * </pre>
	 * @param categoryCode 카테고리 코드
	 * @return
	 */
	public List<MenuDTO> selectMenuBy(int categoryCode) {

		/* 1. Connection 생성 */
		Connection con = getConnection();
		
		/* DAO의 해당 카테고리 메뉴을 조회하는 메소드로 categoryCode를 전달하며 조회 */
		List<MenuDTO> menuList = orderDAO.selectMenuBy(con, categoryCode);
		
		/* Connection 닫기*/
		close(con);
		
		/* 반환받은 값 리턴하기*/
		return menuList;
	}

	/**
	 * <pre>
	 *  주문 정보 등록용 메소드
	 * </pre>
	 * @param order
	 * @return
	 */
	public int registOrder(OrderDTO order) {

		/* 1. Connection 생성 */
		Connection con = getConnection();
		
		/* 2. 리턴할 값 초기화 */
		int result = 0;
		
		/* 3. DAO 메소드로 전달받은 값 넘겨서 insert */
		/* 3-1. Order table insert */
		int orderResult = orderDAO.insertOrder(con, order);
		
		/* 3-2. 마지막 발생한 시퀀스 조회 */
		int orderCode = orderDAO.selectLastOrderCode(con);
		
		/* 3-3. orderList에 orderCode 추가 */
		List<OrderMenuDTO> orderMenuList = order.getOrderMenuList();
		for(int i = 0; i < orderMenuList.size(); i++) {
			OrderMenuDTO orderMenu = orderMenuList.get(i);
			orderMenu.setCode(orderCode);
		}
		
		/* 3-4. ORDER_MENU 테이블에 INSERT */
		int orderMenuResult = 0;	// 테이블에 입력된 행의 개수를 반환해주는 결과변수
		for(int i = 0; i < orderMenuList.size(); i++) {
			OrderMenuDTO orderMenu = orderMenuList.get(i);
			orderMenuResult += orderDAO.insertOrderMenu(con, orderMenu);
		}
		
		/* 성공 여부 판단 후 트랜잭션 처리 */
		if(orderResult > 0 && orderMenuResult == orderMenuList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		return result;
	}

}
