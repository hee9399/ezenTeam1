
let gpsClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/gpssocket");

// 사용자가 콜 버튼으로 라이더에게 메시지 전송.

// 현재위치, 도착지 , 요청사항을 담아 서버에 전송.

function call (){


	gpsClientSocket.onmessage = (e)=>{
		let data =  JSON.parse(e.data); console.log( data );
		현재위도 = data.현재위도
		현재경도 = data.현재경도
		
	}

}


let 현재위도 = 0;
let 현재경도 = 0;

navigator.geolocation.getCurrentPosition( e => {
	 현재위도 = e.coords.latitude;
	 현재경도 = e.coords.longitude;
	 
	 
} );

let 도착위도 = 0;
let 도착경도 = 0;

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.320682, 126.832668), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
    도착위도 = latlng.getLat();
    도착경도 = latlng.getLng();
    
});



let callClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/callsocket");

document.querySelector('.call').addEventListener('click' , (e)=>{
	let callInfo = {
		현재위도 : 현재위도 , 현재경도 : 현재경도 , mno : 1 , 도착위도 : 도착위도 , 도착경도 : 도착경도 , 요청내용 : '잘부탁드립니다.'
	}
	callClientSocket.send( JSON.stringify(callInfo) );
})








