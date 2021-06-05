package com.greedy.section01.servicemethod;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceMethodTestServlet
 */
@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceMethodTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		/* HttpServletRequest는 ServletRequest 타입을 상속받아서 구현하였으며, HTTP 프로토콜의 정보를 담고 있기 때문에
		 * 실제 사용시에는 HttpSevletRequest 타입으로 다운캐스팅 해서 사용해야 한다.
		 * ServletResponse도 같은 맥락이다.
		 */
    	HttpServletRequest httpRequest = (HttpServletRequest)request;
    	HttpServletResponse httpResponse = (HttpServletResponse) response;
    	
    	// a 태그의 href 속성은 url창의 내용을 변경하는 요청이며, GET요청에 해당한다.
    	String httpMethod = httpRequest.getMethod();
    	System.out.println("http method : " + httpMethod);
    	
    	if(("GET").equals(httpMethod)) {
    		/* GET 요청으로 처리할 메소드로 요청과 응답 정보를 전달한다. */
    		doGet(httpRequest,httpResponse);
    	} else if(("POST").equals(httpMethod)) {
    		/* POST 요청을 처리할 메소드로 요청과 응답 정보를 전송한다. */
    		doPost(httpRequest,httpResponse);
    	}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("GET 요청을 처리할 메소드 호출 됨..");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청을 처리할 메소드 호출 됨..");
	}

}
