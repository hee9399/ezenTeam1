//// 변수를 선언하여 라이더와 매칭 상태를 저장합니다.
//let isMatching = false;
//let message = "";
//// 매칭 상태를 업데이트하는 함수
//function updateMatchingStatus(matched) {
//  isMatching = matched;
//
//  // 매칭 상태가 변경될 때 화면을 업데이트합니다.
//  updateScreen();
//}
//
//// 화면을 업데이트하는 함수
//function updateScreen() {
//  if (isMatching) {
//    // 매칭된 상태일 때 지도를 표시하고, "라이더의 위치"를 출력합니다.
//    displayMap();
//    message = document.querySelector('.message')
//  
//  	let html = `<div>매칭 성공</div>`;
//  
//  	message.innerHTML = html;
//    
//  } else {
//    // 매칭되지 않은 상태일 때 "라이더와 매칭 대기 중"을 출력합니다.
//    message = document.querySelector('.message')
//  
//  	let html = `<div>라이더와 매칭 대기중</div>`;
//  
//  	message.innerHTML = html;
//  }
//}
//
//
//// 지도를 화면에 표시하는 함수
//function displayMap() {
//  // 지도를 표시하는 코드를 작성합니다.
//  // 예를 들어 Kakao 지도 API를 사용하여 지도를 표시합니다.
//}
//
//// 예시: 초기 상태 설정
//updateMatchingStatus(false);
//
//// 예시: 매칭 시작 시 매칭 상태를 업데이트
//// updateMatchingStatus(true);
let message = document.querySelector('.message');

let html = `<h1>매칭 대기중입니다 잠시만 기다려주세요</h1>`;

message.innerHTML = html;

let callClientSocket = new WebSocket(`ws://localhost:8080/ezenTeam1/callsocket`);

callClientSocket.onmessage = (e) => {

}


