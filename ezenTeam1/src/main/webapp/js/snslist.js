/**
 * 
 */
// 출력
onList();
function onList(){
	console.log('리스트 로드');
	
	
	$.ajax({
		url : "/ezenTeam1/SnsController",
		method : "get",
		data : { type : 1 },
		success : r => {
			let html ='';
			let cWrap = document.querySelector('.cWrap')
			
				
			r.forEach( s => {
				console.log("s" + s)
				html+= `
					<div class="contBox">
						<div class="sphoto"><img src="/ezenTeam1/sns/upload/${s.sfile}"></div>
						<div class="sdate">${s.sdate}</div>
						<div class="scontent">
						${s.scontent}
						</div>
						<div class="btnbox">
							<button class="btn" onclick ="checkPwd(${s.sno},'U')" type="button">수정</button>
							<button class="btn" onclick ="checkPwd(${s.sno},'D')" type="button">삭제</button>
			
						</div>	
					</div>
				
				`;
				
			});
			
			
			cWrap.innerHTML = html;
			
			
			
		} , 
		error : e => { console.log('error :: '+ e);}
	});
	
}
// 글쓰기 화면으로 이동
function onWrite(){
	location.href='/ezenTeam1/sns/snsWrite.jsp';
}


//비번체크
function checkPwd(sno, target){
	let spwd = prompt('비밀번호를 입력하세요');
	
	$.ajax({
		url : "/ezenTeam1/SnsController",
		method : "get",
		data : { type : 3 , sno : sno, spwd : spwd},
		success : r => {
			console.log('비번체크success :: '+ r)
			
			if(r) {
				
				if(target == 'U'){
					location.href = `/ezenTeam1/sns/snsUpdate.jsp?sno=${sno}`
				
				}  else if( target == 'D'){
					
					// 삭제 함수 호출
					sdelete(sno);
				}
			} else {
					alert('비밀번호가 일치하지 않습니다.')
			}
			
			
		} , 
		error : e => { console.log('error :: '+ e);}
	});
}