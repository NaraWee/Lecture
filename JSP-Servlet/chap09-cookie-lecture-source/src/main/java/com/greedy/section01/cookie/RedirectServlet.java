package com.greedy.section01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/*
		 * Cookie를 적용하기전에는 null값이 나오는 것을 확인하였다.
		 * 따라서 request는 공유되지 않는 것을 확인할 수 있다.
		 */
		
		// Cookie를 사용하자
		/*
		 * 쿠키 사용법
		 * 1. request에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
		 * 2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 꺼낸다. 
		 */
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++) {
			System.out.println("[cookie] : " + cookies[i].getName() + " : " + cookies[i].getValue());
			
			if("firstName".equals(cookies[i].getName())) {
				firstName = cookies[i].getValue();
			} else if("lastName".equals(cookies[i].getName())) {
				lastName = cookies[i].getValue();
			}
		}
		
		StringBuilder responseText = new StringBuilder();
	    responseText.append("<!doctype html>\n")
	                .append("<html>\n")
	                .append("<head>\n")
	                .append("</head>\n")
	                .append("<body>\n")
	                .append("<h3>your first name is ")
	                .append(firstName)
	                .append(" and last name is ")
	                .append(lastName)
	                .append("</h3>\n")
	                .append("</body>\n")
	                .append("</html>\n");
	      
	      response.setContentType("text/html; charset=utf-8");
	      
	      PrintWriter out = response.getWriter();
	      
	      out.print(responseText.toString());
	      
	      out.flush();
	      out.close();
		
	      /* 쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장이 된다. 개인적으로만 사용하는 경우는 크게 상관 없지만
	       * 다른 사용자와 함께 사용하는 컴퓨터(공용컴퓨터)인 경우 쿠키에 민감한 개인정보를 담기에는 보안에 취약하게 된다.
	       * 민감한 개인정보를 취급하는 경우에는 쿠키보다는 세션이라는 것을 이용하게 된다.
	       * 
	       * 세션은 쿠키와 유사한 형테로 key=value쌍으로 저장되지만 서버(톰캣)에서 관리되기 때문에 보안에 더 우수하다는 장점을 가지게 된다.
	       */
		
	}

}
