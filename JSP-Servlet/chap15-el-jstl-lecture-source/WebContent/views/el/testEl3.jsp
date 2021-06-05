<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>parameter 값 받아서 출력하기</h2>
	
	<%-- <% 
		// setAttribute()로 넘어온 값은 Object, getParameter()로 넘어온 값은 String
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String[] no = request.getParameterValues("no");
		String option = request.getParameter("option");
		
	%>
	
	상품명 : <%= name %><br>
	가격 : <%= price %><br>
	제품번호 : <%= no[0] %> 와 <%= no[1] %><br>
	옵션 : <%= option %><br> --%>
	
	<!-- 파라미터는 반드시 스코프를 명시해야한다. 하지않으면 값을 가지고오지 못한다. -->
	<%-- 상품명 : ${ name } --%>
	
	상품명 : ${ param.name } <br>
	가격 : ${ param.price } <br>
	제품번호 : ${ paramValues.no["0"] } 와 ${ paramValues.no["1"] } <br>
	옵션 : ${ (empty param.option) ? "옵션없음" : param.option } <br>
</body>
</html>