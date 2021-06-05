<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">include directive</h1>
	
	<!-- 
		inclue 지시자 태그를 이용하여 file 속성에 jsp 경로를 지정해주면 해당 jsp에 작성한 내용을 그대로 포함시켜
		현재 jsp 파일을 동작시킨다.
		동일한 변수 이름을 include 이후에 또 사용하게 되면 한 페이지 내에 동일한 변수가 생성되는 것이므로 컴파일 에러가 발생하게 된다.
	 -->
	 <div align="center"><%@ include file="today.jsp" %></div>
	 
	 <%
	 	// 동일한 변수 이름을 사용했기 때문에 컴파일 에러가 발생한다.
	 	//String output = "";
	 %>
</body>
</html>