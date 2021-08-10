<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1 align="center">jackson 라이브러리 이용하기</h1>
	
	<h3>1. stream을 이용한 전송</h3>
	<button id="jackson1">정보 조회하기</button>
	<table id="memberInfo1" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>
				<th width="150">이름</th>
				<th width="100">나이</th>
				<th width="200">가입일</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
		$("#jackson1").click(function(){
			$.ajax({
				url:"jackson1",
				success:function(data,status,xhr){
					console.log(data);
					
					const $table = $("#memberInfo1 tbody");
					
					$table.html("");
					
					for(let index in data) {
						$tr = $("<tr>");
						$noTd = $("<td>").text(data[index].no);
						$nameTd = $("<td>").text(data[index].name);
						$ageTd = $("<td>").text(data[index].age);
						$enrollDateTd = $("<td>").text(data[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				}, error:function(xhr,status,error){
					console.log(error);
				}
			});		
		});
	</script>
	
	
	<h3>2. @ResponseBody를 이용한 응답</h3>
	<button id="jackson2">정보 조회하기</button>
	<table id="memberInfo2" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>
				<th width="150">이름</th>
				<th width="100">나이</th>
				<th width="200">가입일</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
		$("#jackson2").click(function(){
			$.ajax({
				url:"jackson2",
				data: { index : 1 },
				success:function(data,status,xhr){
					console.log(data);
					
					const $table = $("#memberInfo2 tbody");
					
					$table.html("");
					
					for(let index in data) {
						$tr = $("<tr>");
						$noTd = $("<td>").text(data[index].no);
						$nameTd = $("<td>").text(data[index].name);
						$ageTd = $("<td>").text(data[index].age);
						$enrollDateTd = $("<td>").text(data[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				}, error:function(xhr,status,error){
					console.log(error);
				}
			});		
		});
	</script>
	
	
	<h3>3. @ResponseBody를 MessageConverter 자동 변환 후 응답</h3>
	<button id="jackson3">정보 조회하기</button>
	<table id="memberInfo3" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>
				<th width="150">이름</th>
				<th width="100">나이</th>
				<th width="200">가입일</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
		$("#jackson3").click(function(){
			$.ajax({
				url:"jackson3",
				success:function(data,status,xhr){
					console.log(data);
					
					const $table = $("#memberInfo3 tbody");
					
					$table.html("");
					
					for(let index in data) {
						$tr = $("<tr>");
						$noTd = $("<td>").text(data[index].no);
						$nameTd = $("<td>").text(data[index].name);
						$ageTd = $("<td>").text(data[index].age);
						$enrollDateTd = $("<td>").text(data[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				}, error:function(xhr,status,error){
					console.log(error);
				}
			});		
		});
	</script>
	
	
	<h3>4. jsonView를 이용한 ModelAndView 응답</h3>
	<button id="jackson4">정보 조회하기</button>
	<table id="memberInfo4" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>
				<th width="150">이름</th>
				<th width="100">나이</th>
				<th width="200">가입일</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
		$("#jackson4").click(function(){
			$.ajax({
				url:"jackson4",
				success:function(data,status,xhr){
					console.log(data);
					
					const memberList = JSON.parse(data.memberList);
					const $table = $("#memberInfo4 tbody");
					
					$table.html("");
					
					for(let index in memberList) {
						$tr = $("<tr>");
						$noTd = $("<td>").text(memberList[index].no);
						$nameTd = $("<td>").text(memberList[index].name);
						$ageTd = $("<td>").text(memberList[index].age);
						$enrollDateTd = $("<td>").text(damemberList[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				}, error:function(xhr,status,error){
					console.log(error);
				}
			});		
		});
	</script>
</body>
</html>