package com.greedy.section02.otherservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("이 서블릿은 redirect 성공!");
		
		StringBuilder responseText = new StringBuilder();
	      responseText.append("<!doctype html>\n")
	                  .append("<html>\n")
	                  .append("<head>\n")
	                  .append("</head>\n")
	                  .append("<body>\n")
	                  .append("<h1 align=\"center\">")
	                  .append("이 서블릿으로 redirect 성공!</h1>\n")
	                  .append("</body>\n")
	                  .append("</html>\n");
	      
	      response.setContentType("text/html; charset=utf-8");
	      
	      PrintWriter out = response.getWriter();
	      
	      out.print(responseText.toString());
	      
	      out.flush();
	      out.close();
	      
	      /* redirect를 한 경우 url이 재작성이 되어 새로고침 하는 경우 redirect된 페이지에 대한 요청만을
	       * 반복하게 된다. 즉, 이전 요청에 남아있던 정보는 더이상 남아있지 않게 된다.
	       * 또한, url이 변경되는 것이 redirect의 특징
	       * 
	       * http요청은 요청 시 잠시 connection을 맺고 응답 시에도 잠시 connection을 맺으며
	       * 요청 단위당 request객체는 한 개만 생성이된다.
	       * 따라서 첫 요청 시 request와 지금 redirect된 페이지의 request는 서로 다른 객체이다.
	       * 
	       * --> 
	       */
	}

}
