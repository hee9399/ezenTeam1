console.log('js실행됩니다.')

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