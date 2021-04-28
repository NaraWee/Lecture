package com.greedy.section01.querystring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryStringTestServlet
 */
@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStringTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* HttpServlet 클래스의 Service 메소드가 요청 방식에 의해 GET요청은 doGet() 메소드로 호출하며 request, response를 전달해준다.
		 * 톰캣 서블릿 컨테이너가 해당 요청 url로 매핑된 Servlet클래스의 인스턴스를 생성하여 service 메소드를 호출하고
		 * HttpServlet을 상속받아 오버라이딩한 현재 클래스의 doGet() 메소드가 동적바인딩에 의해 호출된다.
		 */
		
		/*
		 * service로부터 전달받은 HttpServletRequest는 요청 시 전달한 값을 getParameter()메소드로 추출해 올 수 있다.
		 * 이 때 인자로 input 태그에 지정한 name 속성의 값을 문자열 형태로 전달해주어야 한다.
		 * 화면에서 전달한 form 내의 모든 input 태그의 값들은 HashMap으로 관리하고 있는데, 원하는 값을 찾기 위해서는 key역할을 하는
		 * 문자열이 필요하기 때문에 name 속성을 쓴다.
		 */
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		/*
		 * getParameter는 리턴타입이 문자열 형태이다
		 * 즉, 숫자를 전달해도 문자열 형태로 전달되는 것이다. 주의하자
		 * --> 숫자로 된 값이 필요하다면 검증 후에 parseInt를 해주어야 한다.
		 */
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("나이 : " + age);
		
		/*
		 * java.sql.Date 타입으로 저장하고 싶은 경우에는 전달된 parameter를 Date type으로 변경해야 한다.
		 * java.sql.Date의 valueOf() 메소드에 전달받은 파라미터를 넘기면 타입을 변환시켜준다.
		 */
		java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		System.out.println("생일 : " + birthday);
		
		/*
		 * radioButton으로 전달된 값은 여러 값 중 한가지만 전달되기 때문에 parameter로 전달받은 값을 꺼내기만 하면 된다.
		 */
		String gender = request.getParameter("gender");
		System.out.println("성별 : " + gender);
		
		String national = request.getParameter("national");
		System.out.println("국적 : " + national);
		
		/*
		 * checkbox는 다중으로 입력을 할 수 있기 때문에 선택된 값이 문자열이 아닌 문자열 배열로 전달된다.
		 * 이 때 getParameterValues()메소드를 이용하여 문자열 배열 형태로 값을 반환받을 수 있다.
		 */
		String[] hobbies = request.getParameterValues("hobbies");
		for(String hobby : hobbies) {
			System.out.println(hobby);
		}
	}

}