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
		data:{type:login},
		success: r =>{

			//console.log("성공" + r);
			if(r == null){
				loginState = false;
				loginMid = '';
			} else {
				loginState = true;
				loginMid = r.mid;
			}
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