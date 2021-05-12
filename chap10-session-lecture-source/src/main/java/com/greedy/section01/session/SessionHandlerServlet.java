package com.greedy.section01.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionHandlerServlet
 */
@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
//		response.sendRedirect("redirect");
		
		// session 적용하기
		/*
		 * 서버쪽에서 조금 더 안전하게 관리되는 세견이라는 인스턴스를 이용해서 상태를 유지하는 매커니즘을 제공하고 있다.
		 * HttpSession은 직접 생성할 수는 없고, request에 있는 getSession() 메소드를 이용해서 리턴받는다.
		 */
		HttpSession session = request.getSession();
		
		// 세션은 강제로 완료시킬 수 있는 기능도 있지만 만료시간을 설정해주는 것이 좋다.
		// 설정된 기본 시간은 30분이다.
		System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());
		
		session.setMaxInactiveInterval(60 * 10);
		
		System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());
		
		// 세션은 브라우저 당 한 개씩 고유한 아이디를 가지고 하나의 인스턴스를 이용한다.
		// 매번 반복적인 요청 시 동일한 session id를 리턴한다.
		System.out.println("session id : " + session.getId());
		
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		
		response.sendRedirect("redirect");
	}

}
