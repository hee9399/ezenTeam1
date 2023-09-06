


// 1.출력
onList();
function onList(keyword){
	console.log('리스트 로드');
	
	
	$.ajax({
		url : "/ezenTeam1/SnsController",
		method : "get",
		data : { type : 1 , keyword : keyword },
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
						<button class="btn" onclick ="replyBtn()"  type="button">답글</button>
						
						</div>	
						
						<div class="replyWrap"><!-- 댓글 출력구간 -->
							<div class="reBox">
								<span class="rContent">댓글내용</span>
								<button onclick ="RcheckPwd(5)" type="button">X</button>
							</div>
							<div class="reBox">
								<span class="rContent">댓글내용</span>
								<button onclick ="RcheckPwd(5)" type="button">X</button>
							</div>
							<div class="reBox">
								<span class="rContent">댓글내용</span>
								<button onclick ="RcheckPwd(5)" type="button">X</button>
							</div>
							
						</div>
					</div>
		
				
				`;
				
			});
			
			
			cWrap.innerHTML = html;
			// keyword 로 검색을 받아올 갯수 
			rCount(keyword);
			
			
		} , 
		error : e => { console.log('error :: '+ e);}
	});
	
}
// 2. 글쓰기 화면으로 이동
function onWrite(){
	location.href='/ezenTeam1/sns/snsWrite.jsp';
}

// 
function rCount(keyword){
	
	  $.ajax({
      url : "/ezenTeam1/SnsController",      
      data : { type : 4 , keyword : keyword },      
      method : "get",   
      success : r => {
		  console.log(r)
		  // 피드 수 출력 
		  document.querySelector('.rcount').innerHTML = r;
		  
		  
	  } ,       
      error : e => {} ,         
   });
	
}// f e

// 3. 검색 버튼을 클릭했을때.
function onSearch(){
	console.log('onSearch() open');
	// 입력받은 keyword 값을 
	let keyword = document.querySelector('.keyword').value;
	// onList 에 keyword를 보낸다
	onList(keyword);
	// 전체 list rcount를 받아야한다 
	let rcount = document.querySelector('.rcount');
	// 데이터 갯수를 가져와야한다.
	
	
}//f  e


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

// 댓글 삭제시 비번 체크
function  RcheckPwd(rno){ 
	
	let rpwd = prompt('비밀번호 입력해주세요');
	console.log("rpwd  :: " + rpwd);
	console.log("rno  :: " + rno);
	$.ajax({
		url : "/ezenTeam1/SnsReplyController",
		method : "delete",
		data : { rno : rno , rpwd : rpwd},
		success : r => {
			console.log('비번체크success :: '+ r)
			
			if(r) {
				alert('삭제되었습니다..')
			} else {
				alert('비밀번호가 일치하지 않습니다.')
			}
			
			
		} , 
		error : e => { console.log('error :: '+ e);}
	});
}

function replyBtn(){
	let rcontent= prompt('내용(최대30글자)').slice(0, 30);
	let rpwd = prompt('비밀번호(8글자이상)').slice(0, 8);
	 
	$.ajax({
            url : "/ezenTeam1/SnsReplyController", 
            method : "post",   
            data : {rcontent : rcontent, rpwd : rpwd},      
           success : r =>{console.log(r);
             if(r){
				 alert('답글 달기 성공');
			 }else{
				 alert('답글 달기 실패');
			 }
          } ,       
            error : e=>{} ,         
   });
 }




