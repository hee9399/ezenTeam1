function login(){
	console.log('login() 실행');
	// 1. 입력받은 아이디 , 비밀번호 가젼온다,
	let mid = document.querySelector('.mid').value
	let mpwd = document.querySelector('.mpwd').value
	
	// 2. ajax 에게 전달해서 회원이 존재하는지 반환  받는다.
		// 2-1 : 로그인성공시 index.jsp 이동
			//			: 로그인 실패시 : logincheckbox'시ㅏㄹ패알림
	
	$.ajax({
		url : "/jspweb/MemberFindController",
		method :"post", 
		// get메소드는 전송하는 data노출(보안취약) post메소드는 data노출x(보안)
		data : {mid : mid , mpwd : mpwd},
		success : r =>{
			
			if(r){
				alert('로그인성공');
				location.href="/jspweb/index.jsp";
			}else{
				document.querySelector('.Logincheckbox')
				.innerHTML ='동일한 회원정보가 없습니다.';
			}
			
		},
		error : e =>{console.log(e);},
	})
};

/*

	GET VS POST
	
	GET	:
		-캐시(기록O)
		-추후에 다시 전송시 속도 빠름
		-보안 불가능
		-매개변수 노출
		-
	POST :
		-캐시(기록X)
		-추후에 다시 전송시 속도 동일
		- 보안가능
		- 매개변수 노출X
		- 로그인 , 회원가입(권장)


*/