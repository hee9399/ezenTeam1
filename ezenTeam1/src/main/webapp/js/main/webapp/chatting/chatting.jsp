<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!-- 폰트어썸 css  -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	
		<div class="webcontainer">
		
		<!-- 채팅전체구역 -->
		<div class="chattbox">
			<!-- 채팅내용 목록 -->	
			<div class="chatcont">
			<!-- js가 출력해주는 구간 -->
		</div>
			<!-- 채팅입력창 , 전송버튼 -->
			<div class="chatbottom">
				<textarea onkeyup="onEnterKey()" class="msg"></textarea>		
				<button onclick="onSend()" type="button">전송	</button>
			</div>
			
			<!-- 이모티콘 , 첨부파일 등등 구역 -->
			<div class="dropdown">
  			<button class="" type="button" data-bs-toggle="dropdown" aria-expanded="false">
   				 <i class="far fa-grin-squint"></i>
  			</button>
				 <ul class="dropdown-menu emolistbox">
					   
				 </ul>
		</div>
	</div>		
</div>
				
		
		
		<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>

<!-- 
			<div class="rcont"> 
				<div class="subcont">
				
					<div class="date">오전 10:02</div>
					<div class="content">안녕하세요. ㅋㅋㅋㅋ</div>					
				</div>
			</div>
			
			<div class="aLorm"> 강호동님이 입장 하셨습니다.</div>
			
			
			<div class="Lcont">
				
				<img class="pimg" src="/jspweb/Member/img/defult.webp"/>
				<div class="tocont">
					<div class="name">강호동</div> 
					<div class="subcont">
						<div class="content"> 그래 안녕~~~~ </div>
						<div class="date"> 오전 10:10 </div>
					</div>
				</div>
			</div>
		</div> -->