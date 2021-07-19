package com.greedy.section01.simple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.greedy.model.dto.MemberDTO;

/**
 * Servlet implementation class ReceiveSimpleObjectServlet
 */
@WebServlet("/receive/simple")
public class ReceiveSimpleObjectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO member = new MemberDTO("M01","gildong","hong",20);
		
		JSONObject json = new JSONObject();
		json.put("code", member.getCode());
		json.put("firstName", member.getFirstName());
		json.put("lastName", member.getLastName());
		json.put("age", member.getAge());
		
		System.out.println(json.toString());
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		
		out.flush();
		out.close();
	}

}
