package com.greedy.section01.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTestServlet
 */
@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
	 	* 서블릿이 하는 역할은 크게 3가지라고 볼 수 있다.
	 	* 1. 요청받기(HTTP method GET/POST 요청에 따른 parameter로 전달받은 데이터를 꺼내올 수 있다.)
	 	* 2. 비즈니스 로직 처리(DB접속과 CRUD에 대한 로직 처리 -> 서비스를 호출하는 쪽으로 해결(MVC))
	 	* 3. 응답하기(문자열로 동적인 웹(HTML 태그)페이지를 만들어서 스트림을 이용하여 내보내기)
	 	*/
		
		// 사용자 브라우저에 스트림을 이용하여 페이지를 내보내는 것을 테스트
		
		/*
		 * 사용자 브라우저에 응답하기 위해서 HttpServletResponse가 가지고 있는 getWriter() 메소드로
		 * PrintWriter 인스턴스를 반환할 수 있다.
		 */
		System.out.println("doGet메소드 호출");
		
		/*
		 * 브라우저로 내보내기를 할 떄 데이터의 타입을 응답 헤더에 설정해준다.
		 * content-type 헤더의 값은 null이 기본값이며 명시하지 않으면 text/plain으로 여긴다.
		 */
		System.out.println("default response type : " + response.getContentType());
		
		response.setContentType("text/plain");
		
		// 응답 시에도 별도로 인코딩을 지정하지 않으면 기본적으로 설정된 인코딩 방식을 따르게 된다.(ISO-8859-1)
		// 따라서 한글로 페이지를 응답하는 경우 글씨가 깨져서 나오게 된다.
		System.out.println("default response encoding : " + response.getCharacterEncoding());
		
//		response.setCharacterEncoding("UTF-8");
//		System.out.println("changed response encoding : " + response.getCharacterEncoding());
		
		/* 참고 */
		/* 위 두 개의 설정을 한번에 설정할 수 있다. */
		response.setContentType("text/html; charset=utf-8");
		System.out.println("changed response encoding : " + response.getCharacterEncoding());
		
//		PrintWriter out = response.getWriter();
//      out.print("<!doctype html>\n");
//      out.print("<html>\n");
//      out.print("<head>\n");
//      out.print("</head>\n");
//      out.print("<body>\n");
//      out.print("<h1>안녕 servlet response</h1>\n");
//      out.print("</body>\n");
//      out.print("</html>\n");

		
		StringBuilder responseBuilder = new StringBuilder();
	    responseBuilder.append("<!doctype html>\n")
          			   .append("<html>\n")
          			   .append("<head>\n")
          			   .append("</head>\n")
          			   .append("<body>\n")
          			   .append("<h1>안녕 servlet response</h1>\n")
          			   .append("</body>\n")
          			   .append("</html>\n");
	    
		
		PrintWriter out = response.getWriter();
		out.print(responseBuilder.toString());
		
		out.flush();
		out.close();
	}

}
