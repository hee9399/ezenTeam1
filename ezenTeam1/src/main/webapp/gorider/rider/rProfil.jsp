<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<!-- css 호출 -->
	<link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
	<link href="/ezenTeam1/css/gorider/rider.css" rel="stylesheet">

</head>
<body>

	<!-- 라이더 내정보 수정 -->
	<div class="wrapR">  <!-- 라이더 프로필 전체구역 -->
	
		<div class="backimg" > <!-- 뒤로가기 버튼구역 -->
		
			 <a href="/ezenTeam1/gorider/rider/rMyMenu.jsp"> 
				<img class="rlogo" src="/ezenTeam1/gorider/rider/img/back.png"/> </a> 
			
		</div>
		
		<form class="rpChange">
		
			<div class="rphoto"> <!-- 라이더 프로필 사진 구역 -->
				
				 <img  src="/ezenTeam1/gorider/rider/img/default.webp"/>
				<input name="rphoto" type="file">
				<button onclick="changeImg()" type="button"> 수정하기 </button>
				
			</div> <!-- 라이더 프로필 사진 구역 e -->
		</form>
	
		<div class="rpcontent"> <!-- 라이더 이름 -->
			
			<div class="rpname">  </div>
			<div class="rzone"> 안산 상록구 , KOR </div>
			
		</div>  <!-- 라이더 이름 e -->
	
	
	</div> <!-- 라이더 프로필 전체구역 e -->

	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- js호출 -->
	<script src="../../js/gorider/rider/rProfil.js"></script>

</body>
</html>


















