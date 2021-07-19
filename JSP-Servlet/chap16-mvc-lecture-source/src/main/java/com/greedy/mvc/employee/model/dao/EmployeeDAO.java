package com.greedy.mvc.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.greedy.mvc.common.jdbc.JDBCTemplate.close;

import com.greedy.mvc.common.config.ConfigLocation;
import com.greedy.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeDAO {
	
	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용한다.
	 * 기본생성자를 통해서 쿼리문을 조회해온다.
	 */
	
	private Properties prop = new Properties();
	
	public EmployeeDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"employee-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public EmployeeDTO selectEmpById(Connection con, String empId) {
		
		/* Statement를 사용할까 아니면 PreparedStatement를 사용할까?? */
		// String empId 넘겨받으니까 pstmt로,, 전체 조회할 경우 Statement가 더 빠름
		PreparedStatement pstmt = null;
		
		/* 결과값을 뭘로 받을까를 고민
		 * 1. select를 요청했을 때 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 */
		
		ResultSet rset = null;
		
		/* 반환시킬 변수를 지정하자 -> 위의 결과값을 잘 생각해보면 나오지 않을까,,, */
		EmployeeDTO selectedEmp = null;
		
		String query = prop.getProperty("selectEmpById");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empId);	// <- 위치홀더의 시작인덱스 값은 1부터 시작한다.
			
			rset = pstmt.executeQuery();	// 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			if(rset.next()) {
				selectedEmp = new EmployeeDTO();
				//	setEmpId -> DTO 필드의 setter, rset.getString("데이터베이스컬럼명")
				selectedEmp.setEmpId(rset.getString("EMP_ID"));
				selectedEmp.setEmpName(rset.getString("EMP_NAME"));
				selectedEmp.setDeptCode(rset.getString("DEPT_CODE"));
				selectedEmp.setJobCode(rset.getString("JOB_CODE"));
				selectedEmp.setSalary(rset.getInt("SALARY"));
			}
			
			System.out.println(selectedEmp);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedEmp;
	}

	public List<EmployeeDTO> selectAllEmp(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<EmployeeDTO> selectAllEmp = null;
		
		String query = prop.getProperty("selectAllEmployee");
		
		System.out.println(query);
		
		try {
			
			selectAllEmp = new ArrayList<>();
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				EmployeeDTO allEmp = new EmployeeDTO();
				//	setEmpId -> DTO 필드의 setter, rset.getString("데이터베이스컬럼명")
				allEmp.setEmpId(rset.getString("EMP_ID"));
				allEmp.setEmpName(rset.getString("EMP_NAME"));
				allEmp.setEmpNo(rset.getString("EMP_NO"));
				allEmp.setEmail(rset.getString("EMAIL"));
				allEmp.setPhone(rset.getString("PHONE"));
				allEmp.setDeptCode(rset.getString("DEPT_CODE"));
				allEmp.setJobCode(rset.getString("JOB_CODE"));
				allEmp.setSalLevel(rset.getString("SAL_LEVEL"));
				allEmp.setSalary(rset.getInt("SALARY"));
				allEmp.setBounus(rset.getDouble("BONUS"));
				allEmp.setManagerId(rset.getString("MANAGER_ID"));
				allEmp.setHireDate(rset.getDate("HIRE_DATE"));
				allEmp.setEntDate(rset.getDate("ENT_DATE"));
				allEmp.setEntYn(rset.getString("ENT_YN"));
				
				selectAllEmp.add(allEmp);
				
			}
			System.out.println(selectAllEmp);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectAllEmp;
	}
	
	
	public int insertEmp(Connection con, EmployeeDTO empDTO) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertEmployee");

		try {

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empDTO.getEmpName());
			pstmt.setString(2, empDTO.getEmpNo());
			pstmt.setString(3, empDTO.getEmail());
			pstmt.setString(4, empDTO.getPhone());
			pstmt.setString(5, empDTO.getDeptCode());
			pstmt.setString(6, empDTO.getJobCode());
			pstmt.setString(7, empDTO.getSalLevel());
			pstmt.setInt(8, empDTO.getSalary());
			pstmt.setDouble(9, empDTO.getBounus());
			pstmt.setString(10, empDTO.getManagerId());
			pstmt.setDate(11, empDTO.getHireDate());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int updateEmp(Connection con, EmployeeDTO empDTO) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateEmployee");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setDate(1, empDTO.getEntDate());
			pstmt.setString(2, empDTO.getEmpId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}
