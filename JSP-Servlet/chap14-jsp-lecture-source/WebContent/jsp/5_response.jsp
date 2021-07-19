<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// request에 setAttribute로 담은 값은 getAttribute로 꺼내올 수 있다.
		String menuName = request.getParameter("menuName");
		int amount = Integer.parseInt(request.getParameter("amount"));
		int orderPrice = (Integer) request.getAttribute("orderPrice");
	%>
	<h3>주문하신 음식 : <%= menuName %></h3>
	<h3>주문하신 수량 : <%= amount %>인분</h3>
	<h2>결제하실 최종 금액 : <%= orderPrice %>원</h2>
</body>
</html>