

let userType = "rider";

let rmessage = "";
let 라이더 = null;
let markerPosition1 = "";
let 라이더위도 = 37.320682;
let 라이더경도 = 126.832668;

navigator.geolocation.getCurrentPosition(e => {
    sfromla = e.coords.latitude;
    sfromlo = e.coords.longitude;
});

console.log( rno );


function accept(sno) {
	
	//userType = "rider";
	callClientSocket = new WebSocket(`ws://localhost:8080/ezenTeam1/callsocket/${userType}`);
    let gpsClientSocket = new WebSocket("ws://localhost:8080/ezenTeam1/gpssocket");

	
    let contentBox = document.querySelector('.accept');
   
   callClientSocket.onopen = function(event) {
    
    let riderInfo = {
		type: "accept",
		
		라이더위도: 라이더위도, 라이더경도: 라이더경도 ,sno : sno , rno:rno}
	
	
	callClientSocket.send(JSON.stringify(riderInfo));
	
	};
    
    
    let html = `
        <button type="button" class="rightBtn">앞으로</button>
        <button type="button" class="leftBtn">뒤로</button>
        <button type="button" class="topBtn">위로</button>
        <button type="button" class="bottomBtn">아래로</button>
    `;
    
    contentBox.innerHTML = html;
    
    document.querySelector('.rightBtn').addEventListener('click', (e) => {
        console.log('앞으로');
        라이더경도 += 0.0001;
        gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
    });

    document.querySelector('.leftBtn').addEventListener('click', (e) => {
        console.log('뒤로');
        라이더경도 -= 0.0001;
        gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
    });

    document.querySelector('.topBtn').addEventListener('click', (e) => {
        console.log('위로');
        라이더위도 += 0.0001;
        gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
    });

    document.querySelector('.bottomBtn').addEventListener('click', (e) => {
        console.log('아래로');
        라이더위도 -= 0.0001;
        gpsClientSocket.send(JSON.stringify({ sfromla: 라이더위도, sfromlo: 라이더경도 }));
    });

    gpsClientSocket.onmessage = (e) => {
        let data = JSON.parse(e.data);
        console.log(data);
        라이더위도 = data.sfromla;
        라이더경도 = data.sfromlo;
        마커셋팅();
    };
    

    
}

//let callClientSocket = new WebSocket(`ws://localhost:8080/ezenTeam1/callsocket/${userType}`);
let callClientSocket = new WebSocket(`ws://localhost:8080/ezenTeam1/callsocket/${userType}`);

callClientSocket.onmessage = (e) => {
	
    alert('통신');
    let jsonData = JSON.parse(e.data);
    console.log('userType : ' + userType)
    console.log(jsonData);
    let callcontent = document.querySelector('.callcontent');
    let html = `
        <h3> 콜 도착 </h3>
        <div id="map" style="width:100%;height:350px;"></div>
        <div class="mno">고객 아이디 : ${jsonData.mno}</div>
        <div class="start">고객 위치 : ${jsonData.출발지.address_name}</div>
        <div class="end">목적지 : ${jsonData.목적지.주소} ${jsonData.목적지.장소명}</div>
        <div class="call">요청내용 : ${jsonData.요청내용}</div>
        <div class="choicebox">
            <button onclick="accept(sno)" type="button" class="accept">수락</button>
            <button onclick="reject()" type="button" class="reject">거절</button>
        </div>
    `;

    callcontent.innerHTML = html;

    let mapContainer = document.getElementById('map');
    let mapOption = {
        center: new kakao.maps.LatLng(jsonData.sfromla, jsonData.sfromlo),
        level: 4
    };

    let map = new kakao.maps.Map(mapContainer, mapOption);
    
    

    let startSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_b.png';
    let startSize = new kakao.maps.Size(50, 45);
    let startOption = {
        offset: new kakao.maps.Point(15, 43)
    };

    let startImage = new kakao.maps.MarkerImage(startSrc, startSize, startOption);

    let startDragSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_drag.png';
    let startDragSize = new kakao.maps.Size(50, 64);
    let startDragOption = {
        offset: new kakao.maps.Point(15, 54)
    };

    let startDragImage = new kakao.maps.MarkerImage(startDragSrc, startDragSize, startDragOption);

    let markerPosition1 = new kakao.maps.LatLng(jsonData.sfromla, jsonData.sfromlo);

    let marker1 = new kakao.maps.Marker({
        position: markerPosition1,
        map: map,
        image: startImage
    });

    kakao.maps.event.addListener(marker1, 'dragstart', function() {
        marker1.setImage(startDragImage);
    });

    kakao.maps.event.addListener(marker1, 'dragend', function() {
        marker1.setImage(startImage);
    });

    let arriveSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_b.png';
    let arriveSize = new kakao.maps.Size(50, 45);
    let arriveOption = {
        offset: new kakao.maps.Point(15, 43)
    };

    let arriveImage = new kakao.maps.MarkerImage(arriveSrc, arriveSize, arriveOption);

    let arriveDragSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_drag.png';
    let arriveDragSize = new kakao.maps.Size(50, 64);
    let arriveDragOption = {
        offset: new kakao.maps.Point(15, 54)
    };

    let arriveDragImage = new kakao.maps.MarkerImage(arriveDragSrc, arriveDragSize, arriveDragOption);

    let markerPosition2 = new kakao.maps.LatLng(jsonData.stola, jsonData.stolo);

    let marker2 = new kakao.maps.Marker({
        position: markerPosition2,
        map: map,
        image: arriveDragImage
    });

    kakao.maps.event.addListener(marker2, 'dragstart', function() {
        marker2.setImage(arriveDragImage);
    });

    kakao.maps.event.addListener(marker2, 'dragend', function() {
        marker2.setImage(arriveImage);
    });

    let riderSrc = '/ezenTeam1/img/gorider/icon.png';
    let riderSize = new kakao.maps.Size(50, 45);
    let riderOption = {
        offset: new kakao.maps.Point(15, 43)
    };

    let riderImage = new kakao.maps.MarkerImage(riderSrc, riderSize, riderOption);

    let 라이더위치 = new kakao.maps.LatLng(라이더위도, 라이더경도);

    라이더 = new kakao.maps.Marker({
        position: 라이더위치,
        map: map,
        image: riderImage
    });
    
    
    let bounds = new kakao.maps.LatLngBounds();
    bounds.extend(markerPosition1);
    bounds.extend(markerPosition2);

    map.setBounds(bounds);
}

function 마커셋팅() {
    if (라이더) {
        라이더.setMap(null);
    }

    let riderSrc = '/ezenTeam1/img/gorider/icon.png';
    let riderSize = new kakao.maps.Size(50, 45);
    let riderOption = {
        offset: new kakao.maps.Point(15, 43)
    };

    let riderImage = new kakao.maps.MarkerImage(riderSrc, riderSize, riderOption);

    let 라이더위치 = new kakao.maps.LatLng(라이더위도, 라이더경도);

    라이더 = new kakao.maps.Marker({
        position: 라이더위치,
        map: map,
        image: riderImage
    });

    라이더.setMap(map);
}
