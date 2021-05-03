package com.greedy.section02.headers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderPrintServlet
 */
@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseHeaderPrintServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Refresh", "1");
		
		PrintWriter out = response.getWriter();
		
		long currentTime = System.currentTimeMillis();
		
		out.print("<h1>" + currentTime + "</h1>");
		
		out.close();
		
		Collection<String> responseHeaders = response.getHeaderNames();
		Iterator<String> iter = responseHeaders.iterator();
		while(iter.hasNext()) {
			String headerName = iter.next();
			System.out.println(headerName + " : " + response.getHeader(headerName));
		}
	}

}
