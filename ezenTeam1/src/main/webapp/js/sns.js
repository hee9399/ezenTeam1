let sno = new URL(location.href).searchParams.get("sno");
		console.log(sno);


// 쓰기

// 출력

// 수정

// 삭제
function sdelete(sno){
	console.log('삭제버튼');
	
	
	// 1. 탈퇴여부 확인 confirm() 확인/취소 버튼 알림창
	let dconfirm =confirm('정말 탈퇴하시겠습니까?');
	// 2. 확인 버튼을 눌렀을때
	if(dconfirm == true) {
		let spwd = prompt('비밀번호 확인');
		console.log(spwd);
	$.ajax({
		url : "/sns/SnsController",
		method : "delete",
		data : { spwd : spwd},
		success : r => {
			if(r){alert('삭제 성공.');}
			else{alert('패스워드가 일치하지 않습니다.');}
			
		} , 
		error : e => {}
	});
	
	}
}