package com.greedy.section01.jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjaxTestServlet
 */
@WebServlet("/jquery")
public class JQueryAjaxTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name1");
		System.out.println(name);
		
		String output = name + "님 환영합니다!";
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(output);
		
		out.flush();
		out.close();
	
	}

}
