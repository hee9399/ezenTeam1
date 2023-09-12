console.log('1_AJAX통신 open');

function 예제1(){// f s
	console.log('예제1() open');
	   $.ajax({
     	url : "http://localhost:8080/jspweb/Test06",      
      	data : {'value1': '안녕하세요'},      
      	method : "get",   
      	success : function 함수(result){
			  console.log('서블릿 응답한 내용: '+result);
		  } ,       
      	error : function 함수(result){} ,         
   });

	
} //f end
function 예제2(){
	console.log('예제2출력')
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	// 2.객체화
	let info ={
		name : nameData,
		age : ageData
	}
	// 3.[1달=> 배열에 객체 저장]
	// 3.[3달 => 객체를 자바(서블릿)에게 전달]
	 $.ajax({
      url : "http://localhost:8080/jspweb/Test07",      
      data : info,      
      method : "get",   
      success : function 함수(result){
		  console.log('통신성공');
	  } ,       
      error : function 함수(result){} ,         
   });

}


/*
	
	$.ajax(); 매개변수에 객체{} 타입의 속성 대입
	
	$.ajax({
		url : ,																-- 통신할 HTTP 주소
		data {},															-- 보내는 데이터
		method : ,														-- post , get ,put , delete
		sucess :  function 함수(result),							-- 통신 성공했을때
		error : function 함수(result), 								-- 통신 실패했을때	
	});




*/
