/**
 * 
 */

// 쓰기
function swrite(){
	console.log('실행');
	let snsForm = document.querySelectorAll('.snsForm')[0];
	console.log( snsForm );
	// 2. form 데이터 객체화
	// 일반객체로 첨부파일 전송X -> FormData객체 이용시 첨부파일 전송 가능 
	// 2. form 객체화 하기
	let writeData = new FormData( snsForm ); // 첨부파일 [ 대용량 ] 시 필수..
		
	console.log( "writeData ::: "+ writeData );	
	// 3. ajax로 대용량  form 전송하기
	 $.ajax({
            url : "/ezenTeam1/SnsController",   
            method : "post",   
            data : writeData, 
            contentType : false,
            processData : false,     
            success : r => {
            	console.log(r);
            	if(r){
					 alert('등록 성공');
				 	location.href ="/sns/sns.jsp"
			 	}else{
				 	alert('등록 실패');
			 	}
           	} ,       
            error : e =>{} ,         
   }); 
}