<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Go Rider!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
    <link href="/ezenTeam1/css/gorider/index.css" rel="stylesheet">
</head>
<body>
<!-- 전체렙 -->
<div  class="wrap">
 <!--  
   <div class="headerwrap">
      <div class="logo">GoRider</div>
     <div class="btnbox">
        <div onclick="onSignUp()"  class="btn r2">회원<br>가입</div>
        <div onclick="onLogin()"  class="btn r1">로그인</div>
      </div>
   </div>
 -->
   <%@include file="header.jsp" %>  
   <!-- Main imge -->
   <div class="mainimg"></div>
   <div class="searchbox" >
      <input type="text" class="destination" placeholder="어디로 갈까요?" />
      <button class="searchbtn" type="text">GO</button>

   </div>




   <!-- bottom -->
   <div class="footer" >
    푸터

   </div>




</div>
<script src="../js/gorider/index.js"></script>
</body>
</html>