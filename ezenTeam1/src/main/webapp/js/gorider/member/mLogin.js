console.log('js실행됩니다.');

//1. login
function onLogin(){
	console.log('onLogin')
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	$.ajax({
		url:"/ezenTeam1/MemberInfoController",
		method:"get",
		data:{type:login, mid:mid, mpwd:mpwd},
		success: r =>{

			console.log("성공" + r);
			location.href = '/ezenTeam1/gorider/member/mindex.jsp'
		},
		error : e =>{console.log("실패"+ e)}
	})
}
