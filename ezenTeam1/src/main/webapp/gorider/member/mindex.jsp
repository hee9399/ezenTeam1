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
<!--         <style type="text/css">*{border:solid 1px red;}</style> -->

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
   <!-- 공지사항 -->
   <div class="mboardBox ">
    <div class="mbtitle"> 공지사항 <span><a href="mBoardList.jsp">더보기</a></span></div>
    <div class="mbContBox btN">
        <!-- 최근 등록된 공지 5개목록 -->
    </div>
   </div>

   <!-- 이벤트 -->
   <div class="mboardBox">
    <div class="mbtitle"> 이벤트 <span><a href="mBoardList.jsp">더보기</a></span></span> </div>
    <div class="mbContBox btE">
       <!-- 최근 이벤트 5개 -->
    </div>
   </div>




   <!-- bottom -->
   <%@include file="footer.jsp" %>



</div>
<script src="/ezenTeam1/js/gorider/index.js"></script>
</body>
</html>