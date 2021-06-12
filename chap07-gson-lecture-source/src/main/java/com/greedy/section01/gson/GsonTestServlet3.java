package com.greedy.section01.gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GsonTestServlet3
 */
@WebServlet("/gson/test3")
public class GsonTestServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberCode = request.getParameter("memberCode");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		java.sql.Date enrollDate = java.sql.Date.valueOf(request.getParameter("enrollDate"));
		
		MemberDTO member = new MemberDTO(memberCode,firstName,lastName,age,enrollDate);
		String jsonString = new Gson().toJson(member);
		
		System.out.println(jsonString);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

}
