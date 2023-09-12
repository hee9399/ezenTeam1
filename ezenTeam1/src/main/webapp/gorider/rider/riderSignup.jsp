<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- 라이더 회원가입 -->

	
	<div class="wrap"> <!-- 전체구역 -->
		<div class="signupWarp"> <!-- 라이더 회원가입 전체구역 -->
			<div class="header">
				<h2> 라이더 회원가입  </h2>
				<p> 환영합니다. </p>
			</div>
			
			<form class="signupForm"> 
			
				<ul>
					<!-- 라이더 이름 -->
					<li class="title"> 라이더이름 </li>
					<li class="input"> <input name="rname" class="rname" type="text" /> </li>
					
					<!-- 라이더 아이디 -->
					<li class="title"> 아이디 </li>
					<li class="input"> <input maxlength="30" name="rid" class="rid" type="text" /> </li>
					
					<!-- 라이더 비밀번호 -->
					<li class="title"> 비밀번호 </li>
					<li class="input"> <input maxlength="30" name="rpwd" class="rpwd" type="text" /> </li>
					<li class="title"> 비밀번호 확인 </li>
					<li class="input"> <input maxlength="30" name="rpwd2" class="rpwd2" type="text" /> </li>
					
					<!-- 라이더 전화번호 -->
					<li class="title"> 전화번호 <button class="" type="button" disabled></button> </li>
					<li class="input"> <input maxlength="30" name="sphone" class="sphone" type="text"> </li>
					<li class="title"> 전화번호 인증번호 </li>
					<li class="input">  
						<input maxlength="30" name="sid" class="sphone" type="text" />
						<button class="" type="button" disabled> 인증 </button>
					</li>
					<!-- 라이더프로필 -->
					<li class="title"> 프로필 </li>
					<li class="input"> <input onchange="preimg(this)" name="simg" class="simg" type="file" /> </li>
					<!-- 라이더 면허증 -->
					<li class="title"> 면허증 </li>
					<li class="input"> <input onchange="preimg(this)" name="simg" class="simg" type="file" /> </li>
					<!-- 라이더 차량등록증 -->
					<li class="title"> 차량등록증 </li>
					<li class="input"> <input onchange="preimg(this)" name="simg" class="simg" type="file" /> </li>
					<!-- 라이더 계좌번호 -->
		      	    <li class="title"> 계좌번호 </li>		   
		         	<li class="payinfo">
		         		 <input  maxlength="4" name="mpadinfo1" class="mid" type="text"/> 
		         			- <input  maxlength="4"  name ="mpadinfo2" class="mid" type="text"/>
		         			- <input  maxlength="4"  name ="mpadinfo3" class="mid" type="text"/>
		         			- <input  maxlength="4"  name ="mpadinfo4" class="mid" type="text"/>
		         	</li>
				</ul>
			
			</form>
		</div>	 <!-- 라이더 회원가입 전체구역 e -->
	</div> <!-- 전체구역 e -->
	
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

   <!-- js -->
   <script src="/ezenTeam1/js/gorider/riderSignup.js" type="text/javascript"></script>
	

</body>
</html>