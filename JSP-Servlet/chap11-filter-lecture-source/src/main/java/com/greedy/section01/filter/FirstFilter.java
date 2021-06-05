package com.greedy.section01.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter("/first/*")
public class FirstFilter implements Filter {

    /**
     * Default constructor. 
     * 기본생성자
     * 필터는 톰캣을 start할 시점부터 인스턴스를 미리 생성한다.
     */
    public FirstFilter() {
    	System.out.println("FirstFilter 인스턴스 생성");
    }

	/**
	 * @see Filter#destroy()
	 * 필터 인스턴스가 소멸될 때 호출되는 메소드(톰캣 종료시)
	 */
	public void destroy() {
		System.out.println("filter destroy 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * Servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter doFilter 호출");
		
		// 위에서 뭔가 처리를 한 다음 필터 혹은 서블릿의 deGet/doPost를 호출한다.
		chain.doFilter(request, response);
		
		/* 서블릿에서 처리 후 에 다시 수행할 내용이 있으면 작성*/
		System.out.println("서블릿 요청 처리 완료");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * 필터 인스턴스가 최초 생성될 때 호출되는 메소드
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init 호출");
	}

}
