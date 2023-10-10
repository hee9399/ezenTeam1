let no = loginMno;

/* [ 사용자 화면 ] 라이더가 수락 했을때*/

let message = document.querySelector('.message');

let html = `<h1>매칭 대기중입니다 잠시만 기다려주세요</h1>`;

message.innerHTML = html;

let callClientSocket = new WebSocket(`ws://localhost:8080/ezenTeam1/callsocket/user/${no}`);

let gpsClientSocket = null;

callClientSocket.onmessage = (e) => {
    let jsonData = JSON.parse(e.data);
    console.log(jsonData);
    
    // 1.  수락했을때 지도 띄우기
    if( jsonData.type == 'accept'){
		handleMatchSuccess( jsonData.rname  , jsonData.rbikenum , jsonData.sriderla , jsonData.sriderlo );
   		 // 콜 수락을 라이더로부터 받았을때. 유저는 gps소켓에 들어감.
   		if(gpsClientSocket== null ){
				gpsClientSocket = new WebSocket(`ws://localhost:8080/ezenTeam1/gpssocket/${ jsonData.sno }`);
		}
	}else if( jsonData.type == 'out'){
		getOut(); // 2. 하차.
	}else if( jsonData.type == 'on'){
		alert('라이더에 탑승했습니다.. 안전하게 하차후 결제 해주세요..');
	}
};


// 매칭 성공 시 화면 업데이트 함수
function handleMatchSuccess(riderName,bikeNum, 라이더위도, 라이더경도) {
    let message = document.querySelector('.message');

    let html = `
        <h3> 매칭 성공 </h3>
        <div id="map" style="width:100%;height:350px;"></div>
        <div class="riderName">라이더 이름: ${riderName}</div>
        <div class="bikeNum">오토바이 번호: ${bikeNum}</div>
    `;
    message.innerHTML = html;

    // 라이더 위치를 지도에 표시
    showRiderLocationOnMap(라이더위도, 라이더경도);
}

// 라이더 위치를 지도에 표시하는 함수 (카카오맵 API를 사용한 예제)
function showRiderLocationOnMap(latitude, longitude) {
    let mapContainer = document.getElementById('map');
    let mapOption = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 4
    };
    let map = new kakao.maps.Map(mapContainer, mapOption);

    // 라이더 마커 추가
    let riderMarker = new kakao.maps.Marker({
        position: new kakao.maps.LatLng(latitude, longitude),
        map: map
    });
}

// 하차 
function getOut(){
	// 1.하차 이벤트 처리
	
		// 1. 결제.[ 입금 -> 현재페이지 vs 결제페이지 ]
		// 2. 페이지 전환 [ 리뷰 페이지 ]
	// 테스트 
	location.href="/ezenTeam1/gorider/service/addrInput.jsp";
}








