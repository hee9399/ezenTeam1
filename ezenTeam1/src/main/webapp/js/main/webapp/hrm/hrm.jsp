<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/hrm.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<h2>인사 관리 등록</h2>
	<form class="signupForm">
		<div>직급</div>
		<select class="position" name="position">
			<option value="사장">사장</option>
			<option value="부장">부장</option>
			<option value="팀장">팀장</option>
			<option value="대리">대리</option>
			<option value="주임">주임</option>
			<option value="사원">사원</option>
		</select> <br>
		<div class = "intitle">프로필</div>
			<input onchange = "preimg(this)"class = "hfile" name = "himg" type = "file"/>
			<img class = "preimg" alt = "" src = "img/defult.webp">
		<div class="intitle">직원명:</div>
		<input type="text" id="name" name="name"><br>
		<div class="intitle">전화번호:</div>

		<input type="tel" id="phone" name="phone"><br>

		
		

		<button type="button" onclick="save()">저장</button>
	</form>
	<div class="hrm_Bottom">
		<!-- 출력 구역 -->
		
		
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/hrm.js" type="text/javascript"> </script>

</body>
</html>