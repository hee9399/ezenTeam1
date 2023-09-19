/**
 *
 */
let loginState = false; //로그인상태 기본값 false로 세팅
let loginMid = ''; // 전역변수로 선언
getMemberInfo();
// 1. 세션에 있는 로그인정보 유무에 따라  화면수정
function getMemberInfo(){
	$.ajax({
		url:"/ezenTeam1/MemberInfoController",
		method:"get",
		async:false, //동기화설정(waiting)
		data:{type:'login'},
		success: r =>{
			let btnBox = document.querySelector('.hbtnbox');
			let html =``;

			//console.log("성공" + r);
			if(r == null){ //세션정보가 없으면 회원가입/ 로그인 버튼 활성화
				loginState = false;
				loginMid = '';
				html +=`<div onclick="onSignUp()"  class="btn r1">가입 </div>
				        <div onclick="onLogin()"  class="btn r1"> 로그인 </div> `
			
			} else {//세션정보가 있으면 회원명 프로필사진 출력
				loginState = true;
				loginMid = r.mid;
				let mphoto = r.mphoto == null? 'default.png': r.mphoto;
				html += ` <div class="minfo">
							<span class="mname">${r.mname}</span>
							<span class="sayhello"> 반갑습니다.</span> 
						    <img src="/ezenTeam1/gorider/member/file/${mphoto}"/>
						   </div>`

			}
			btnBox.innerHTML = html;
			console.log("loginState :: "+loginState);
			console.log("loginMid :: "+loginMid);
			console.log("loginMname :: "+r.mname);
		},
		error : e =>{console.log("실패"+ e)}
	})
}

function logout(){
	$.ajax({
		url:"/ezenTeam1/MemberFindController",
		method:"post",
		data:{type:"logout"},
		success: r =>{

			//console.log("성공" + r);
			if(r){
				alert('로그아웃 되었습니다.');
				location.href = '/ezenTeam1/gorider/member/mindex.jsp'
			}
		},
		error : e =>{console.log("실패 :: "+ e)}
	})
}