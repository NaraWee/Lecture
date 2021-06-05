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
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		EmployeeService empService = new EmployeeService();
		
		EmployeeDTO empDTO = new EmployeeDTO();
		
		empDTO.setEmpId(request.getParameter("empId"));
		empDTO.setEntDate(java.sql.Date.valueOf(request.getParameter("entDate")));
		empDTO.setEntYn(request.getParameter("entYn"));
		
		int result = empService.updateEmp(empDTO);
		
		System.out.println(result);
	}

}
