<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

    <link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
        <link href="/ezenTeam1/css/gorider/rider.css" rel="stylesheet">
<!-- <style>*{border:solid 1px red;}</style> -->
</head>
<body>
	<div class="wrapR ">
<%--      <%@include file="rheader.jsp" %> --%>
        <div class="rheaderwrapA ">

            <div class="rmTitle">나의 메뉴</div>

        </div>

        <div class="hbutton">상단고정버튼</div>

        <div class="rcontBox">
	        <div class="rmyBtnBox">
	            <div class="rmyBtn"> 내정보수정 </div>
	            <div class="rmyBtn"> 차량번호수정 </div>
	            <div class="rmyBtn"> 주행기록 </div>
	            <div class="rmyBtn"> 입금내역 </div>

            </div>

        </div>
	 <div class="footerR" >
       <div onclick="onMove('callList')" class="fbtn btn50 bgm02">콜리스트</div>
       <div onclick="onMove('goBack')" class="fbtn btn50 bgm02">돌아가기</div>
   </div>
    </div>
    <script src="../../js/gorider/rider/rAfterWork.js"></script>
</body>
</html>