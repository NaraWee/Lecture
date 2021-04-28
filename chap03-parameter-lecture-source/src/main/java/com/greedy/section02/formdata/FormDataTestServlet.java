package com.greedy.section02.formdata;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormDataTestServlet
 */
@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDataTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * GET방식의 데이터는 HTML charset에 기술된 인코딩 방식으로 브라우저가 한글을 이해한 뒤 %문자로 URLEncoder를 이용하여
		 * 변환 후 url 요청으로 전송한다.
		 * 
		 * GET요청은 보통 서버쪽 리소스를 가져오는 용도의 행위를 요청하는 http요청 방식이기에 별도의 데이터가 필요 없어서 요청본문(페이로드)는
		 * 해석하지 않게 된다.
		 * 
		 * 하지만 서버쪽 리소스에 추가해야하는 정보를 페이로드에 key&value방식으로 담아서 전송하게 되는데, 헤더와는 별개로 URLEncoder를
		 * 이용하지 않고 페이지 meta에 기술된 페이로드를 디코딩하는 방식은 별도로 지정되지 않아 request.getCharacterEncoding()을 이용해서
		 * 확인해보면 null을 반환하게 된다. 인코딩 된 방식을 명시해주지 않으면 ISO-8859-1로 해석되어 한글이 깨지는 현상이 발생한다.
		 * -> 이때, parameter를 꺼내오기 전에 parameter값을 인코딩 방식이 UTF-8임을 setCharacterEncoding(String encType)으로 지정해주면
		 * 브라우저에서 요청한 인코딩 방식과 일치하게 되어 한글 깨짐 현상을 막을 수 있다.
		 */
		
		/* 기본 설정된 인코딩 방식이 null이기 때문에 톰켓의 기본 셋팅 값인 ISO-8859-1로 디코딩을 시도하게 된다. */
		System.out.println(request.getCharacterEncoding());
		
		/* 파라미터 값을 꺼내기 전에 디코딩할 인코딩 방식을 설정해주면 해당 방식으로 페이로드의 값을 해석한다. */
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		/* 인코딩을 제외한 나머지 값들은 GET방식에서 값을 꺼내온 것과 동일하다. */
		
		Map<String,String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("key : " + key);
			for(int i = 0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " + value[i]);
			}
		}
		
		/* 파라미터로 전달된 키 목록만도 확인할 수 있다.
		 * -> request.getParameterNames()를 이용
		 */
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
	}

}
