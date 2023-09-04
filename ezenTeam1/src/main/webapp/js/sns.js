let sno = new URL(location.href).searchParams.get("sno");
		console.log(sno);


// 쓰기
function swrite(){
	console.log('실행');
	let snsForm = document.querySelectorAll('.snsForm')[0];
	console.log( snsForm );
	// 2. form 데이터 객체화
	// 일반객체로 첨부파일 전송X -> FormData객체 이용시 첨부파일 전송 가능 
	// 2. form 객체화 하기
	let writeData = new FormData( snsForm ); // 첨부파일 [ 대용량 ] 시 필수..
	console.log( writeData );	
	
	// 3. ajax로 대용량  form 전송하기
	 $.ajax({
            url : "/ezenTeam1/SnsController",   
            method : "post",   
            data : writeData, 
            contentType : false,
            processData : false,     
           success : r =>{
             console.log(r);
             if(r){
				 alert('등록 성공');
				 location.href ="/sns/sns.jsp"
			 }else{
				 alert('등록 실패');
			 }
          } ,       
            error : e=>{} ,         
   }); 
}
// 출력
function onList(){
	console.log('리스트 로드');
	
	
	$.ajax({
		url : "/sns/SnsController",
		method : "get",
		data : { type : 1 },
		success : r => {
			console.log('success :: '+ r);
			console.log('success :: '+ r.sno);
			console.log('success :: '+ r.sdate);
			console.log('success :: '+ r.content);
			
			
			
			
			/* innerHTML */
			
			
			
		} , 
		error : e => { console.log('success :: '+ e);}
	});
	
}
// 수정
	// 1. 수정할 게시물의 기존 정보를 보여주는 메소드
getSns();
function getSns(){
	
	// 2. ajax에게 sno 전달 해서 게시물정보 가져온다. 
	 $.ajax({
      url : "/ezenTeam1/SnsController",      
      data : {type : 2 , sno : sno},      
      method : "get",   
      success :  r => {
		  console.log(r);
		  // 응답 결과 html 대입 
		  document.querySelector('.sno').value = `${r.sno}`
		  document.querySelector('.sfile').value = `${r.sfile}`
		  document.querySelector('.bcontent').value = `${r.bcontent}` 
		  
	  } ,       
      error :  e => {} ,         
   });
	
}//  f e

// 수정하기 
function onUpdate(){
	
	// 1. 입력된(수정된) from  정보 한번에 가져오기 
		// 1. form 가져오기 
	let form = document.querySelectorAll('.snsForm')[0]
	
	
	// 2. from 객체화 
	let formdata = new FormData(form);
	console.log(formdata);
	// 3. 응답 결과를 html 대입  
		// .set( 속성명 , 값 ); // form에 데이터 속성 추가 
	formdata.set( "bno" , bno );
	
	// 3. ajax 로 form 전송하기 
		           $.ajax({
               url : "/ezenTeam1/SnsController" , 
               method: "put" ,
               data : formdata ,
               contentType : false ,
               processData : false ,
               success : r => { console.log(r) 
               
               		if(r){ alert('수정성공'); 
               			location.href=`/ezenTeam1/sns/sns.jsp?sno=${ sno }`;
               		}else{alert('수정실패');}
               } ,
               error : e => { console.log(e) } ,
            })
	
}// f  e

// 삭제

function sdelete(sno){
   console.log('삭제버튼');
   
   
   // 1. 탈퇴여부 확인 confirm() 확인/취소 버튼 알림창
   let dconfirm =confirm('정말 탈퇴하시겠습니까?');
   // 2. 확인 버튼을 눌렀을때
   if(dconfirm == true) {
      
      let spwd = prompt('비밀번호 확인');
      console.log(spwd);
   $.ajax({
      url : "/sns/SnsController",
      method : "delete",
      data : { spwd : spwd},
      success : r => {
         if(r){alert('삭제 성공.');}
         else{alert('패스워드가 일치하지 않습니다.');}
         
      } , 
      error : e => {}
   });
   
   }
}

function sdelete(){
	console.log('삭제버튼');
	
	
	// 1. 탈퇴여부 확인 confirm() 확인/취소 버튼 알림창
	let dconfirm =confirm('정말 탈퇴하시겠습니까?');
	// 2. 확인 버튼을 눌렀을때
	if(dconfirm == true) {
		
		let spwd = prompt('비밀번호 확인');
		console.log(spwd);
	$.ajax({
		url : "/sns/SnsController",
		method : "delete",
		data : { sno : sno , spwd : spwd },
		success : r => {
			if(r){alert('삭제 성공.');
			location.href = "/sns/sns.jsp";
			}
			else{alert('패스워드가 일치하지 않습니다.');
			location.href = "/sns/snsList.jsp";
			}
			
		} , 
		error : e => {}
	});
	
	}
}

