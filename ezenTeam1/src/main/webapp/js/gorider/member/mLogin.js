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

			console.log("성공" + r);
			alert(mid+'로그인 성공');
			location.href = '/ezenTeam1/gorider/member/mindex.jsp'
		},
		error : e =>{console.log("실패"+ e)}
	})
}
