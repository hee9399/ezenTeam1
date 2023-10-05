<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
<link href="/ezenTeam1/css/gorider/admin.css" rel="stylesheet">
<!-- <style type="text/css">*{border:solid 1px red;}</style> -->

</head>
<body>
<div class="wrap">
 <%@include file="../aheader.jsp" %>
	<div class="apageinfo"><i class="fa-solid fa-arrow-right-from-bracket fa-rotate-180"></i><span class="aptitle"> 공지사항 /이벤트 </span>  </div>
	<div class="listBox">
		<div class="listbtnBox"> 
			<button onclick="onWrite()" type="button">글작성하기</button>
		</div>
		<!-- 리스트 head -->
		<ul class="listhead">
			<li class="btype">종류</li>
			<li class="btarget">T</li>
			<li class="btitle">제목</li>
			<li class="bdate">작성일</li>		
		</ul>
		<!-- 리스트 body -->
		<div class="listbody">
			<ul class="listcont">
				<li class="btype">이벤트</li>
				<li class="btarget">R</li>
				<li class="btitle">제목제목제목제목제목제목제목제목제목</li>
				<li class="bdate">2023-10-05</li>		
			</ul>
			<ul class="listcont">
				<li class="btype">이벤트</li>
				<li class="btarget">U</li>
				<li class="btitle">제목제목제목제목제목제목제목제목제목</li>
				<li class="bdate">2023-10-05</li>		
			</ul>	
										
		</div>
		
	</div>
</div>
<script src="/ezenTeam1/js/gorider/admin/adminBoardList.js"></script>

</body>
</html>