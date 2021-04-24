package com.greedy.section02.template;

import java.sql.Connection;
import java.sql.SQLException;

import static com.greedy.section02.template.JDBCTemplate.getConnection;
import static com.greedy.section02.template.JDBCTemplate.close;

public class Application {

	public static void main(String[] args) {
		
		// static 메소드의 경우 import static 패키지명을 추가해준다.
		Connection con = getConnection();
		System.out.println(con);
		
//		if(con != null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		close(con);
	}
}
