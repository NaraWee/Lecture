package com.greedy.section01.xml;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LifeCycleTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/* 메소드들의 호출 횟수를 카운트하기 위한 용도의 필드 */
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	
	/* 기본 생성자 */
	public LifeCycleTestServlet() {
		
	}
	
	/* 서블릿의 요청이 최초인 경우 한 번 동작하는 메소드 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("xml 매핑 init() 메소드 호출 : " + initCount++);
	}
	
	public void service(ServletRequest request, ServletResponse resonse) throws ServletException, IOException {
		
		/* 서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후에 동작하고,
		 * 두 번째 요청부터는 바로 Service()를 호출한다.
		 */
		System.out.println("xml 매핑 service() 메소드 호출 : " + serviceCount++);
	}
	
	public void destroy() {
		/* 서블릿 컨테이너가 종료될 때 호출되는 메소드이며, 주로 자원을 반납하는 용도로 사용된다.*/
		System.out.println("xml 매핑 destroy() 메소드 호출 : " + destroyCount++);
	}
}
