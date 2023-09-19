console.log('js실행됩니다.');

//1. login
function onLogin(){
	console.log('onLogin')
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	$.ajax({
		url:"/ezenTeam1/MemberFindController",
		method:"post",
		data:{mid:mid, mpwd:mpwd},
		success: r =>{

			//console.log("성공" + r);
			if(r){
				//alert(mid+'로그인 성공');
				location.href = '/ezenTeam1/gorider/member/mindex.jsp'
			} else {
				alert('회원정보가 일치하지 않습니다');
				//초기화 해주기
				mid='';
				mpwd='';
			}
		},
		error : e =>{console.log("실패"+ e)}
	})
}


//2 .아이디 비밀번호 화면출력
function findInfo(type){
	
	if (type =='id'){
		document.querySelector('.logo').innerHTML = '아이디 찾기' 
		let loginBox = document.querySelector('.loginBox');
		let html =``;
		html += `<input class="mname1" type="text" placeholder="이름을 입력하세요">
            <input class="memail" type="text" placeholder="이메일주소를 입력하세요">
            <button onclick="onFindA('id')" class="btn btypeW100H50" type="button">아이디 찾기</button>`
		
		
		loginBox.innerHTML = html;
	} else if(type =='pwd'){
		document.querySelector('.logo').innerHTML = '비밀번호 찾기' 
		let loginBox = document.querySelector('.loginBox');
		let html =``;
		html += `<input class="mid" type="text" placeholder="아이디를 입력하세요">
            <input class="memail" type="text" placeholder="이메일주소를 입력하세요">
            <button onclick="onFindA('pwd')" class="btn btypeW100H50" type="button">비밀번호 찾기</button>`
		
		
		loginBox.innerHTML = html;
	}
}
