<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Exception handler 사용하기</h1>
	
	<!-- 
		 1. SimpleMappingExceptionResolver를 이용하여 컨텍스트에서 발생한 예외를 카테고리별로 매핑할 수 있다.(전역)
		 2. @ExceptionHandler 어노테이션을 이용하여 예외를 매핑할 수 있다.(클래스별)
	 -->
	 
	 <h3>SimpleMappingExceptionResolver를 이용한 방식</h3>
	 <button onclick="location.href='simple-null'">NullPointerException 테스트</button>
	 <button onclick="location.href='simple-user'">사용자 정의 Exception 테스트</button>
	 
	 <h3>@ExceptionHandler 어노테이션을 이용한 방식</h3>
	 <button onclick="location.href='annotation-null'">NullPointerException 테스트</button>
	 <button onclick="location.href='annotation-user'">사용자 정의 Exception</button>
</body>
</html>