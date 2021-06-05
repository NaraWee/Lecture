package com.greedy.section01.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstFilterTestServlet
 */
@WebServlet("/first/filter")
public class FirstFilterTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("서블릿 요청 확인");
		
		StringBuilder responseText = new StringBuilder();
	    responseText.append("<!doctype html>\n")
	                .append("<html>\n")
	                .append("<head>\n")
	                .append("</head>\n")
	                .append("<body>\n")
	                .append("<h3>필터 확인용 서블릿 요청 확인 완료</h3>")
	                .append("</body>\n")
	                .append("</html>\n");
	      
	      response.setContentType("text/html; charset=utf-8");
	      
	      PrintWriter out = response.getWriter();
	      
	      out.print(responseText.toString());
	      
	      out.flush();
	      out.close();
		
	}

}
