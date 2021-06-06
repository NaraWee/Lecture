package com.greedy.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;

public class Application2 {

	public static void main(String[] args) {

		/* 1. Connection 생성 */
		Connection con = getConnection();
		
		/* 2. Statement 생성 */
		Statement stmt = null;
		
		/* 3. ResultSet 생성 */
		ResultSet rset = null;
		
		try {
			/* 4. Connection의 createStatement()를 이용한 Statement 인스턴스 생성 */
			stmt = con.createStatement();
			
			String empId = "202";
			String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID='" + empId + "'";
			
			System.out.println(query);
			
			/* 5. executeQuery()로 쿼리문 실행하고 결과를 ResultSet으로 반환 받는다. */
			rset = stmt.executeQuery(query);
			
			/* 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해서 꺼내온다. */
			if(rset.next()) {
				/* next() : ResultSet의 커서 위치를 하나씩 내리면서 행이 존재하면 true 존재하지 않으면 false를 반환 */
				System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));	
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			/* 7. 사용한 자원 반납*/
			close(rset);
			close(stmt);
			close(con);
		}

	}

}
