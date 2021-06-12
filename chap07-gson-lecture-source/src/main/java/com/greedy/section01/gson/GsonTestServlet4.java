package com.greedy.section01.gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class GsonTestServlet4
 */
@WebServlet("/gson/test4")
public class GsonTestServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jsonString = request.getParameter("jsonString");
		
		/* view에서 전달받은 날짜는 2021-05-17 형태로 전송된다. */
		System.out.println(jsonString);
		
//		Gson gson = new Gson();
		/*
		 * GsonBuilder를 이용하여 Gson에 대한 설정을 해 주어야 한다.
		 * 특히 날짜 포멧의 경우 setDateFormat() 메소드를 이용할 수 있다.
		 */
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		
		/*
		 * 포멧 변경 테스트 java object -> json의 경우 포멧 적용됨
		 * json -> java object의 경우 포멧 적용 안된다.(위의 설정을 해주지 않으면 gson이 날짜를 해석하는 것이 불가능하다.)
		 */
		String dateTest = gson.toJson(new java.sql.Date(System.currentTimeMillis()));
		System.out.println(dateTest);
		
		MemberDTO member = gson.fromJson(jsonString, MemberDTO.class);
		System.out.println(member);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(gson.toJson(member));		// 여기서 날짜 포멩이 변경되어 전달된다.
		
		out.flush();
		out.close();
	}

}
