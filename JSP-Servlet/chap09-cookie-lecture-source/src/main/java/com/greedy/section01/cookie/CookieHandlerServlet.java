package com.greedy.section01.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieHandlerServlet
 */
@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/*
		 * redirect는 url을 재작성하여 url을 이용해 요청하는 방식이기 때문에 get방식의 요청이다.
		 * 따라서 redirect되는 서블릿을 doGet 메소드쪽에서 처리해야한다.
		 */
		// 변경 전 코드
//		response.sendRedirect("redirect");
		
		/*******************************************/
		
		/*
		 * 쿠키를 사용하는 방법은 간단하며, 쿠키를 사용하는 절차가 있다.
		 * 1. 쿠키를 생성한다.
		 * 2. 해당 쿠키와 만료 시간을 결정한다.
		 * 3. 응답 헤더에 쿠키를 담는다.
		 * 4. 응답한다.
		 */
		
		// 1. 쿠키를 생성한다.
		Cookie firstNameCookie = new Cookie("firstName",firstName);
		Cookie lastNameCookie = new Cookie("lastName",lastName);
		
		// 2. 해당 쿠키와 만료 시간을 결정한다.
		firstNameCookie.setMaxAge(60 * 60 * 24);	// 하루동안 (지금꺼는 예시일 뿐 변경가능)
		lastNameCookie.setMaxAge(60 * 60 * 24);
		
		// 3. 응답 헤더에 쿠키를 담는다.
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		
		// 4. 응답한다.
		response.sendRedirect("redirect");
		
		
	}

}
