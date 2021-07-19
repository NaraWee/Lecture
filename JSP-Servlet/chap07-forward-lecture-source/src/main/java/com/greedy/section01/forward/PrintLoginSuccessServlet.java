package com.greedy.section01.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintLoginSuccessServlet
 */
@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = (String)request.getAttribute("ID");
		System.out.println(userId);
		// 위 아래 같은거(setAttribute는 값을 추가하고 싶을때?)
		String userId2 = request.getParameter("userId");
		System.out.println(userId2);
		
		/* 응답에 필요한 데이터가 준비가 되면 동적인 웹 페이지를 생성해볼까? */
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
					.append("<html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h3 align=\"center\">")
					.append(userId)
					.append("님 환영합니다. </h3>\n")
					.append("</body>\n")
					.append("</html>\n");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(responseText.toString());
		out.flush();
		out.close();
	}

}
