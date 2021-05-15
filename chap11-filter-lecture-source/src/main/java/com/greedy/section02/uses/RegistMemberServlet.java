package com.greedy.section02.uses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Servlet implementation class RegistMemberServlet
 */
@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + password);
		System.out.println("name : " + name);
		
		/*
		 * 암호화 처리된 패스워드는 동일한 값이 입력되더라도 매번 실행시마다 다른 값을 가진다.
		 * DB에 이 상태(암호화된 상태)로 기록하게 되면 가입된 회원정보로 로그인할 떄 비밀번호가 같은지 비교는 어떻게 하지?
		 * 암호화된 문자열은 일반 문자열 비교가 불가능하고 matches()라는 메소드를 이용해야 한다.
		 */
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("비밀번호가 pass01인지 확인 : " + passwordEncoder.matches("pass01", password));	// 왼쪽 로그인시 넣은 값(평문), 오른쪽 DB에 저장된 암호화된 비밀번호 값
		System.out.println("비밀번호가 pass02인지 확인 : " + passwordEncoder.matches("pass02", password));
		
	}

}
