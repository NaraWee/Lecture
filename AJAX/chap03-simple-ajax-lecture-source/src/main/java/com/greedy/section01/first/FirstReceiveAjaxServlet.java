package com.greedy.section01.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstReceiveAjaxServlet
 */
@WebServlet("/first/receive")
public class FirstReceiveAjaxServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * 응답하는 데이터가 단순 문자열인 경우 문자열만 내보낼 수 있다.
		 * 이 때 기본 응답 데이터는 text/plain 이다. 또한 인코딩 설정도 되어있지 않다.
		 * 한글데이터를 응답하려면 인코딩 설정을 해 주어야 한다.
		 */
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm get!! insert value!! 안녕하세요!!");
		
		out.flush();
		out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * post 방식의 요청도 마찬가지로 응답한다.
		 */
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm post!! insert value!! 안녕하세요!!");
		
		out.flush();
		out.close();
		
	}

}
