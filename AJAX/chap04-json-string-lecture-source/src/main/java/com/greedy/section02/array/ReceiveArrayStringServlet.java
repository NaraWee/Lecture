package com.greedy.section02.array;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveArrayStringServlet
 */
@WebServlet("/receive/array")
public class ReceiveArrayStringServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* json으로 javascript object로 변환시키기 위해서는 array의 경우 대괄호[]로 감싸고, 각 인덱스의 구분은 ,(콤마)로 한다. */
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("[{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
				+ "{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
				+ "{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
				+ "{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20}]");
		out.flush();
		out.close();
	}

}
