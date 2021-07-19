package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application4 {

	public static void main(String[] args) {

		/* 스캐너 이용해서 사번을 입력받고 해당 사번의 사원 정보를 EmployeeDTO에 담아서 출력하세요. */
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO dto = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하실 사원의 사번을 입력해주세요 : ");
		String empId = sc.next();
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID = ?");
			pstmt.setString(1, empId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				dto = new EmployeeDTO();
				
				dto.setEmpId(rset.getString("EMP_ID"));
				dto.setEmpName(rset.getString("EMP_NAME"));
				dto.setEmpNo(rset.getString("EMP_NO"));
				dto.setEmail(rset.getString("EMAIL"));
				dto.setPhone(rset.getString("PHONE"));
				dto.setDeptCode(rset.getString("DEPT_CODE"));
				dto.setJobCode(rset.getString("JOB_CODE"));
				dto.setSalary(rset.getInt("SALARY"));
				dto.setSalLevel(rset.getString("SAL_LEVEL"));
				dto.setBonus(rset.getDouble("Bonus"));
				dto.setManagerId(rset.getString("MANAGER_ID"));
				dto.setHireDate(rset.getDate("HIRE_DATE"));
				dto.setEntDate(rset.getDate("ENT_DATE"));
				dto.setEntYn(rset.getString("ENT_YN"));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
			sc.close();
		}
		
		System.out.println("selectEMP : " + dto);
		
	}

}
