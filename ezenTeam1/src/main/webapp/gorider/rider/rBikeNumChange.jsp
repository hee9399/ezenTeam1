<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css 호출 -->
	<link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
	<link href="/ezenTeam1/css/gorider/rider.css" rel="stylesheet">

</head>
<body> <!-- 라이더 차량번호 , 계좌번호 수정페이지 -->

	<div class="wrapR"> <!-- 라이더 차량번호수정 전체 -->
	
		<div class="backimg" > <!-- 뒤로가기 버튼구역 -->
		
			 <a href="/ezenTeam1/gorider/rider/rMyMenu.jsp"> 
				<img class="rlogo" src="/ezenTeam1/gorider/rider/img/back.png"/> </a> 
			 <span class="rmTitle"> 차량번호 수정 </span> 
						 
		</div>
		
	<form class="rNumChange">
		
		<div class="rbikeChangeInfo"> <!-- 차량번호 수정구역 -->
		
			<input type="text" class="rBikeChange" name="rBikeChange"> 
			<button onclick="rBikeNumChange()" type="button"> 수정하기 </button>
			
		</div> <!-- 차량번호 수정구역 e -->
	
	
		<div class="rBankChange"> 
			<select class="inselect rbankinfo" name="rbankinfo">
	                    <option value=""> 은행선택 </option>
	                    <option value="KM"> 국민 </option>
	                    <option value="IB"> 기업 </option>
	                    <option value="NH"> 농협 </option>
	                    <option value="SH"> 신한 </option>
	                    <option value="WR"> 우리 </option>
	                    <option value="KE"> 외환 </option>
	                    <option value="KA"> 카카오 </option>
	                    <option value="TS"> 토스 </option>
	                    <option value="HN"> 하나 </option>
	        </select>
	           <input class="raccountinfo intext75" name="raccountinfo" type="number">
		</div>
	</form>
	
	</div> <!-- 라이더 차량번호수정 전체 e -->


	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script src="../../js/gorider/rider/rBikeNumChange.js"></script>

</body>
</html>