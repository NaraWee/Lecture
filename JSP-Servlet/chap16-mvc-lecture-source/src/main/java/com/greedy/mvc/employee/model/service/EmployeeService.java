package com.greedy.mvc.employee.model.service;

import static com.greedy.mvc.common.jdbc.JDBCTemplate.close;
import static com.greedy.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.mvc.common.jdbc.JDBCTemplate.commit;
import static com.greedy.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.mvc.employee.model.dao.EmployeeDAO;
import com.greedy.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeService {

	/* Connection 객체 생성, 결과에 따른 트랜잭션 처리, [Connection 객체 소멸] */
	
	/* EmployeeDAO와 연결할 필드 변수 */
	private EmployeeDAO empDAO = new EmployeeDAO();
	/**
	 * 사원번호를 이용하여 사용자 정보 조회
	 * @param empId 사원번호
	 * @return 사원정보
	 */
	public EmployeeDTO selectOneEmpById(String empId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		EmployeeDTO selectedEmp = empDAO.selectEmpById(con, empId);
		
		/* 생각 : 트랜잭션 처리가 필요한 상황인가,,, */
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedEmp;
	}
	public List<EmployeeDTO> selectAllEmp() {
		
		Connection con = getConnection();
		
		List<EmployeeDTO> selectAllEmp = empDAO.selectAllEmp(con);
		
		close(con);
		
		return selectAllEmp;
	}

	public int insertEmp(EmployeeDTO empDTO) {

		int result = 0;

		Connection con = getConnection();
		
		EmployeeDAO empDAO = new EmployeeDAO();

		result = empDAO.insertEmp(con, empDTO);

		if (result > 0) {
			commit(con);
		} else {
			System.out.println();
			rollback(con);
		}

		close(con);

		return result;
	}
	public int updateEmp(EmployeeDTO empDTO) {
		
		int result = 0;
		
		Connection con = getConnection();
		
		EmployeeDAO empDAO = new EmployeeDAO();
		
		result = empDAO.updateEmp(con, empDTO);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
