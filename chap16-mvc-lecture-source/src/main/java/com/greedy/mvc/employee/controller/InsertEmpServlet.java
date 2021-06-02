package com.greedy.mvc.employee.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;

/**
 * Servlet implementation class InsertEmpServlet
 */
@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		EmployeeService empService = new EmployeeService();
		
		EmployeeDTO empDTO = new EmployeeDTO();
		
		empDTO.setEmpName((String) request.getParameter("empName"));
		empDTO.setEmpNo((String) request.getParameter("empNo"));
		empDTO.setEmail((String) request.getParameter("email"));
		empDTO.setPhone((String) request.getParameter("phone"));
		empDTO.setDeptCode((String) request.getParameter("deptCode"));
		empDTO.setJobCode((String) request.getParameter("jobCode"));
		empDTO.setSalLevel((String) request.getParameter("salLevel"));
		empDTO.setSalary(Integer.parseInt(request.getParameter("salary")));
		empDTO.setBounus(Double.parseDouble(request.getParameter("bonus")));
		empDTO.setManagerId((String) request.getParameter("managerId"));
		empDTO.setHireDate(java.sql.Date.valueOf(request.getParameter("hireDate")));
		
		System.out.println(empDTO);

		int result = empService.insertEmp(empDTO);
		
		System.out.println(result);
	}

}
