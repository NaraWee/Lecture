package com.greedy.section03.map;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.model.dto.MemberDTO;

/**
 * Servlet implementation class ReceiveMapServlet
 */
@WebServlet("/receive/map")
public class ReceiveMapServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO member1 = new MemberDTO("get","gildong","hong",20);
		MemberDTO member2 = new MemberDTO("get","soonsin","lee",40);
		MemberDTO member3 = new MemberDTO("get","gwansoon","yoo",16);
		MemberDTO member4 = new MemberDTO("get","bonggil","yoon",33);
		
		Map<String,MemberDTO> memberMap = new HashMap<>();
		memberMap.put("one",member1);
		memberMap.put("two",member2);
		memberMap.put("three",member3);
		memberMap.put("four",member4);
		
		StringBuilder sb = new StringBuilder();
		Iterator<String> keyIter = memberMap.keySet().iterator();
		
		sb.append("{");
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			
			sb.append("\"").append(key).append("\":").append(memberMap.get(key));
			
			if(keyIter.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("}");
		
		System.out.println(sb);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		
		out.flush();
		out.close();
	}

}
