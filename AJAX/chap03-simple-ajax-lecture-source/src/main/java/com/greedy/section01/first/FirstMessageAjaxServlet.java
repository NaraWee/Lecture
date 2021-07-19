package com.greedy.section01.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstMessageAjaxServlet
 */
@WebServlet("/first/message")
public class FirstMessageAjaxServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = request.getParameter("message");

		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm get!!" + message);
		
		out.flush();
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = request.getParameter("message");
		
		// post방식 AJAX 요청할때 자동(기본)으로 UTF-8로 설정되어있음 응답할때는 아니어서 response 인코딩 UTF-8로 맞춰줘야함
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm get!!" + message);
		
		out.flush();
		out.close();
	}

}
