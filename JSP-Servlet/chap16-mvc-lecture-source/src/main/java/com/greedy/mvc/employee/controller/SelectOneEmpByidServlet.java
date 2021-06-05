package com.greedy.mvc.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;

/**
 * Servlet implementation class SelectOneEmpByidServlet
 */
@WebServlet("/employee/select")
public class SelectOneEmpByidServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 전달한 파라미터 꺼내기 */
		String empId = request.getParameter("empId");
		
		System.out.println("empId : " + empId);
		
		/* 사번을 이용해 사원정보를 조회하는 비즈니스 로직 호출 */
		EmployeeService empService = new EmployeeService();
		
		/* 결과값을 반환 받자 */
		/* 반환값은 뭘로 받지?? 객체로 받을까, 리스트를 받을까? 정수를 받을까,,? -> 내가 뭘 조회하고 있지? 또는 무슨 작업중이지? */
		EmployeeDTO selectedEmp = empService.selectOneEmpById(empId);
		
		/* 비즈니스 로직 실행 결과에 따른 뷰 연결 */
		String path = "";
		if(selectedEmp != null) {
			path = "/WEB-INF/views/employee/showEmpInfo.jsp";
			request.setAttribute("selectedEmp", selectedEmp);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 정보를 조회할 수 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
