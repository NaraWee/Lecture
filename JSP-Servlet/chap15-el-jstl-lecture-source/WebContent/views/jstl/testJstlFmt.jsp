<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">JSTL Fmt Library Tag Test</h1>
	
	<h2>fmt:formatNumber 태그 : 숫자에 포맷 적용하는 태그</h2>
	<c:set var="number" value="123456789"/>
	
	<!-- ','와 같은 각 숫자 단위와 구분자를 표시 -->
	<fmt:formatNumber value="${ number }" groupingUsed="true"/><br>
	
	<!-- 소수점 자리 패턴에 맞춰 반올림 처리된다. -->
	<fmt:formatNumber value="1.234567" pattern="#.###"/><br>
	
	<!-- 소수점 자리 패턴에 맞춰 소수 표현하지만 모자라는 자리수는 그냥 원래 값대로 표현한다. -->
	<fmt:formatNumber value="1.2" pattern="#.##"/><br>
	
	<!-- 소수점 자리 패턴에 맞춰 소수 표현하지만 모자라는 자리수는 0으로 채운다. -->
	<fmt:formatNumber value="1.2" pattern="#.00"/><br>
	
	<!-- 백분율로 계산된 퍼센트를 계산하여 출력 -->
	<fmt:formatNumber value="0.12" type="percent"/><br>
	
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>
	
	<hr>
	
	<h2>fmt:formatDate태그 : 날짜와 시간에 포맷 적용하는 태그</h2>
	<c:set var="today" value="<%= new java.util.Date() %>"/>
	오늘 날짜 : <fmt:formatDate value="${ today }" type="date"/><br>
	현재 시간 : <fmt:formatDate value="${ today }" type="time"/><br>
	현재 날짜와 시간 : <fmt:formatDate value="${ today }" type="both"/><br>
	
	<h2>날빠와 시간에 제공되는 포맷을 적용한 경우</h2>
	<!-- medium이 default값이다. -->
	[default] : <fmt:formatDate value="${ today }" type="both" dateStyle="default" timeStyle="default"/><br>
	[short] : <fmt:formatDate value="${ today }" type="both" dateStyle="short" timeStyle="short"/><br>
	[medium] : <fmt:formatDate value="${ today }" type="both" dateStyle="medium" timeStyle="medium"/><br>
	[long] : <fmt:formatDate value="${ today }" type="both" dateStyle="long" timeStyle="long"/><br>
	[full] : <fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/><br>
	
	<h3>원하는 포맷으로 pattern 적용한 경우</h3>
	현재 날짜 : <fmt:formatDate value="${ today }" type="date" pattern="yyyy/MM/dd (E)"/><br>
	현재 시간: <fmt:formatDate value="${ today }" type="time" pattern="(a) hh:mm:ss"/><br>
	
</body>
</html>