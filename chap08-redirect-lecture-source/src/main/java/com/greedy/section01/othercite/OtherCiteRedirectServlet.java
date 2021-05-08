package com.greedy.section01.othercite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OtherCiteRedirectServlet
 */
@WebServlet("/othercite")
public class OtherCiteRedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("get 요청 후 naver 사이트로 redirect");
		
		/*
		 * 브라우저의 개발도구 network 탭을 보면 302번 코드와 함께 naver사이트로 이동
		 * 사용자 url 재작성이라고 불리는 redirect방식은 302번 응답 코드인 경우 요청에 대한 처리를 잘하고
		 * 사용자의 url을 강제로 redirect 경로로 이동을 시키라는 의미
		 * 
		 * 응답 헤더 작성은 General Header에 302번 코드와
		 * Response header에 Location이라는 헤더값에 redirect할 경로를 포함하여 응답한다.
		 */
		response.sendRedirect("http://www.naver.com");
	}

}
