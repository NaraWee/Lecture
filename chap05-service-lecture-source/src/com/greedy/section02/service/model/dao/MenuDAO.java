package com.greedy.section02.service.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.greedy.section02.service.model.dto.CategoryDTO;
import com.greedy.section02.service.model.dto.MenuDTO;

public class MenuDAO {

	private Properties prop = new Properties();
	
	public MenuDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 신규 카테고리 등록용 메소드
	 * @param con 연결정보
	 * @param newCategory 등록카테고리 정보
	 * @return
	 */
	public int insertNewCategory(Connection con, CategoryDTO newCategory) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertCategory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newCategory.getName());
			pstmt.setObject(2, newCategory.getRefCategoryCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * <pre>
	 * 	마지막 등록코드 조회용
	 * </pre>
	 * @param con
	 * @return
	 */
	public int selectLastCategoryCode(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int newCategoryCode = 0;
		
		String query = prop.getProperty("getCurrentSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				newCategoryCode = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(stmt);
		}
		
		return newCategoryCode;
	}

	/**
	 * <pre>
	 *  새로운 메뉴 등록
	 * </pre>
	 * @param con
	 * @param newMenu 등록에 필요한 값
	 * @return
	 */
	public int insertNewMenu(Connection con, MenuDTO newMenu) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newMenu.getName());
			pstmt.setInt(2, newMenu.getPrice());
			pstmt.setInt(3, newMenu.getCategoryCode());
			pstmt.setString(4, newMenu.getOrderableStatus());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
