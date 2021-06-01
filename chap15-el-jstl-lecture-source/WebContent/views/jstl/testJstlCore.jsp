<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">JSTL Core Library Tag Test</h1>
	
	<h2>c:set 태그 : 변수 선언</h2>
	<!--  scope 생략 시 기본 pageScope이다. -->
	<c:set var="num1" value="100" scope="session"/>
	<c:set var="num2" value="200" scope="session"/>
	
	<!-- c:set으로 사용한 변수는 scriptlet 요소에서 쓰는 것이 불가능하다. -->
<%-- 	<% int sum = num1 + num2; %> --%>
	<!-- el로 접근해야한다. -->
	<c:set var="sum" value="${ num1 + num2 }"/>
	num1 + num2 = ${ sum }<br>
	
	<!-- scriptlet 요소에서 선언된 변수는 el이나 scriptlet요소로 사용 가능하다. -->
	<% int num3 = 10, num4 = 20; %>
	<!-- 에러는 나지 않지만 값은 못가져온다. -->
	num3 + num4 = ${ num3 + num4 }<br>
	
	<c:set var="sum2" value="<%= num3 + num4 %>"/>
	num3 + num4 = ${ sum2 }<br>
	
	<hr>
	
	<h2>c:set 태그 : 배열 또는 컬렉션으로 사용할 문자열 선언</h2>
	<c:set var = "colors">
		red, orange, yellow, green, blue, purple
	</c:set>
	colors 배열 값 확인 : ${ colors }<br>
	
	<script>
		window.onload = function() {
			var colors = '${ colors }'.split(', ');
			console.log(colors);
		}
	</script>
	
	<h2>c:remove 태그 : 변수 삭제</h2>
	num1 변수 값 : ${ num1 }<br>
	num2 변수 값 : ${ num2 }<br>
	
	<!-- 삭제 시 scope를 지정하지 않으면, 모든 scope의 동일 이름의 변수를 제거 -->
	<c:remove var="num1" scope="session"/>
	<c:remove var="num2" scope="session"/>
	num1 변수 값 : ${ num1 }<br>
	num2 변수 값 : ${ num2 }<br>
	
	<hr>
	
	<h2>이스케이프시퀀스 : <, >, $ 등의 특수문자를 &lt;와 &gt;와 &amp;로 바꿔서 인식한다.</h2>
	<h2>c:out 태그 : 값 출력용</h2>
	<c:out value="core 라이브러리의 <out> 태그는 값을 화면에 출력하는 태그이다."/><br>
	
	<!-- escapeXml을 false로 지정하면 <,> 등을 태그로 인식하고, true로 지정하면 문자로 동작한다. -->
	<c:out value="<h2>데이터출력<h2>" escapeXml="false"/><br>
	<c:out value="<h2>데이터출력<h2>" escapeXml="true"/><br>
	
	<h2>c:if 태그 : 조건문</h2>
	<c:set var="value1" value="9" scope="page"/>
	<c:set var="value2" value="3" scope="page"/>
	value1의 값은 <c:out value="${ value1 }"/> 이고, value2의 값은 <c:out value="${ value2 }"/>입니다.
	
	<!-- test속성에 조건식을 기술하며, 조건식은 반드시 el형식으로 기술해야 한다. -->
	<c:if test="${ value1 >= value2 }">
		<h3>value1이 큽니다. : ${ value1 }</h3>
	</c:if>
	<c:if test="${ value1 < value2 }">
		<h3>value2가 큽니다. : ${ value2 }</h3>
	</c:if>
	
	<hr>
	
	<h2>c:choose : switch문, c:when : case문, c:otherwise : default문</h2>
	<c:set var="no" value="${ param.no }"/>
	
	param.no의 값은 <c:out value="${ param.no }"/>입니다.
	<c:choose>
		<c:when test="${ no == 1 }"><h3>안녕하세요</h3></c:when>
		<c:when test="${ no eq 2 }"><h3>반갑습니다.</h3></c:when>
		<c:otherwise><h3>환영합니다.</h3></c:otherwise>
	</c:choose>
	
	<hr>
	
	<h2>c:forEach태그 : for문</h2>
	
	<c:forEach begin="1" end="10">
		반복실행<br>
	</c:forEach>
	<br>
	
	<c:forEach var="size" begin="1" end="7" step="1">
		<font size="${ size }">글자크기 ${ size }</font><br>
	</c:forEach>
	
	<br>
	
	<h2>c:forEach 태그 : 배역 또는 컬랙션 연속처리에 for~each 문처럼 사용한다.</h2>
	<!-- 
		varStatus를 통해 상태를 관리할 수 있다.
		current : 현재 반복 횟수, index : 제로기반 인덱스, count : 1기반 인덱스
		first : 현재 라운드가 반복을 통한 첫번째, last : 현재 라운드가 반복을 통한 마지막 번째
	 -->
	<c:forEach var="color" items="${ colors }" varStatus="st">
		<font color="${ color }">
			<%-- ${ st.index } : 글자색 ${ color } --%>
			${ st.count } : 글자색 ${ color }
		</font><br>
	</c:forEach>
	
	<h2>c:forTokens 태그 : 문자열을 토큰으로 분리 처리할 때 사용</h2>
	
	<c:forTokens var="color" items="yellow blue pink red green" delims=" ">
		<li>${ color }</li>
	</c:forTokens>
	
	<h3>여러 개의 토큰 문자를 가지고 분리 처리할 수도 있다.</h3>
	<c:forTokens var="color" items="yellow-blue*pink/red green" delims="/-* ">
		<li>${ color }</li>
	</c:forTokens>
	
	<h2>c:url 태그 : 링크 설정 정보 별도 지정시 사용하는 태그</h2>
	<c:url var="ftmlink" value="testJstlCoreResult.jsp">
		<c:param name="num" value="77"/>
	</c:url>
	<a href="${ ftmlink }">결과 화면 연결</a>
</body>
</html>