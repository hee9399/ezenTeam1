console.log('1_통신.js')

// 예제1
function 예제1(){
	console.log('예제1() 실행')
	



	/*
		Ajax : JQUERY 라이브러리 에서 통신HTTP 함수 제공
			JQUERY : js 언어로 여러개 함수를 제공하는 라이브러리
			1. 정의 : js언어에서 외부와 통신(데이터주고받기)하는 목적
			2. 형태 : $.ajax();
			3. 필수 : JQUERY 라이브러리 필수 !!! <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			4. 매개변수 : 객체{속성 : 값  속성 : 값 , 속성 : 값}
				1. url통신할 대상/링크/주소
				2. HTTP통신메소드 : post , get ,put , delete 등등
				3. success결과속성 : 통신을 성공했을때 변환된 데이터를 함수의 매개변수 반환 받음
	
	*/
	$.ajax({
		url : "https://jsonplaceholder.typicode.com/posts" ,		// 1. 통신할 경로
		method : "get",														// 2. 통신할 http 메소드 방식
		success : function 결과(result){console.log(result);}			// 3. 통신을 성고했을때 반환된 데이터
		});
}

function 예제2(){
	console.log("예제2()실행")
	$.ajax( { 
      url : "/jspweb/Test01"  ,    // 1. 통신할 경로
      method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      success : function 결과( result ){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
   });
}