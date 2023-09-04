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

// 수정

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
