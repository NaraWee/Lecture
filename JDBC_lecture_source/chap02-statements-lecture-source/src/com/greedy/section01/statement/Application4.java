package com.greedy.section01.statement;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application4 {

	public static void main(String[] args) {

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		
		EmployeeDTO selectEmp = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하실 사번을 입력해주세요 : ");
		String empId = sc.nextLine();
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID ='" + empId + "'";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				selectEmp = new EmployeeDTO();
				
				selectEmp.setEmpId(rset.getString("EMP_ID"));
				selectEmp.setEmpName(rset.getString("EMP_NAME"));
				selectEmp.setEmpNo(rset.getString("EMP_NO"));
				selectEmp.setEmail(rset.getString("EMAIL"));
				selectEmp.setPhone(rset.getString("PHONE"));
				selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
				selectEmp.setJobCode(rset.getString("JOB_CODE"));
				selectEmp.setSalLevel(rset.getString("SAL_LEVEL"));
				selectEmp.setSalary(rset.getInt("SALARY"));
				selectEmp.setBonus(rset.getDouble("BONUS"));
				selectEmp.setManagerId(rset.getString("MANAGER_ID"));
				selectEmp.setHireDate(rset.getDate("HIRE_DATE"));
				selectEmp.setEntDate(rset.getDate("ENT_DATE"));
				selectEmp.setEntYn(rset.getString("ENT_YN"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(stmt);
			close(con);
		}
		
		System.out.println("selectEmp : " + selectEmp);
	}

}
