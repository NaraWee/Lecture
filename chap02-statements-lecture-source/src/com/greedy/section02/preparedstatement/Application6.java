package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application6 {

	public static void main(String[] args) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO row = null;
		List<EmployeeDTO> empList = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 이름의 성을 입력하세요 : ");
		String empName = sc.nextLine();
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("src/com/greedy/section02/preparedStatement/employee-query.xml"));
			
			String query = prop.getProperty("selectEmpByFamilyName");
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
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
			
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		for (EmployeeDTO employeeDTO : empList) {
			System.out.println(employeeDTO);
		}
	}

}
