let 현재위도 = 0;
let 현재경도 = 0;

navigator.geolocation.getCurrentPosition( e => {

	 현재위도 = e.coords.latitude;
	 현재경도 = e.coords.longitude;
	 
});


function accept() {
	
	

	let gpsClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/gpssocket");

	
	let contentBox = document.querySelector('.accept');
	
	let html =``;
	
	html = `
	 
		<button type="button" class="rigjtBtn">앞으로</button>
     	<button type="button" class="leftBtn">뒤로</button>
     	<button type="button" class="topBtn">위로</button>
     	<button type="button" class="bottomBtn">아래로</button>
	`;
	
	contentBox.innerHTML = html;
	
	document.querySelector('.rigjtBtn').addEventListener('click' , (e)=>{
	console.log('앞으로');
	현재경도 += 0.0001; 
	gpsClientSocket.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})

document.querySelector('.leftBtn').addEventListener('click' , (e)=>{
	console.log('뒤로')
	현재경도 -= 0.0001; 
	gpsClientSocket.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})

document.querySelector('.topBtn').addEventListener('click' , (e)=>{
	console.log('위로')
	현재위도 += 0.0001; 
	gpsClientSocket.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})

document.querySelector('.bottomBtn').addEventListener('click' , (e)=>{
	console.log('아래로')
	현재위도 -= 0.0001; 
	gpsClientSocket.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
	})
	
	
	gpsClientSocket.onmessage = (e)=>{
	let data =  JSON.parse(e.data); console.log( data );
	현재위도 = data.현재위도
	현재경도 = data.현재경도
	
}
}








let callClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/callsocket");

callClientSocket.onmessage = (e)=>{
	
	
	

	
	console.log(e);
	let jsonData =  JSON.parse( e.data ) ;
	console.log(jsonData);
	
	let callcontent = document.querySelector('.callcontent');
	
	let html1 =``;
	
	html1 = `
		<h3> 콜 도착 </h3>
	 	<div id="map" style="width:100%;height:350px;"></div><br/>
	 	<div class = "mname">${jsonData.mno}</div><br/>
	 	<div class = "start">${jsonData.현재위도},${jsonData.현재경도}</div><br/>
	 	<div class = "end">${jsonData.도착위도},${jsonData.도착경도}</div><br/>
	 	<div class = "call">${jsonData.요청내용}</div>
		
	`;
	
	
	
	callcontent.innerHTML = html1;
	

  
    
 

    // 콜 도착 후에 지도를 생성하고 해당 div에 추가
    let mapContainer = document.getElementById('map');
    let mapOption = {
        center: new kakao.maps.LatLng(jsonData.출발위도, jsonData.출발경도),
        level: 3 // 지도의 확대 레벨
    };
    let map = new kakao.maps.Map(mapContainer, mapOption);
    
	

	


	var startSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_b.png', // 출발 마커이미지의 주소입니다    
    startSize = new kakao.maps.Size(50, 45), // 출발 마커이미지의 크기입니다 
    startOption = { 
        offset: new kakao.maps.Point(15, 43) // 출발 마커이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
    };

// 출발 마커 이미지를 생성합니다
var startImage = new kakao.maps.MarkerImage(startSrc, startSize, startOption);

var startDragSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_drag.png', // 출발 마커의 드래그 이미지 주소입니다    
    startDragSize = new kakao.maps.Size(50, 64), // 출발 마커의 드래그 이미지 크기입니다 
    startDragOption = { 
        offset: new kakao.maps.Point(15, 54) // 출발 마커의 드래그 이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
    };

// 출발 마커의 드래그 이미지를 생성합니다
var startDragImage = new kakao.maps.MarkerImage(startDragSrc, startDragSize, startDragOption);

// 출발 마커가 표시될 위치입니다 
var startPosition = new kakao.maps.LatLng(jsonData.출발위도, jsonData.출발경도); 

// 출발 마커를 생성합니다
var startMarker = new kakao.maps.Marker({
    map: map, // 출발 마커가 지도 위에 표시되도록 설정합니다
    position: startPosition,
    draggable: true, // 출발 마커가 드래그 가능하도록 설정합니다
    image: startImage // 출발 마커이미지를 설정합니다
});

// 출발 마커에 dragstart 이벤트를 등록합니다
kakao.maps.event.addListener(startMarker, 'dragstart', function() {
    // 출발 마커의 드래그가 시작될 때 마커 이미지를 변경합니다
    startMarker.setImage(startDragImage);
});

// 출발 마커에 dragend 이벤트를 등록합니다
kakao.maps.event.addListener(startMarker, 'dragend', function() {
     // 출발 마커의 드래그가 종료될 때 마커 이미지를 원래 이미지로 변경합니다
    startMarker.setImage(startImage);
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
 
// 도착 마커의 드래그 이미지를 생성합니다
var arriveDragImage = new kakao.maps.MarkerImage(arriveDragSrc, arriveDragSize, arriveDragOption);

// 도착 마커가 표시될 위치입니다 
var arrivePosition = new kakao.maps.LatLng(jsonData.도착위도, jsonData.도착경도);    
 
// 도착 마커를 생성합니다 
var arriveMarker = new kakao.maps.Marker({  
    map: map, // 도착 마커가 지도 위에 표시되도록 설정합니다
    position: arrivePosition,
    draggable: true, // 도착 마커가 드래그 가능하도록 설정합니다
    image: arriveImage // 도착 마커이미지를 설정합니다
});

// 도착 마커에 dragstart 이벤트를 등록합니다
kakao.maps.event.addListener(arriveMarker, 'dragstart', function() {
    // 도착 마커의 드래그가 시작될 때 마커 이미지를 변경합니다
    arriveMarker.setImage(arriveDragImage);
});

// 도착 마커에 dragend 이벤트를 등록합니다
kakao.maps.event.addListener(arriveMarker, 'dragend', function() {
     // 도착 마커의 드래그가 종료될 때 마커 이미지를 원래 이미지로 변경합니다
    arriveMarker.setImage(arriveImage);  
});
	

	
}












