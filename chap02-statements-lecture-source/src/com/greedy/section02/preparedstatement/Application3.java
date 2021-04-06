package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Application3 {

	public static void main(String[] args) {

		/* 사번을 입력받아 사원을 출력 (조회하실 사번을 입력하세요)*/
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하실 사번을 입력하세요 : ");
		String emp = sc.next();
		
		try {
			
			
			pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?");
			pstmt.setString(1, emp);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
			}			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
			close(con);
		}
		
	}

}
