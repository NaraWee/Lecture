package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	private String encodingType;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encodingType = filterConfig.getInitParameter("encoding-type");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
			System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding());
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

}
