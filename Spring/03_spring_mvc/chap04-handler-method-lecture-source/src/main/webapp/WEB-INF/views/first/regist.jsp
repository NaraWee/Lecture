<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">파라미터로 값 전송하기</h1>
	
	<h3>신규 메뉴 등록하기</h3>
	<form action="regist" method="post">
		등록할 메뉴의 이름 : <input type="text" name="name"><br>
		등록할 메뉴의 가격 : <input type="text" name="price"><br>
		등록할 메뉴의 카테고리 : 
		<select name="categoryCode">
			<option value="1">식사</option>
			<option value="2">음료</option>
			<option value="3">디저트</option>
		</select><br>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>