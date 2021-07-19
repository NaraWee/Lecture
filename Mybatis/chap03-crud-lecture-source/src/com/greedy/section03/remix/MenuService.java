package com.greedy.section03.remix;

import static com.greedy.section03.remix.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuService {

	private MenuMapper menuMapper;

	public List<MenuDTO> selectAllMenu() {

		SqlSession sqlSession = getSqlSession();
		
		/* sqlSession은 요청 단위 생성이다. 따라서 getMapper로 메소드 스코프로 매번 불러와야 한다. */
//		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		List<MenuDTO> menuList = menuMapper.selectAllMenu();
		
		sqlSession.close();
		
		return menuList;
	}

	public MenuDTO selectMenuByCode(int code) {

		SqlSession sqlSession = getSqlSession();
		
//		MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		MenuDTO menu = menuMapper.selectMenuByCode(code);
		
		sqlSession.close();
		
		return menu;
	}

	public boolean registMenu(MenuDTO menu) {

		SqlSession sqlSession = getSqlSession();
		
//		int result = menuDAO.insertMenu(sqlSession,menu);
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		int result = menuMapper.insertMenu(menu);
		
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
		
//		int result = menuDAO.modifyMenu(sqlSession, menu);
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		int result = menuMapper.updateMenu(menu);
		
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
		
//		int result = menuDAO.deleteMenu(sqlSession, menu);
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		int result = menuMapper.deleteMenu(menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}

}
