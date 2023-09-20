<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
     <%@include file="../member/header.jsp" %>
     <!-- content구간 -->
     <div class="contentBox">
        
      	<button type = "button" class = "call">콜</button>
  		<button type = "button" class = "back">뒤로가기</button>
 

       
     
       
       
     </div>
     
     
    <%-- <%@include file="../member/footer.jsp" %>
     --%>

</div>
<!--  -->
<!-- 카카오지도 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=59b47c7057625f350189b1cb8369a874"></script>

 <!-- js -->
   <script src="/ezenTeam1/js/gorider/service/mcall.js" type="text/javascript"></script>
   
</body>
</html>