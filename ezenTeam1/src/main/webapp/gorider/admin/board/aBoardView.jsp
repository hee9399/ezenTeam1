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
	<div class="contBox">
		<div class="vbtnBox">
			<button type="button">삭제하기</button>
			<button onclick="onList()" type="button">목록보기</button>
		</div>
		
		<ul class="bviewBox">
		<!-- 
			<li class="bvTitle">[공지] 글로벌 향하는 고라이더.유럽 바이크도 '고라이더로'로 부른다 <span class="bvDate">2023-10-06</span></li>
			<li class="bvEventPeriod">이벤트기간 : 2023-10-06 ~ 2023-10-31</li>
			<li class="bvImg"><img src="/ezenTeam1/gorider/admin/board/bfiles/test.png"></li>
			<li class="bvCont">직장인이라면? 카카오 T 비즈니스 하세요!
야근 택시, 대리비 등등 정산할 때 마다 번거로우셨죠? 
카카오 T 비즈니스에 간편 등록해두면?
매월 이용내역과 영수증을 정리해 보내드려요. 📩
이제 업무이동과 관리, 정산까지 카카오 T에 맡겨주세요.
지금 신규 등록하면, 에어팟프로 이벤트까지 응모 가능 🎁
▶자세히 보기: https://bit.ly/3jXIlH7
🖐 비즈니스 홈은 카카오 T앱 최신버전에서만 이용 가능합니다.
🖐 카카오 T 앱 하단 비즈니스 탭에서 간편 등록하세요.</li> -->
		</ul>

	</div>
</div>
<script src="/ezenTeam1/js/gorider/admin/adminBoardView.js"></script>

</body>
</html>