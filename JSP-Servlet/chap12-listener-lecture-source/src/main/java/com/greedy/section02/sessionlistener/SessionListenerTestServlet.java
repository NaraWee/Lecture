package com.greedy.section02.sessionlistener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionListenerTestServlet
 */
@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* session을 최초 발급받을 시 sessionCreate()가 동작한다. */
		HttpSession session = request.getSession();
		System.out.println("발급받은 session id : " + session.getId());
		
		/* session에 attribute를 추가 -> attributeAdded() 메소드가 동작 */
		session.setAttribute("username", "honggildong");
		session.setAttribute("age", 20);
		session.setAttribute("gender", "M");
		
		session.setAttribute("user", new UserDTO("honggildong",21));
		
		/* session에 attribute를 동일한 key로 덮어쓰는 경우(value 수정) attributeReplaced() 메소드 동작*/
		session.setAttribute("username", "hong");
		
		/* session에 attribute를 제거할 때 attributeRemoved()가 동작 */
		session.removeAttribute("gender");
		
		/* session를 만료하게 되면 sessionDestroyed가 동작 */
		session.setMaxInactiveInterval(2);
		
		session.invalidate();	// 만료 시 모든 attribute를 지운다.
	}

}
