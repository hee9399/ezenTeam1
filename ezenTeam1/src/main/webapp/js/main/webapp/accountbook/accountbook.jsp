<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부</title>
		<link href="accountbook.css" rel = "stylesheet"/>
</head>
<body>

		<%@include file = "../header.jsp" %>
		<div class="awrap">
			<div class = "aname">가계부</div>
				<div class = "aTop">
					
					<textarea class="acontent" placeholder="항목내용"  rows="" cols=""></textarea>
					<input  class="aprice" type="text" placeholder="금액">
					<input  class="adate" type="text" placeholder="날짜">
					<button onclick="awriter();" class="awriter" type="button">등록</button>
				</div>
				<div class = "aBottom"><!--아래 출력구역  -->
					<div class="abox">
						<div class="aBt_content"></div>
						<div class="aBt_price"></div>
						<div class="aBt_date"></div>
						<button onclick="aupdate();" type="button">수정</button>
						<button onclick="adelete();" type="button">삭제</button>
					</div>
				</div>
				
		</div>	
		
		
		
		<!-- AJAX 연결  -->
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<script src="../js/accountbook.js" type="text/javascript"> </script>
	
	<div>	<!-- 출력할 구역  -->
	
	
	</div>

</body>
</html>