
// * ajax(기본값 비동기통신) 가 응답의 결과를 가지고 오기전에 아래코드 실행. [loginState 변경되기전에 실행되므로 문제발생]
// - 해결방안 ajax 동기화 통신 하자..
// 1. 비 로그인시 입장 불가능...
if(loginState == false){alert('회원전용 페이지입니다.'); location.href="/jspweb/Member/login.jsp"}
console.log('채팅방에 입장한 아이디: '+ loginMid);
// 2. js 클라이언트[유저] 소켓 만들기
let clientSocket = new WebSocket(`ws://192.168.17.136:80/jspweb/seversokcet/${loginMid}`);
	// - 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속 ----> 서버소켓의 @onOpen
	// - 서버소켓URL 매개변수 전달하기 [- 주로 식별자 전달] 서버소켓URL/데이터1/데이터2/데이터3
	// ---- 메소드
	// 1. 클라이언트소켓이 정상적으로 서버소켓 접속했을때
	clientSocket.onopen=e=> {
		
		
		// 1-2 : 만약에 접소을 성공하면 알림메세지 전송
		let msg = {
			type : "alarm", content : `${loginMid}님이 입장했다.`}
			clientSocket.send(JSON.stringify(msg) ); 
			// 문제발생 : 해당 메세지를 받는 JAVA는 JSON타입 몰라요,... 그래서 문자열 타입으로 전송.
		
		
		};
		// 2. 클라이언트소켓이 서버소켓과 연결해서 오류가 발생했을때
	clientSocket.onerror=e=> {console.log('서버와 오류 발생'+e); };
	// 3. 클라이언트소켓이 서버소켓과 연결이 끊겼을떼
	clientSocket.onclose=e=> {console.log('서버와 연결 끊김'+e); };
	// 4. 클라이언트소켓이 메세지를 받았을때
	clientSocket.onmessage= e=> onMsg(e);
// 3. 서버에게 메세지 전송

function onSend(){
	// 3-1 textarea 입력값 호출
	let msaValue = document.querySelector('.msg').value;
	if(msaValue==' ' ||msaValue=='\n'){
		document.querySelector('.msg').value =``;
		alert('내용을 입력해주세요.'); return;}
	// 3-2 메세지 전송..
	
	let msg ={type : 'message' , content : msaValue}
	clientSocket.send(JSON.stringify(msg)); 
	// 클라이언트소켓과 연결된 서버소켓에게 메세지 전송 ---> 서버소켓의 @OnMessage 으로 이동
	// 3-3 메세지 전송시 입력상자 초기화
	document.querySelector('.msg').value =``;
}
// 4. 메세지를 받았을때 추후 행동(메소드) 선언
function onMsg(e){
	console.log(e);
	console.log(e.data);
	
	let msgBox = JSON.parse(e.data);
	msgBox.msg = JSON.parse(msgBox.msg);
	
	msgBox.msg.content = msgBox.msg.content.replace( /\n/g , '<br>' );
	
	
	// 1. 어디에 출력활껀지
	let chatcont = document.querySelector('.chatcont');
	
	// 2. 무엇을
	// 만약에
	let html =``;
	//만약에 메세지타입이 알람 이면
	if(msgBox.msg.type=='alarm'){
		html = `${typeHTML(msgBox.msg)}`;
	}
	// 만약에 메세지 타입이 알람이 아니면 [메세지, 이모티콘]
		// 2-2 만약에 내가 보냈으면.
		else if(msgBox.frommid==loginMid){
			 html=`<div class="rcont"> 
						<div class="subcont">
							<div class="date">${msgBox.date}</div>
							${typeHTML(msgBox.msg) }	
				</div>
			</div>`;
		}else{ // 2-2 만약에 내가 보낸 내용이 아니면.
			 
			 html =`<div class="Lcont">
				
				<img class="pimg" src="/jspweb/Member/img/${msgBox.frommimg}"/>
				<div class="tocont">
					<div class="name">${msgBox.frommid}</div> 
					<div class="subcont">
						${typeHTML(msgBox.msg) }	
						<div class="date">${msgBox.date}</div>
					</div>
				</div>
			</div>`;
		}
	
	
	// 3. 누적대입 [ 기존 채팅목록 에 이어서 추가 +=]
	chatcont.innerHTML+=html;
	
	// ----------------------- 스크롤 최하단으로 내리기(스크롤 이벤트) ----------------------------- //
	// 1. 현재 스크롤의 상단 위치 좌표.
	let topHeight = chatcont.scrollTop; // dom객체.scrollTop : 해당 div의 스크롤 상단위치
		console.log(topHeight);
	// 2. 현재 dom객체의 전체 높이
	let scrollHeight = chatcont.scrollHeight; // dom객체.scrollHeight : 해당 div 스크롤 전체높이
		console.log(scrollHeight);
	// 3. 전체 높이 값을 현재 스크롤 상단 위치에 대입
	chatcont.scrollTop = chatcont.scrollHeight;
}
// 5. textarea 입력창에서 입력할때마다 이벤트 발생 함수
function onEnterKey(){
	
	
	// 2. 만약에 ctrl + 엔터이면 줄바꿈.
	if(window.event.keyCode ==13 && window.event.ctrlKey){ // 조합키 : 한번에 두개이상 입력 가능한키
		console.log('dddddd'); document.querySelector('.msg').value += `\n`; return;
		}
	// 1. 만약에 입력한 키 가 [ 엔터] 이면 메세지 전송
	if(window.event.keyCode == 13 ){onSend(); return;}
		
}
// 6. 이모티콘 출력하기
getEmo();
function getEmo(){
	
	// -
	for(let i= 1; i<=43 ; i++){
		document.querySelector('.emolistbox').innerHTML
		+=` <img onclick="onEmoSend(${i})" src="/jspweb/img/imoji/emo${i}.gif" />`;
	}
}
// 7.클릭한 이모티콘 서버로 보내기
function onEmoSend( i ){
	// 1. msg 구성 
	let msg = { type : 'emo' , content : i+"" }; // i+""하는 이유가 replace 
		// type : msg[메시지] , emo[이모티콘] , img[사진]
		// content : 내용물 
		console.log(msg)
		
	// 2. 보내기 
	clientSocket.send( JSON.stringify( msg ) );
			// JSON타입을 String타입으로 변환해주는 함수. [ 모양/형식/포멧 : JSON ] 
}
// 8. msg 타입에 따른 HTML 반환 함수
function typeHTML(msg){
	
	let html =``;
	
	// 1. 메세지 타입 일때는 <div> 반환
	if(msg.type == 'message'){
		html+=`<div class="content">${msg.content} </div>	`;
	}
	// 2. 이모티콘 타입 일때는 <img> 반환
	else if(msg.type== 'emo'){
		html+=`<img src="/jspweb/img/imoji/emo${msg.content}.gif" /> `;
	}
	// 3. 만약에 알림 타입 일때는 <div> 반환
	else if(msg.type=='alarm'){
		html +=`<div class="alarm"> ${msg.content} </div>`;
	}
	return html;
}












/*

	JS[HTML 파일 종속된 파일 - HTML 안에서 실행되는 구조]
	
		클라이언트 : 사용 데이터 사용하는 PC
		서버 : 데이터 제공하는 PC 
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트림 방식 : URL?매개변수명1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3
		2. 
	- 소켓이란.
		- 통신의 종착점 [데이터가 전달되는 위치]
		
		[클라이언트소켓]															[서버소켓]
		JS=강호동집																	우체국
		 	안산시 상록구[소켓]
		JS=신동엽집
			수원시 영통구[소켓]
	
	-WebSocket 웹소켓 라이브러리
		* 소켓 관련된 함수들을 제공하는 클래스
		1. 웹소켓 객체 생성
			new WebSocket("ws://IP주소:PORT번호/프로젝트명/서버소켓경로");
			
		2. 메소드 제공
			.send() 	: 클라이언트소켓이 연결된 서버소켓에게 메세지를 전송
			
		* 동기화 vs 비동기화
		
		동기화												비동기화
		
		Client		Server							Client					Server	
		
		---------요청1-------->									---------요청1 -------->
		---------요청2-------->									---------요청2-------->
						요청1처리중													요청1처리중		<---------응답1 --------									<---------응답1 --------
*/








// --------------------------------------------------------------------------------------------------------- //
// 1. 클라이언트 소켓 만들기
	// 1.js웹소켓 객체 ('ws//ip주소:포트번호/서버소켓URL');
/*
let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); console.log(클라이언트소켓);
		// 2. onopen , onclose,send,onmessage 등등 메소드 제공
		
		// 내가 만든 함수를 클라이언트소켓 속성에 대입
		클라이언트소켓.onmessage = (e)=>onmsg(e);


	// 2. 연결된 서버소켓에게 메시지 보내기
function msgsend(){
	// 1. input 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 . send();
	클라이언트소켓.send(msg); // input에서 입력받은 데이터 보내기
	 
}
// 3. 연결된 서버소켓으로 부터 메세지를 받았을때.
function onmsg(e){
	console.log(e)
	console.log(e.data);
	
	document.querySelector('.contentbox')
					.innerHTML += `<div> ${e.data}</div>`
}



/*
	1. AJAX
		발신자(보내는사람) 	:
		수신자(받는사람) 		:
		
		 
		JS										JAVA[서블릿]
			
		AJAX				
							rest				get
												post
												put
												delete

	2. (웹) 소켓
			소켓 : 통신의 종착점[도착위치]
		 JS										JAVA
		 [클라이언트소켓]						[서버소켓]
		 websocket
	
*/
/*
					클라언트[사용자]										서버[서비스회사]
							
		강호동카카오톡
							'안녕'
							------------------------------>
							1. 강호동 메시지(안녕) 보낸다.
		
		유재석 카카오톡
		
																			카카오서버[제주도]
																			- 전제조건 : 클라이언트의 정보들 보관
																			접속된명단 : [강호동,유재석,신동엽,하하]
		신동엽카카오톡														2. '안녕' 메시지 받는다.
					<----------------------------------------------
		
					3. '안녕' 메시지 보낸다.
					<----------------------------------------------
		하하카카오톡
					<----------------------------------------------
					3. '안녕' 메시지 보낸다.


*/
