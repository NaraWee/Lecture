package com.greedy.section02.array;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.greedy.model.dto.MemberDTO;

/**
 * Servlet implementation class ReceiveJsonArrayServlet
 */
@WebServlet("/receive/array")
public class ReceiveJsonArrayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO member1 = new MemberDTO("M01","길동","홍",20);
		MemberDTO member2 = new MemberDTO("M02","순신","이",20);
		MemberDTO member3 = new MemberDTO("M03","관순","유",20);
		MemberDTO member4 = new MemberDTO("M04","봉길","윤",20);
		
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
		
		JSONArray jsonArray = new JSONArray();
		for(MemberDTO member : memberList) {
			JSONObject json = new JSONObject();
			json.put("code", member.getCode());
			json.put("firstname", member.getFirstName());
			json.put("lastName", member.getLastName());
			json.put("age", member.getAge());
			
			jsonArray.add(json);
		}
		
		System.out.println(jsonArray.toJSONString());
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonArray.toJSONString());
		
		out.flush();
		out.close();
	}

}
