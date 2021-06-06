package com.greedy.section01.transaction;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {

	public static void main(String[] args) {

		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			System.out.println("autoCommit의 현재 설정 값 : " + con.getAutoCommit());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("insertMenu");
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "로제청국장");
			pstmt.setInt(2, 15000);
			pstmt.setInt(3, 1);
			pstmt.setString(4, "Y");
			
			result = pstmt.executeUpdate();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		if(result > 0) {
			System.out.println("메뉴등록 성공");
		} else {
			System.out.println("메뉴등록 실패");
		}

	}

}
