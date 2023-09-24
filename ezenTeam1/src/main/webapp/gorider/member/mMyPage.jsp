<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Go Rider!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
    <link href="/ezenTeam1/css/gorider/member.css" rel="stylesheet">
<style type="text/css">*{border:solid 1px red;}</style>
</head>
<body>
<!-- 전체렙 -->
 <%@include file="mBHeader.jsp" %>
 <div  class="wrap">


   	<div class="myInfoBox"> <!-- 클릭시 수정페이지로. -->
		<div class="col30">
	   		<img src="/ezenTeam1/gorider/member/file/default.png"/>

	   		<div><i class="fa-regular fa-pen-to-square"></i></div>
	   	</div>
	   	<div class="minfo">
			<div class="mi_mname"> </div>
		   	<div class="mi_memail"> </div>
	   	</div>


	</div>

   	<div class="myMenuBox">
   		<div class="disFlexStCent ">
   			<div>img</div>
   			<div>공지/이벤트</div>
   		</div>

   		<div class="disFlexStCent">
   			<div>img</div>
   			<div>이용기록</div>
   		</div>
   		<div class="disFlexStCent">
   			<div>img</div>
   			<div>결제수단관리변경</div>
   		</div>


   	</div>



   <!-- bottom -->
   <%@include file="footer.jsp" %>



</div>

<script src="/ezenTeam1/js/gorider/member/header.js"></script>
<script src="/ezenTeam1/js/gorider/member/minfo.js"></script>
</body>
</html>