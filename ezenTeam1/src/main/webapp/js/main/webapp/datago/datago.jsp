<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%@include file = "../header.jsp" %>
		<div class="webcpmtaomer">
			<div>
				<h3>카카오지도</h3>
				<div class="detaibox">
						
				</div>
				<div id="map" style="width:100%;height:500px;"></div>
			</div>
			
			<div>
				<h6>안산시 착한가격없소 현황</h6>
					<table class="apiTable1">			
					</table>
			</div>
		</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3fb15e33b93bb6f921e4522dce2dbbf6&libraries=clusterer"></script>
	<script src="/jspweb/js/datago/datago.js" type="text/javascript"></script>
</body>
</html>