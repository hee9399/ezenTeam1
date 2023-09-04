<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/sns.css"  rel="stylesheet">
</head>
<body>
	
	<div class="container" >
		<div class="headerBox"> <!-- header  -->
			<div>SNS</div>
			<button class="btn" type="button">등록</button>
		</div>
		<!-- 1개의 게시물 -->
		<div class="contBox">
			<div class="sphoto"><img src="/jspweb/sns/img/test.jpg"></div>
			<div class="sdate">2023-09-04</div>
			<div class="scontent">
			What is Lorem Ipsum?
Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
			</div>
			<div class="btnbox">
				<button class="btn" onclick ="" type="button">수정</button>
				<button class="btn" onclick ="sdelete()" type="button">삭제</button>
			</div>	
		</div>
	
	
	 </div>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src = "/ezenTeam1/js/sns.js"type="text/javascript"></script>
</body>
</html>