<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
	      
	         
	         <ul class="signupbox">
		          <!-- 회원이름  -->
		         <li class="title"> 회원이름 </li>
		         <li class="input"><input name="mname" class="mname" type="text" /></li>
		         
		         <!-- 회원아이디  -->
		         
		         <li class="title"> 아이디 </li>		   
		         <li class="input"><input  maxlength="30"  name="mid" class="mid" type="text"/></li>
		         
		         <!-- 회원비밀번호 -->
		         <li class="title"> 비밀번호 </li>		   
		         <li class="input"><input  maxlength="30"  name="mpwd" class="mpwd" type="text"/></li>
		         <li class="title"> 비밀번호 확인 </li>		   
		         <li class="input"><input  maxlength="30"  name="mpwd2" class="mpwd2" type="text"/></li>
		         <!-- 회원이메일 -->
		         <li class="title"> 이메일 <button class="" type="button" disabled>인증</button> </li>		   
		         <li class="input"><input  maxlength="30"  name="mid" class="memail" type="email"/></li>
		          <!-- 회원이메일 -->
		         <li class="title"> 이메일 인증번호 </li>		   
		         <li class="inputS">
		         	<input  maxlength="30"  name="mid" class="memail" type="email"/>
		         	<button class="" type="button" disabled>인증</button> 
		         </li>
		         
		         <!-- 결제카드번호 -->
		         <li class="title"> 결제카드번호 </li>		   
		         <li class="payinfo">
		         	 <input  maxlength="4  name="mpadinfo1" class="mid" type="text"/> 
		         	- <input  maxlength="4  name="mpadinfo2" class="mid" type="text"/>
		         	- <input  maxlength="4  name="mpadinfo3" class="mid" type="text"/>
		         	- <input  maxlength="4  name="mpadinfo4" class="mid" type="text"/>
		         </li>
		    
	         
	         </ul>
	         <div class="btnbox"><button class="btn" type="button">회원 등록</button></div>
	        
	         
	      </form>
	   </div> <!-- 회원가입 전체구역 e -->
	</div>   
   
   
   <!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

   <!-- js -->
   <script src="/ezenTeam1/js/gorider/memberSignup.js" type="text/javascript"></script>


</body>
</html>