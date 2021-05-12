package com.greedy.section01.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		// 앞에서 작성한 페이지와 동일한 세션 아이디를 반환한다.
		HttpSession session = request.getSession();
		System.out.println("redirect 페이지 session id : " + session.getId());
		
		
		// 세션값에 담긴 모든 Attribute 키 목록을 받환 받을 수 있다.
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		// 동일한 아이디를 가진 세션에서는 setAttribute한 값을 getAttribute로 꺼내올 수 있다.
		firstName = (String) session.getAttribute("firstName");
		lastName = (String) session.getAttribute("lastName");
		
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
		
	}

}
