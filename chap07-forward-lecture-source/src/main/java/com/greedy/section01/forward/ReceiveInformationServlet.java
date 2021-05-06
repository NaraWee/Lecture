package com.greedy.section01.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveInformationServlet
 */
@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userId");
		String pass = request.getParameter("password");
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pass);
		
		/*
		 * 서블릿이 하는 역할은 크게 3가지라고 했다.
		 * 1. 요청 정보 받기
		 * 2. 비즈니스 로직 처리
		 * 3. 응답 내보내기
		 */
		
		request.setAttribute("ID", id);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("print");
		rd.forward(request, response);
	}

}
