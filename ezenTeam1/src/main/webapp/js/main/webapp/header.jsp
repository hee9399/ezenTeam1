<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/jspweb/css/header.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
			<div id="header">	
	
		<div class=mainlogo> <!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/Member/img/ezenLogo.png" />
			</a>
		</div>
				<ul class="mainmenu"><!-- 본메뉴 -->
					<li><a href="/jspweb/visitlog/visitlog.jsp">방문록[절대경로]</a> </li>
					<li><a href="/jspweb/board/list.jsp">게시판</a></li>
					<li><a href="/jspweb/datago/datago.jsp">공공데이터</a></li>
					<li><a href="/jspweb/chatting/chatting.jsp">채팅</a></li>
					<li><a href="/jspweb/accountbook/accountbook.jsp">과제1. 가계부</a></li>		
					<li><a href="/jspweb/library/library.jsp">과제2. 열람실</a></li>
					<li><a href="/jspweb/hrm/hrm.jsp">과제3.직원관리</a></li>	
				</ul>
				<!-- 서브메뉴 -->	
				<ul class="submenu"></ul>
				
			</div>
			
			
			
			<!-- 최신 JQERY  연결  -->
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src ="/jspweb/js/header.js"></script>
		
</body>
</html>

<!-- 
	해더 많은 페이지에서 참조하는 페이지 이므로 공통적인 코드
	1. 라이브러리

 -->

<!-- 404: 경롬누제 [1.그 경로/파일 없거나 2. 없는데 경로에 오타 -->
			<!--
				상대경로 : 현위치 기준으로 경로 작성.
				visitlog/visitlog.jsp
				절대경로 : 모든 경로 작성.
				http://localhost/jspweb/visitlog/visitlog.jsp
				 - 해더파일은 불특정 페이지 경로에서 사용되므로 절대경로 링크 권장
				 
			  -->