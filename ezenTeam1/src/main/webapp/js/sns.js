console.log('sns.jsp');


// 쓰기

// 출력

// 수정

// 삭제
function sdelete(){
	
	// 1. 탈퇴여부 확인 confirm() 확인/취소 버튼 알림창
	let dconfirm =confirm('정말 탈퇴하시겠습니까?');
	// 2. 확인 버튼을 눌렀을때
	if(dconfirm == true) {
		let mpwd = prompt('비밀번호 확인');
		console.log(mpwd);
	// 3. ajax [ 입력받은 패스워드 전송해서 로그인된 회원(서블릿세션)의 패스워드와 입력받은 패스워드가 일치하면 탈퇴]
	$.ajax({
		url : "/jspweb/MemberInfoController",
		method : "delete",
		data : { mpwd : mpwd},
		success : r => {
			if(r){alert('회원탈퇴 했습니다.'); logout();}
			else{alert('패스워드가 일치하지 않습니다.');}
			
		} , 
		error : e => {}
	});
	
	}
}