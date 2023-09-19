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

   <%@include file="header.jsp" %>
   <!-- Main imge -->
   <div class="mainimg"></div>
   <div class="searchbox" >
      <input type="text" class="destination" placeholder="어디로 갈까요?" />
      <button class="searchbtn" type="text">GO</button>

   </div>




   <!-- bottom -->
   <%@include file="footer.jsp" %>



</div>
<script src="/ezenTeam1/js/gorider/index.js"></script>
</body>
</html>