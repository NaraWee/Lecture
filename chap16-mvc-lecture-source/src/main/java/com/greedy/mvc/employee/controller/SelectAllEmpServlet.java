package com.greedy.mvc.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;

/**
 * Servlet implementation class SelectAllEmpServlet
 */
@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeService empService = new EmployeeService();
		
		List<EmployeeDTO> allEmp = new ArrayList<>();
		allEmp = empService.selectAllEmp();
		
		String path = "";
		
		if(allEmp != null) {
			path = "/WEB-INF/views/employee/employeeList.jsp";
			request.setAttribute("allEmp", allEmp);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 정보를 조회할 수 없습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
