package com.greedy.section01.headers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderPrintServlet
 */
@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHeaderPrintServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 요청 시 전달되는 헤더라는 것이 어떤 정보들을 포함하고 있는지 확인
		 * 헤더의 종류는 전통적으로 4가지 카테고리로 구분된다.
		 * 
		 * 1. General header : 요청 및 응답 모두에 적용되지만 최종적으로는 바디에 전송되는 것과는 관련이 없는 헤더이다.
		 * 2. Request header : 패치될 리소스나 클라이언트 자체에 대한 상세 정보를 포함하는 헤더이다.
		 * 3. Response header : 위치나 서버 자체와 같은 응답에 부가적인 정보를 갖는 헤더이다.
		 * 4. Entity header : 컨텐츠 길이나 MIME 타입과 같은 엔티티 바디에 대한 상세 정보를 포함하는 헤더이다.
		 * 					  (요청 응답 모두 사용되며, 메시지 바디의 컨텐츠를 나타내기에 GET요청에 해당하지 않는다.)
		 * 
		 * 요청헤더(Request Header)
		 * 
		 * accept
		 * accept-encoding
		 * accept-language
		 * connection
		 * host
		 * referer
		 * sec-fetch-dest
		 * sec-fetch-mode
		 * sec-fetch-site
		 * cache-control
		 * upgrade-insecure-requests
		 * user-agent
		 */
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		
		System.out.println("---------------------------------------------");
		
		/* 어떤 값들이 들어가있는지 확인 */
		System.out.println("accept : " + request.getHeader("accept"));
		System.out.println("accept-encoding : " + request.getHeader("accept-Encoding"));
		System.out.println("accept-language : " + request.getHeader("accept-language"));
		System.out.println("connection : " + request.getHeader("connection"));
		System.out.println("host : " + request.getHeader("host"));
		System.out.println("referer : " + request.getHeader("referer"));
		System.out.println("sec-fetch-dest : " + request.getHeader("sec-fetch-dest"));
	
	}

}
