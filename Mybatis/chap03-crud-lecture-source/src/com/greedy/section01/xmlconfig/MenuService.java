package com.greedy.section01.xmlconfig;

import static com.greedy.section01.xmlconfig.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuService {

	private final MenuDAO menuDAO;
	
	public MenuService() {
		menuDAO = new MenuDAO();
	}
	
	public List<MenuDTO> selectAllMenu() {

		SqlSession sqlSession = getSqlSession();
		
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
		
		sqlSession.close();
		
		return menuList;
	}

	public MenuDTO selectMenuByCode(int code) {

		SqlSession sqlSession = getSqlSession();
		
		MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
		
		sqlSession.close();
		
		return menu;
	}

	public boolean registMenu(MenuDTO menu) {

		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.insertMenu(sqlSession,menu);
		
		// insert, update, delete는 결과에 따라서 트랜잭션 처리를 해준다.
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}

	public boolean modifyMenu(MenuDTO menu) {

		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.modifyMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}

	public boolean deleteMenu(MenuDTO menu) {

		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.deleteMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}

}
