<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="../css/sns.css"  rel="stylesheet">

</head>
<body>

	<div class="container" >
	<form class="snsForm">
		<div class="contBox">
			<div>
				<input name="sfile" type="file">
			</div>
			<div class="cont">
				<textarea name="scontent" class="scontent"></textarea>
			</div>
			<div class="footer">
				<input type="password" name="spwd" class="pwd" placeholder="비밀번호 최소 8자리 이상"> 


				<button class="btn" onclick ="swrite()" type="button">등록</button>

				<button class="btn" onclick ="onUpdate()" type="button">수정</button>
				<button class="btn"  onclick ="" type="button">삭제</button>

			</div>
		
		</div>
	</form>
	 </div>


	


	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script src = "/ezenTeam1/js/sns.js" type="text/javascript"></script>
</body>
</html>