console.log('js실행됩니다.');

// 라이더 회원가입 js


// 1. 아이디 유효성 검사
function idcheck(){
	console.log('idcheck 함수실행됩니다');

	// 1. 값 호출 
	let rid = document.querySelector('.rid').value;  console.log('rid 입력값가져옴'+rid)
	let idcheckbox = document.querySelector('idcheckbox'); console.log('idcheckbox 입력값가져옴'+idcheckbox)
	
	// 2. 유호성 검사
	
	// 1. 아이디입력할때 영문[소문자]+슷지 조합의 5~20글자 사이 이면 
		// 1. 정규표현식 작성
	let midj = /^[a-z0-9]{5,20}$/
		// 2. 정규표현식 검사.
	console.log(midj.test(rid) )
	if(midj.test(rid) ){ // 만약에 입력한 값이 패턴과 일치하면 
		
		
		// -- 입력한 아이디가 패턴과 일치하면 중복검사 
			   $.ajax({
     			 url : "/ezenTeam1/RiderFindController",      
      			 data : { type : "rid" , data : rid },      
      			 method : "get",   
      			 success : r => {
			 	 console.log(r);
				 // true - 사용가능한
				 if(r == true){idcheckbox.innerHTML = '사용불가능한 아이디입니다';}
				 else{idcheckbox.innerHTML = '사용가능한 아이디 입니다.';}
				   } ,       
      			 error : e => {} ,         
   });
	}else{ // 입력한값이 일치하지 않으면 
		idcheckbox.innerHTML = '영문(소문자)+숫자 조합의 5~20글자 가능합니다.';
	}
	
}// f e
