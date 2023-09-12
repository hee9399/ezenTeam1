<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!--  css import  -->
	<link href="visitlog.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
			<%@include file = "../header.jsp" %>
			
			<!-- CRUD(Restful Api) 기반의 게시판 구현 -->
			<div class ="visitwrap"> <!-- 전체구역 -->
			
				<div class="visit_Top"> <!-- 쓰기 구역 -->
					<div class="visit_Inputs">
						<input class= "vwriter" type="text" placeholder="작성자"> <!-- placeholder =속성은 입력 필드에 사용자가 적절한 값을 입력할 수 있도록 도와주는 짧은 도움말 -->
						<input class= "vpwd" type ="password" placeholder="비밀번호">
					</div>
					<textarea class= "vcontent" placeholder="방문록내용"></textarea> <!-- textarea :  input보다 더 긴 텍스트를 입력받고 싶을 때 사용 => 보통 짧은 방명록이나 댓글을 입력할 때 textarea 태그를 많이 사용한다. -->
					<button type="button" onclick="vwrite()">등록</button>
				</div>			
	
				<div class="visit_Bottom">	 <!-- 출력 구역 -->
					<!-- js가 출력해주는 구역 -->
					
				</div>
				 
			</div>
			
			

	
	<!--  최신 jQUERY impot (AJAX() 사용할 JS파일 위에서 호출  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script >
	<!-- js imprt -->
	<script src="visitlog.js" type="text/javascript"></script>
</body>
</html>