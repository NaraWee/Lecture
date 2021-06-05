package com.greedy.section02.uses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {
	
	/* 부모쪽에 기본생성자가 존재하지 않기 때문에 request를 전달하는 생성자가 필요하다.*/
	public RequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {

		String value ="";
		if("password".equals(key)) {
			// 암호화
			/* 스프링 시큐리티 BCrypt 암호화를 사용하려면 별도의 라이브러리를 추가한 후에 암호화 처리를 한다. */
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
		} else {
			value = super.getParameter(key);
		}
		return value;
	}

}
