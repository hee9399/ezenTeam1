/**
 *
 */
console.log('연결');
function onSave(){
	console.log( "onSave()");
	//폼객체가져오기
	let signupForm  = document.querySelectorAll('.signupForm')[0]
	//폼데이터 객체만들기
	let signupData = new FormData(signupForm);
	console.log(signupData);

	$.ajax({
		url:"/ezenTeam1/MemberInfoController",
		method:"post",
		data:signupData,
		contentType:false,
		processData:false,
		success: r =>{

			console.log("성공" + r);
			//location.href = '/ezenTeam1/gorider/member/mmain.jsp'
		},
		error : e =>{console.log("실패"+ e)}
	})


}