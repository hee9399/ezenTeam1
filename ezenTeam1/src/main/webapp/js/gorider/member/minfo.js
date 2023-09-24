/**
 *
 */
if(loginState== false){
	location.href='/ezenTeam1/gorider/member/mlogin.jsp'
} else {
	document.querySelector('.mi_mname').innerHTML = loginMname;
	document.querySelector('.mi_memail').innerHTML = loginMeamil;
}

// 1. 첨부파일변경