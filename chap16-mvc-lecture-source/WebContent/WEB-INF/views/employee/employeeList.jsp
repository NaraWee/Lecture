<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>직원명</th>
			<th>주민등록번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>직급코드</th>
			<th>급여등급</th>
			<th>급여</th>
			<th>보너스율</th>
			<th>관리자사번</th>
			<th>입사일</th>
			<th>퇴사일</th>
			<th>퇴직여부</th>
		</tr>
	<c:forEach var="arr" items="${ allEmp }" varStatus="st">
		<tr>
			<td>${ arr.empId }</td>
			<td>${ arr.empName }</td>
			<td>${ arr.empNo }</td>
			<td>${ arr.email }</td>
			<td>${ arr.phone }</td>
			<td>${ arr.deptCode }</td>
			<td>${ arr.jobCode }</td>
			<td>${ arr.salLevel }</td>
			<td>${ arr.salary }</td>
			<td>${ arr.bounus }</td>
			<td>${ arr.managerId }</td>
			<td>${ arr.hireDate }</td>
			<td>${ arr.entDate }</td>
			<td>${ arr.entYn }</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>