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
	 	
	// html 2개 출력 
	let html = ``;
	let html2 = ``;
	
	// type
	if(type == 'id'){ // type에 'id'가 들어오면 
	
		// <div class="logo"> 아이디찾기 </div> 가져오기 
		document.querySelector('logo').innerHTML = '아이디 찾기'; 
		
		// html 입력 , 버튼 출력 
		html += `<input class="rname" type="text" placeholder="이름을 입력하세요">
            <input class="rphone" type="text" placeholder="전화번호를 입력하세요">
            <button onclick="onFind('findId')" class="btn btypeW100H50" type="button"> 아이디찾기 </button>`;
			loginBox.innerHTML = html;
		
		// html 페이지전환 클릭 출력  
			// <div onclick="findid('login')">로그인하기</div> - 눌렸을때 로그인페이지전환 
			// <div onclick="findpw('pwd')">비밀번호 찾기</div> - 눌렀을때 비밀번호찾기페이지 전환 
		html2 += `<div onclick="findid('login')">로그인하기</div>
	            <div onclick="findpw('pwd')">비밀번호 찾기</div>`;
	    	findBox.innerHTML = html2;  
		
	}else if(type == 'pwd'){ // type에 'pwd'가 들어오면 
		
		//  <div class="logo"> 비밀번호찾기 </div> 로고 가져와서 출력 
		document.querySelector('logo').innerHTML = '비밀번호 찾기'; 
		
		// html 입력 , 버튼 출력 
		html += `<input class="rname" type="text" placeholder="이름을 입력하세요">
            <input class="rid" type="text" placeholder="아이디를 입력하세요">
            <button onclick="onFind('findPwd')" class="btn btypeW100H50" type="button"> 비밀번호찾기 </button>`;
		loginBox.innerHTML = html;
		
		// html 페이지전환 클릭 출력 
		html2 += `<div onclick="findid('id')">아이디찾기</div>
	            <div onclick="findpw('pwd')">비밀번호 찾기</div>`;	
	    	findBox.innerHTML = html2;
	}else if( type == 'login' ){
		location.href = '/ezenTeam1/gorider/rider/rlogin.jsp';
	}
	
	
}// f  e

// 2. 아이디 , 비밀번호 찾기
function onFind(type){
	 
	if(type == 'findId'){ // type에 아이디찾기 가 들어오면 
		
		// 1. 아이디 찾기 
		let rname = document.querySelector('.rname');	
			console.log('rname가져옴'+rname);
		let rphone = document.querySelector('.rphone');
			console.log('rphone가져옴'+rphone);
	
			   $.ajax({
			      url : "/ezenTeam1/RiderFindController",      
			      data : {type:type , rname:rname.value , rphone:rphone.value },      
			      method : "get",   
			      success : r => { console.log(r) 
			      	alert('')
			      } ,       
			      error : e => {} ,         
			   });
					
	}
	
}//f e




























