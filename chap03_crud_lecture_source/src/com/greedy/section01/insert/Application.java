package com.greedy.section01.insert;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Application {

	public static void main(String[] args) {

		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			String query = prop.getProperty("insertMenu");
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "봉골레청국장");
			pstmt.setInt(2, 50000);
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

		System.out.println("result : " + result);
	}

}
