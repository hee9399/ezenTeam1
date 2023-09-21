<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">

</head>
<body>

<div class="wrap">
	<%@include file="../member/header.jsp" %>

	<div class="contentBox">
		<div class = "callcontent">
		
		</div>
		<div class = "accept">
		
		</div>
	</div>

	<div class = "choicebox">
		<button onclick = "accept()" type = "button" class = "accept">수락</button>
		<button type = "button" class = "decline">거절</button>
	</div>
	

	<%-- <%@include file="../member/footer.jsp" %> --%>
</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=59b47c7057625f350189b1cb8369a874&libraries=services"></script>
	<script src="/ezenTeam1/js/gorider/service/riderAccept.js" type="text/javascript"></script>
	
</body>
</html>