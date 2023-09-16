<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link href="/ezenTeam1/css/gorider/common.css" rel="stylesheet">
   <link href="/ezenTeam1/css/gorider/rider.css" rel="stylesheet">
</head>
<body>
<div class="wrap">
    <div class="header">


        <h2> 라이더 지원하기</h2>
        <p> 환영합니다.</p>

    </div>
    <div class="rSignupBox">
    <form class="riderSignup">
        <ul>
            <li class="title" > 이름 </li>
            <li class="input">
            	<input class="rname" name="rname" type="text">
            	 <span class="namecheckbox"> </span> 
            </li>

            <li class="title" >아이디</li> 
            <li class="dflex">
            	<!-- onkeyup="idcheck()" -->
                <input onkeyup="" class="rid intext80" name="rid" type="text">
                <span class="idcheckbox"> </span> 
                <button  class="idcheck" type="button">중복체크</button></li>

            <li class="title" >비밀번호 <span class="pwdcheck">  </span> </li>
            <li class=""><input maxlength="30" class="rpwd" name="rpwd" type="password"></li>

            <li class="title" >비밀번호 확인</li>
            <li class=""><input maxlength="30" class="rpwd2" name="rpwd2" type="password"></li>

            <li class="title" >프로필사진</li>
            <li class=""><input onchange="" class="rphoto infile" name="rphoto" type="file">
            	<img class="preimg" src="" />
            </li>

            <li class="title" >면허증</li>
            <li class=""><input onchange="" class="rlicense infile" name="rlicense" type="file"></li>

             <li class="title" >차량등록증</li>
            <li class=""><input onchange="" class="rregistration " name="rregistration" type="file"></li>

            <li class="title" >계좌번호</li>
            <li class="dflex">
                <select class="inselect rbank" name="rbank">
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
                <input class="raccount intext75" name="raccount" type="number">
            </li>
        </ul>
        <div class="btnbox">
            <button  class="btn50 colorW" onclick="" type="reset"> 다시쓰기</button>
            <button  class="btn50" onclick="signup()" type="button"> 지원서제출</button>
        </div>    </form>
    </div><!-- 라이더 회원가입 전체구역 e -->

</div><!-- 전체구역 e -->
   <!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

   <!-- js -->
   <script src="/ezenTeam1/js/gorider/rider/riderSignup.js" type="text/javascript"></script>
</body>
</html>