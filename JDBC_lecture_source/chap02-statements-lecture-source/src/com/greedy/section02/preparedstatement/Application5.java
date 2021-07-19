package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application5 {

	public static void main(String[] args) {

		/* LIKE %이
		 * LIKE 이%
		 * LIKE %이%
		 */
		/* EMPLoyEE 테이블에서 조회할 사원의 이름의 성을 입력받아 해당 성씨를 가진 사원정보들을 모두 출력하세요 */
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO row = null;
		List<EmployeeDTO> empList = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하실 사원의 이름의 성을 입력해주세요 : ");
		String empName = sc.next();
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE ? || '%'");
			pstmt.setString(1, empName);
			
			rset = pstmt.executeQuery();
			
			empList = new ArrayList<>();
			
			while(rset.next()) {
				
				row = new EmployeeDTO();
				
				row.setEmpId(rset.getString("EMP_ID"));
				row.setEmpName(rset.getString("EMP_NAME"));
				row.setEmpNo(rset.getString("EMP_NO"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setDeptCode(rset.getString("DEPT_CODE"));
				row.setJobCode(rset.getString("JOB_CODE"));
				row.setSalary(rset.getInt("SALARY"));
				row.setSalLevel(rset.getString("SAL_LEVEL"));
				row.setBonus(rset.getDouble("Bonus"));
				row.setManagerId(rset.getString("MANAGER_ID"));
				row.setHireDate(rset.getDate("HIRE_DATE"));
				row.setEntDate(rset.getDate("ENT_DATE"));
				row.setEntYn(rset.getString("ENT_YN"));

				empList.add(row);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
			sc.close();
		}
		
		for(EmployeeDTO emp : empList) {
			System.out.println(emp);
		}
		
	}

}
