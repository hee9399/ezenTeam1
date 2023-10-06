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
<!--     <style type="text/css">*{border:solid 1px red;}</style> -->
    
</head>
<body>
<!-- 전체렙 -->

<div  class="wrap">

   <%@include file="header.jsp" %>
   
   <div class="contBox">
    <div class="bpageinfo">
    	<a href="javascript:history.back();">
    		<i onclick="" class="fa-solid fa-arrow-right-from-bracket fa-rotate-180"></i>
    	</a>
    	<span class="aptitle"> 공지사항 /이벤트 </span>  
    </div>
    
   	<div class="btypeBox">
   		<div onclick="onList('N')" class="btypeN">공지사항</div>
   		<div onclick="onList('E')" class="btypeE" >이벤트</div>
   	</div>
   	<div class="bContBox">
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		<div class="btitle">[공지]제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목 <span>2023-10-23</span></div>
   		
   	
   	</div>
   
   
   </div>




   <!-- bottom -->
   <%@include file="footer.jsp" %>



</div>
<script src="/ezenTeam1/js/gorider/member/mBoardList.js"></script>
</body>
</html>