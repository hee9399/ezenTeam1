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
function onPhotomModal(){
	document.querySelector('.modalwrap').style.display = 'flex';
}

// 2. 첨부파일 저장하기
function onChangePhoto(){
	alert('사진을 저장합니다.!')
	if(document.querySelector('.mphoto').value == ''){
		alert('선택된 파일이 없습니다.')
		return;
	}else {

		let myform = document.querySelectorAll('.myform')[0];
		let myformData = new FormData(myform);
		console.log(myformData);
		//myformData.append('type','PFile');
		//console.log(myformData.toString());

		$.ajax({
			url:"/ezenTeam1/MemberInfoController",
			method:"put",
			data : myformData ,
			contentType:false,
			processData:false,
			success : r =>{

			},
			error : e =>{ console.log(e ) }

		});



	}
}



//3. 취소버튼 클릭시 화면 가리기
function onModalClose(){
	alert('취소')
	document.querySelector('.modalwrap').style.display = 'none';

}
function preview(obj){
	alert('사진미리보기')

	//2. JS파일클래스 선언
	let file = new FileReader(); //파일 읽기
	file.readAsDataURL(obj.files[0]);
	console.log(obj.files[0]);
	//읽어온 파일 해당 html에 img태그에  load
	file.onload = e=>{
		console.log('e  : >>> '+ e);
		console.log('e.target  : >>> '+ e.target);
		console.log(".target.result >>>" + e.target.result);
		document.querySelector('.preview').src = e.target.result;
	}
}