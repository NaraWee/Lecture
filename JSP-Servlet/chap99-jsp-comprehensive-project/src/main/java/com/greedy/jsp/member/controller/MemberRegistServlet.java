package com.greedy.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.member.model.dto.MemberDTO;
import com.greedy.jsp.member.model.service.MemberService;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {

	/* 회원 가입 버튼 클릭 시 get요청이 들어오기 때문에 회원가입하는 form으로 포워딩 해주는 역할 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/registForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/* 회원 가입 폼을 작성 후 post요청을 할 경우 처리하는 역할 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone").replace("-","");
		String email = request.getParameter("email");
		//02592$서울 동대문구 서울시립대로 5$102호
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$"
				         + request.getParameter("address2");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		requestMember.setNickname(nickname);
		requestMember.setPhone(phone);
		requestMember.setEmail(email);
		requestMember.setAddress(address);
		
		System.out.println("memberController requestMember : " + requestMember);
		
		int result = new MemberService().registMember(requestMember);
		
		System.out.println("memberController result : " + result);
		
		String page = "";
		
		if(result > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertMember");
			
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 가입 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
