package com.greedy.section01.jsonstring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveJsonStringServlet
 */
@WebServlet("/receive/json")
public class ReceiveJsonStringServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* ajax응답은 단 한번의 문자열 응답만 할 수 있다. 
		 * 따라서 여러 개의 값을 전달하기 위해서는 특수한 방법을 이용한다.
		 * java에서 이용하는 Object는 javascript에서는 이해할 수 없다.
		 * 따라서 자바스크립트에서 이해할 수 있는 Object 타입으로 변환을 해주어야 한다.
		 * 
		 * 이때 json이라는 object 타입으로 변환하 수 잇는 문자열 형태로 가공하여 응답을 해주게 되면
		 * javascript에서 object로 취급할 수 있다.
		 * 
		 * json 데이터의 규칙은 key와 value를 :(콜론)으로 구분하며, 여러 개의 key value set는 ,(콤마)로 구분한다.
		 * {"name":"홍길동","age":"10"}
		 * 이때 키는 문자열 형태로 ""로 감싸져야 하며, 문자열에 해당하는 값 또한 ""로 감싸져야 한다.
		 */
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20}");
		out.flush();
		out.close();
	}

}
