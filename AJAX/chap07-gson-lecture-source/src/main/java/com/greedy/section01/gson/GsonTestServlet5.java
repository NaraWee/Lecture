package com.greedy.section01.gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class GsonTestServlet5
 */
@WebServlet("/gson/test5")
public class GsonTestServlet5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO member = new MemberDTO("M01","길동",null,20,new java.sql.Date(System.currentTimeMillis()));
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()	// json 문자열을 이쁘게 출력해준다.
//				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)	//필드 이름으로 json key값 네이밍 설정할 때 사용
				.serializeNulls()		// 필드값이 null이어도 직렬화한다.
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY) 	// 기본값
				.create();
		
		String jsonString = gson.toJson(member);
		System.out.println(jsonString);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

}
