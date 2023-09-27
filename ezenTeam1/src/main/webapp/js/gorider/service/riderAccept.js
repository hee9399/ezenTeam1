let sfromla = 0;
let sfromlo = 0;
let rmessage = "";
let 라이더 = null;
let 라이더위도 = 37.320682;
let 라이더경도 = 126.832668;
navigator.geolocation.getCurrentPosition(e => {

	sfromla = e.coords.latitude;
	sfromlo = e.coords.longitude;

});
/*2. 소켓으로 전달하는 내용은 수락정보, 라이더 위치(라이더가 보내는 메시지는 언제라도)*/

function accept() {


	let gpsClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/gpssocket");

	
	let contentBox = document.querySelector('.accept');

	let html = ``;

	html = `
	 
		<button type="button" class="rigjtBtn">앞으로</button>
     	<button type="button" class="leftBtn">뒤로</button>
     	<button type="button" class="topBtn">위로</button>
     	<button type="button" class="bottomBtn">아래로</button>
	`;

	contentBox.innerHTML = html;

	document.querySelector('.rigjtBtn').addEventListener('click', (e) => {
		console.log('앞으로');
		라이더경도 += 0.0001;
	
		gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
	})

	document.querySelector('.leftBtn').addEventListener('click', (e) => {
		console.log('뒤로')
		라이더경도 -= 0.0001;
	
		gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
	})

	document.querySelector('.topBtn').addEventListener('click', (e) => {
		console.log('위로')
		라이더위도 += 0.0001;
		
		gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
	})

	document.querySelector('.bottomBtn').addEventListener('click', (e) => {
		console.log('아래로')
		라이더위도 -= 0.0001;
	
		gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
	})



	gpsClientSocket.onmessage = (e) => {
		let data = JSON.parse(e.data); console.log(data);
		라이더위도 = data.sfromla
		라이더경도 = data.sfromlo
		마커셋팅();
	}

}








let callClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/callsocket");






callClientSocket.onmessage = (e) => {

	alert('통신');

	let jsonData = JSON.parse(e.data);
	console.log(jsonData);
	let callcontent = document.querySelector('.callcontent');

	let html = ``;

	html = `
		<h3> 콜 도착 </h3>
	 	<div id="map" style="width:100%;height:350px;"></div>
	 	
	 	<div class = "mno">고객 아이디 : ${jsonData.mno}</div>
	 	<div class = "start">고객 위치 : ${jsonData.출발지.address_name}</div>
	 	<div class = "end">목적지 : ${jsonData.목적지.주소} ${jsonData.목적지.장소명}</div>
	 	<div class = "call">요청내용 : ${jsonData.요청내용}</div>
	 	
	 	<div class = "choicebox">	
	 		<button onclick = "accept()" type = "button" class = "accept">수락</button>
			<button onclick = "reject()" type = "button" class = "reject">거절</button>
		</div>`;



	callcontent.innerHTML = html;

	var mapContainer = document.getElementById('map');
	var mapOption = {
		center: new kakao.maps.LatLng(jsonData.sfromla, jsonData.sfromlo), // 현재 위치를 중심으로 지도 생성
		level: 4
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);
	

	var startSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_b.png', // 출발 마커이미지의 주소입니다    
		startSize = new kakao.maps.Size(50, 45), // 출발 마커이미지의 크기입니다 
		startOption = {
			offset: new kakao.maps.Point(15, 43) // 출발 마커이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
		};

	var startImage = new kakao.maps.MarkerImage(startSrc, startSize, startOption);

	var startDragSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_drag.png', // 출발 마커의 드래그 이미지 주소입니다    
		startDragSize = new kakao.maps.Size(50, 64), // 출발 마커의 드래그 이미지 크기입니다 
		startDragOption = {
			offset: new kakao.maps.Point(15, 54) // 출발 마커의 드래그 이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
		};

	// 출발 마커의 드래그 이미지를 생성합니다
	var startDragImage = new kakao.maps.MarkerImage(startDragSrc, startDragSize, startDragOption);


	// 마커가 표시될 위치입니다 
	var markerPosition1 = new kakao.maps.LatLng(jsonData.sfromla, jsonData.sfromlo);

	// 마커를 생성합니다
	var marker1 = new kakao.maps.Marker({
		position: markerPosition1,

		map: map,
		image: startImage

	});

	// 출발 마커에 dragstart 이벤트를 등록합니다
	kakao.maps.event.addListener(marker1, 'dragstart', function() {
		// 출발 마커의 드래그가 시작될 때 마커 이미지를 변경합니다
		marker1.setImage(startDragImage);
	});

	// 출발 마커에 dragend 이벤트를 등록합니다
	kakao.maps.event.addListener(marker1, 'dragend', function() {
		// 출발 마커의 드래그가 종료될 때 마커 이미지를 원래 이미지로 변경합니다
		marker1.setImage(startImage);
	});

	var arriveSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_b.png', // 도착 마커이미지 주소입니다    
		arriveSize = new kakao.maps.Size(50, 45), // 도착 마커이미지의 크기입니다 
		arriveOption = {
			offset: new kakao.maps.Point(15, 43) // 도착 마커이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
		};

	// 도착 마커 이미지를 생성합니다
	var arriveImage = new kakao.maps.MarkerImage(arriveSrc, arriveSize, arriveOption);

	var arriveDragSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_drag.png', // 도착 마커의 드래그 이미지 주소입니다    
		arriveDragSize = new kakao.maps.Size(50, 64), // 도착 마커의 드래그 이미지 크기입니다 
		arriveDragOption = {
			offset: new kakao.maps.Point(15, 54) // 도착 마커의 드래그 이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
		};


	var arriveDragImage = new kakao.maps.MarkerImage(arriveDragSrc, arriveDragSize, arriveDragOption);


	// 마커가 표시될 위치입니다 
	var markerPosition2 = new kakao.maps.LatLng(jsonData.stola, jsonData.stolo);

	// 마커를 생성합니다
	var marker2 = new kakao.maps.Marker({
		position: markerPosition2,

		map: map,
		image: arriveDragImage
	});

	// 도착 마커에 dragstart 이벤트를 등록합니다
	kakao.maps.event.addListener(marker2, 'dragstart', function() {
		// 도착 마커의 드래그가 시작될 때 마커 이미지를 변경합니다
		marker2.setImage(arriveDragImage);
	});

	// 도착 마커에 dragend 이벤트를 등록합니다
	kakao.maps.event.addListener(marker2, 'dragend', function() {
		// 도착 마커의 드래그가 종료될 때 마커 이미지를 원래 이미지로 변경합니다
		marker2.setImage(arriveImage);
	});

	var riderSrc = '/ezenTeam1/img/gorider/icon.png',    
		riderSize = new kakao.maps.Size(50, 45),
		riderOption = {
			offset: new kakao.maps.Point(15, 43) 
		};

	
	var riderImage = new kakao.maps.MarkerImage(riderSrc, riderSize, riderOption);

	// 마커가 표시될 위치입니다 
	var 라이더위치 = new kakao.maps.LatLng(라이더위도, 라이더경도);

	// 마커를 생성합니다
		라이더 = new kakao.maps.Marker({
		position: 라이더위치,
		map: map,
		image: riderImage
	});
	
	




	// 지도 영역 설정
	let bounds = new kakao.maps.LatLngBounds();
	bounds.extend(markerPosition1);
	bounds.extend(markerPosition2);
	
	map.setBounds(bounds);


}


function 마커셋팅(){
	if(라이더) {
	라이더.setMap(null);
	}
	var riderSrc = '/ezenTeam1/img/gorider/icon.png',    
		riderSize = new kakao.maps.Size(50, 45),
		riderOption = {
			offset: new kakao.maps.Point(15, 43) 
		};

	
	var riderImage = new kakao.maps.MarkerImage(riderSrc, riderSize, riderOption);

	// 마커가 표시될 위치입니다 
	var 라이더위치 = new kakao.maps.LatLng(라이더위도, 라이더경도);

	// 마커를 생성합니다
		라이더 = new kakao.maps.Marker({
		position: 라이더위치,
		map: map,
		image: riderImage
	});
	
	라이더.setMap(map);
	
}




/*
수락 버튼을 눌렀을 시
1. 라이더 화면에는 사용자의 위치(출발지) , 사용자의 도착지, 라이더 현재 위치를 포함하는 마커를 띄우는 지도(js -> js)

*/

// 수락버튼을 누르기 전까지는 화면 업데이트 X
// 거절버튼을 누르면 화면 업데이트
// 수락버튼을 누르면 라이더는 현재위치에서 사용자의 출발지 좌표 지도에 찍어 화면에 출력
// 사용자도 마찬가지로 라이더가 있는 곳과 1초마다 움직이는 좌표 생성, 메시지 출력
// 사용자와 라이더의 거리가 100m ? 쯤 되면 메시지 전송(거의 다왔습니다!!)
// 탑승시 라이더가 탑승 버튼 클릭? 라이더의 gps가 목적지에 도착하여 하차를 클릭하면 종료
// 타고 가는 동안 사용자화면은 출발지, 목적지 , 움직이는 라이더 좌표 출력
// 하차와 동시에 사용자에게 리뷰요청 화면 출력








