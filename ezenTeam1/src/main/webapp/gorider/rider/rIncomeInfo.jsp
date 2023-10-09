<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- css 호출 -->
	<link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
	<link href="/ezenTeam1/css/gorider/rider.css" rel="stylesheet">
<style>*{border:solid 1px red;}</style>

</head>
<body>

	<!-- 라이더 내정보 수정 -->
	<div class="wrapR">  <!-- 라이더 프로필 전체구역 -->
	     <%@include file="rheader.jsp" %>
	
		<div class="rheaderwrapA backimg" >  <!-- 뒤로가기 버튼구역-->
            <div class="rtopbtn">
                <a href="/ezenTeam1/gorider/rider/rMyMenu.jsp">
               <i class="fa-solid fa-arrow-right-from-bracket fa-rotate-180" style="color: #ffffff;"></i></a>

            </div>
            	<div class="rsubTitle"> 입금 내역 </div>
         </div>
         
	
	     <h5 class="ptitle"> </h5>
	        
	        <div class="listbox">
	
	         <!-- title -->
	            <ul class="listTitle rlistR">
	                
	           </ul>
	
	        <!-- 1 content start -->
	            <ul class="listContent rlistR">
	                 
	           </ul>
	           
	           
	        </div>   
	    
     </div>

	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- js호출 -->
	<script src="../../js/gorider/rider/rIncomeInfo.js"></script>

</body>
</html>


















