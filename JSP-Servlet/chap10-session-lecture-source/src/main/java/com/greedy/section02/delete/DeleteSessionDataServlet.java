package com.greedy.section02.delete;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteSessionDataServlet
 */
@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println("--------------[ 결과 구분 1 ]--------------");
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		/*
		 * 세션의 데이터를 지우는 방법은 여러가지가 존재한다.
		 * 1. 만료시간 설정 후 시간이 지나면 세션이 만료된다.(xml설정도 가능)
		 * 2. removeAttribute()로 session의 Attribute를 지운다.
		 * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
		 */
		System.out.println("--------------[ 결과 구분 2 ]--------------");
		// removeAttribute 메소드를 이용해서 firstName 속성을 제거 --> 결과는 lastName만 출력
		session.removeAttribute("firstName");
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		System.out.println("--------------[ 결과 구분 3 ]--------------");
		/*
		 * invalidate() 메소드를 호출하게 되면 이후 세션을 이용하는 것은 세션 자체를 무효화 했기 때문에 에러가 발생한다.
		 * --> 세션 내의 데이터를 지우는 것 뿐만 아니라 세션을 강제로 만료시켜 버린것이라고 볼 수 있다.
		 */
		session.invalidate();
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
	}

}
