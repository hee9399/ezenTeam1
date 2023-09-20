console.log('js실행됩니다.')

// 1. 라이더 로그인
function rlogin(){
	
	// html 입력받은값( 아이디 , 비밀번호 ) 가져오기 
	let rid = document.querySelector('.rid').value; console.log('rid가져옴'+rid);
	let rpwd = document.querySelector('.rpwd').value; console.log('rpwd가져옴'+rpwd);
	
	// 2. ajax에게 전달해서 회원이 존재하는지 반환 받는다
		// 2-1 : 로그인 성공시 
		   $.ajax({
		      url : "/ezenTeam1/RiderFindController",      
		      data : {rid : rid , rpwd : rpwd},      
		      method : "post",   
		      success : r => {
				  console.log(r);
				  
				  if(r){ location.href="/ezenTeam1/gorider/rider/rmain.jsp"; }
				  else{
					  
					  document.querySelector('.rlogincheckbox').innerHTML = '동일한 회원정보가 없습니다';
					  
				  }
			  } ,       
		      error : e => {} ,         
		   });
	
	
}// f  e

// 2. 라이더 아이디찾기 , 비밀번호찾기 버튼눌렀을때 화면출력 
function findInfo(type){
	
	// 1. html입력값 호출
		//  <div class="loginBox"> 가져옴  
	let loginBox = document.querySelector('.loginBox'); 
		console.log('loginbox가져옴'+loginBox);
		
		// <div class="findBox disFlexEnd">
	let findBox = document.querySelector('.findBox');
	 	console.log('findBox가져옴'+findBox);
	 	
	//
	let html = ``;
	let html2 = ``;
	
	// type
	if(type == 'id'){ // type에 'id'가 들어오면 
		// <div class="logo"> 아이디찾기 </div> 가져오기 
		document.querySelector('logo').innerHTML = '아이디 찾기'; 
		
		html += `<input class="rname" type="text" placeholder="이름을 입력하세요">
            <input class="rphone" type="text" placeholder="전화번호를 입력하세요">
            <button onclick="onFind('findId')" class="btn btypeW100H50" type="button"> 아이디찾기 </button>`;
			loginBox.innerHTML = html;
		
		html2 += `<div onclick="findid('login')">로그인하기</div>
	            <div onclick="findpw('pwd')">비밀번호 찾기</div>`;
	    	findBox.innerHTML = html2;  
		
	}else if()
	
	
}// f  e































