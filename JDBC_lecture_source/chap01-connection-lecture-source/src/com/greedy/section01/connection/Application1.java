package com.greedy.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

	public static void main(String[] args) {

		/* DB접속을 위한 Connection 인스턴스 생성을 위한 레퍼런스 변수 선언
		 * 나중에 finally블럭에서 사용하기 위해 try블럭 밖에 선언한다.
		 */
		Connection con = null;
		
		try {
			/* 사용할 드라이버 등록 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			/* DriverManager를 이용해 Connection 생성 */
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","EMPLOYEE","EMPLOYEE");
			
			System.out.println("con : " + con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
