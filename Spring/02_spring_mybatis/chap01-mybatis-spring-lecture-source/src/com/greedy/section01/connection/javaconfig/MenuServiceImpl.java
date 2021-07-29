package com.greedy.section01.connection.javaconfig;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	private final MenuDAO menuDAO;
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public MenuServiceImpl(MenuDAO menuDAO, SqlSessionTemplate sqlSession) {
		this.menuDAO = menuDAO;
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<MenuDTO> selectMenuList() {

		return menuDAO.selectMenuList(sqlSession);
	}

}
