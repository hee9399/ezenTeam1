
/*썸머노트 실행*/
$(document).ready(function() {
	
	let option = {
		lang : 'ko-KR' ,
		height : 500,
		placeholder : '여기에 내용작성'
	}
  $('#summernote').summernote(option);
});

function bwrite(){
	console.log('실행');
	// 1. form  가져오기
		// querySelectorAll : 배열타입으로
	let writeForm = document.querySelectorAll('.writeForm')[0];
	console.log( writeForm );
	// 2. form 데이터 객체화
	// 일반객체로 첨부파일 전송X -> FormData객체 이용시 첨부파일 전송 가능 
	// 2. form 객체화 하기
	let writeData = new FormData( writeForm ); // 첨부파일 [ 대용량 ] 시 필수..
	console.log( writeData );	
	
	// 3. ajax로 대용량  form 전송하기
	 $.ajax({
            url : "/jspweb/BoardinfoController",   
            method : "post",   
            data : writeData, 
            contentType : false,
            processData : false,     
           success : r =>{
             console.log(r);
             if(r){
				 alert('글등록 성공');
				 location.href ="/jspweb/board/list.jsp"
			 }else{
				 alert('글등록 실패');
			 }
          } ,       
            error : e=>{} ,         
   }); 
}

