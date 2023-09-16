/**
 *
 */
let checkList = [false, false, false]//아이디/비밀번호/이메일체크결과
console.log('연결');
//회원가입 정보 저장
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

function dupleIdCheck(){
	let mid = document.querySelector('.mid').value;
	let idComment = document.querySelector('.idComment')

	//영문+ 숫자조합 8자이상20자 미만으로 정규표현식
	let midC = /^[a-zA-Z0-9]{8,20}$/
	//정규표현식에 적합하면
	if(midC.test(mid)){
		//사용가능 메시지 전달
		idComment.innerHTML ='사용가능한 아이디입니다.'
		//아이디 중복체크
		$.ajax({
			url:"/ezenTeam1/MemberInfoController",
			method:"get",
			data:{type:'isExist', mid:mid,search:'mid'},
			success: r => {
				console.log(r)
				if(r == 'true'){
					idComment.innerHTML ='이미 사용중인 아이디입니다.'
					checkList[0] = false;
				} else{
					idComment.innerHTML ='사용가능한 아이디입니다.'
					checkList[0] = true;
				}
			},
			error : e => {console.log(e)}
		})
	} else { // 정규표현식에 적합하지 않으면
		//부적함 메시지를 전달
		idComment.innerHTML ='아이디는 영문+숫자조합 8~20자미만으로 작성해주세요'
		checkList[0] = false;
	}

	console.log(mid);
}

//비밀번호 유효성 검사
function pwdCheck(){
	let mpwd = document.querySelector('.mpwd').value;
	let mpwd2 = document.querySelector('.mpwd2').value;
	let pwdComment = document.querySelector('.pwdComment') ;
	let pwd2Comment = document.querySelector('.pwd2Comment') ;
	console.log(mpwd);
	//영문+ 숫자조합 8자이상20자 미만으로 정규표현식
	let pwdC = /^[a-zA-Z0-9!@#$%^&*]{8,20}$/
	if(pwdC.test(mpwd)){
		pwdComment.innerHTML = '사용가능한 비밀번호입니다.';
		if(pwdC.test(mpwd2)){
			if(mpwd == mpwd2){
				pwd2Comment.innerHTML = '사용가능한 비밀번호입니다.'
				checkList[1] = true;
			} else {
				pwd2Comment.innerHTML = '비밀번호가 일치하지 않습니다.'
				checkList[1] = false;
			}
		} else {
			pwd2Comment.innerHTML = '비밀번호는 영문+숫자조합 8~20자미만으로 작성해주세요'
			checkList[1] = false;
		}

	} else{
		pwdComment.innerHTML = '비밀번호는 영문+숫자조합 8~20자미만으로 작성해주세요'
		checkList[1] = false;
	}
	console.log(checkList)
}
let authBtn = document.querySelector('.authBtn');
//authBtn.disabled = true; //인증버튼의 기본값을 사용불가 상태로 세팅disabled = true;
if(authBtn.disabled==true){ //사용불가 상태일때 스타일 적용
	authBtn.style.backgroundColor='#666'
	authBtn.style.cursor = 'none';
}
function emailcheck(){

	let memail = document.querySelector('.memail').value;
	let emailComment = document.querySelector('.emailComment');


	let memailC = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/ //이메일 정규표현식
		//- 이메일 주소의 로컬 파트, @ 기호, 도메인 파트(1차 및 최상위 도메인)의 형식

	if(memailC.test(memail)){ //정규표현식에 맞으면
		//emailComment.innerHTML ='사용가능한 이메일입니다.'
		//이메일 중복체크
		$.ajax({
			url:"/ezenTeam1/MemberInfoController",
			method:"get",
			data:{type:'isExist', key:memail,search:'memail'},
			success: r => {
				console.log(r)
				if(r == 'true'){
					emailComment.innerHTML ='이미 사용중인 이메일입니다.'
					authBtn.disabled = true;
					checkList[2] = false;
				} else{
					emailComment.innerHTML ='사용가능한 이메일입니다.'

					checkList[2] = false; //인증번호까지 일치해야 하므로 false
					authBtn.disabled = false;
					// /사용가능 상태일때 스타일 변경
					authBtn.style.backgroundColor='var(--main02)'
					authBtn.style.cursor = 'pointer';
				}
			},
			error : e => {console.log(e)}
		})
	} else{ //정규표현식에 맞지 않으면
		emailComment.innerHTML ='이메일형식에 맞게 입력해주세요'
		authBtn.disabled = true;
		checkList[2] = false;
	}
}

/*4~  6번 함수에서 공통으로 사용할 변수선언*/
let authcode='';	//인증코드
let timer=0;		//인증시간
let timerInter;		//setInterval  함수를 가지고있는 변수 [ setInterval종료시 필요]

//인증번호받기버튼이 눌렸을때
function authReq(){
	let authbox = document.querySelector('.authbox');

	let html =` <li class="title"> 이메일 인증번호  <span class="timebox">02:00</span></li>
		         <li class="input75">
		         	<input  name="memailcheck" class="memailcheck" type="text"/>
		         	<button onclick="auth()" class="" type="button">인증하기</button>
		         </li>`
}