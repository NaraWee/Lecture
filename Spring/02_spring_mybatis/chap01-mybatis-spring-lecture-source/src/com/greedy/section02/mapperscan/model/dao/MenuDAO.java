package com.greedy.section02.mapperscan.model.dao;

import java.util.List;

import com.greedy.section02.mapperscan.model.dto.MenuDTO;

public interface MenuDAO {

	List<MenuDTO> selectMenuList();
}
