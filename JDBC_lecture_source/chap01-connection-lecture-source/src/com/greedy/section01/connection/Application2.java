package com.greedy.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application2 {

	/* 변수를 이용해 작성한 문자열이 어떤 의미인지 알 수 있도록 개선 */
	public static void main(String[] args) {
		
	      String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "EMPLOYEE";
	      String password = "EMPLOYEE";
	      
	      Connection con = null;
	      
	      try {
	         Class.forName(driver);
	         
	         con = DriverManager.getConnection(url,user,password);
	         
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
