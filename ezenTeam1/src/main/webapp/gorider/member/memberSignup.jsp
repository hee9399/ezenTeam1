<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
	<link href="/ezenTeam1/css/gorider/member.css" rel="stylesheet">

</head>
<body> <!-- 사용자 회원가입 -->

	
	<!-- 전체렙 -->
<div  class="wrap">
	<div class="signupWarp"> <!-- 회원가입 전체구역 -->
		<div class="header">
			<h2> 사용자 회원가입 </h2>
			<p> 환영합니다. </p>
		</div>
	
		<form class="signupForm">
		
			
			<!-- 회원이름  -->
			<div class="sname"> 회원이름 </div>
			<input name="mname" class="mname" type="text" />
			
			<!-- 회원아이디  -->
			
			<div class="sid"> 아이디 </div>
	
			<input  maxlength="30"  name="mid" class="mid" type="text" />
			
			<!-- 회원비밀번호 -->
			
			<!-- 회원이메일 -->
			
			<!-- 회원전화번호 -->
			
			<!-- 결제카드번호 -->
			
			<!-- 회원등록일 -->
			
		</form>
	</div> <!-- 회원가입 전체구역 e -->
</div>	
	
	
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- js -->
	<script src="/ezenTeam1/js/gorider/memberSignup.js" type="text/javascript"></script>


</body>
</html>