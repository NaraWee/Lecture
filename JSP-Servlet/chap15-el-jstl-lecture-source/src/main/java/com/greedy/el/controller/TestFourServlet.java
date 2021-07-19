package com.greedy.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.el.model.dto.MemberDTO;

/**
 * Servlet implementation class TestFourServlet
 */
@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO requestMember = new MemberDTO("홍길동",20,"010-1234-5567","hong@greedy.com");
		MemberDTO sessionMemeber = new MemberDTO("유승제",20,"0105678-3467","ysj@greedy.com");
		
		HttpSession session = request.getSession();
		
		request.setAttribute("member", requestMember);
		session.setAttribute("member", sessionMemeber);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/testEl4.jsp");
		view.forward(request, response);
	}

}
