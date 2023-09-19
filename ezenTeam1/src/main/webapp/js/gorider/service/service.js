

let 현재위도 = 37.320682
let 현재경도 = 126.832668

navigator.geolocation.getCurrentPosition( e => {

	 현재위도 = e.coords.latitude;
	 현재경도 = e.coords.longitude;
	 마커셋팅();
});

// 내 현재위치를 가져와서 중심좌표로 설정
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.319022, 126.836956), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

/* 기본마커 */
let position = {
    title: '라이더1',
    latlng: new kakao.maps.LatLng( 현재위도 , 현재경도 )
}
// 마커가 표시될 위치입니다 
var markerPosition  = position.latlng

let 현재마커 = new kakao.maps.Marker({
    position: markerPosition ,
    image : markerImage, // 마커의 이미지
});


var markerImageUrl = '/ezenTeam1/img/gorider/icon.png', 
    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
    markerImageOptions = { 
        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
    };

// 마커 이미지를 생성한다
var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

function accept() {
	let contentBox = document.querySelector('.contentBox');
	
	let html =``;
	
	html = `
	 
		<button type="button" class="rigjtBtn">앞으로</button>
     	<button type="button" class="leftBtn">뒤로</button>
     	<button type="button" class="topBtn">위로</button>
     	<button type="button" class="bottomBtn">아래로</button>
	`;
	
	contentBox.innerHTML = html;
}

function 마커셋팅(){
	
	현재마커.setMap(null); // 기존 마커 없애고
	
	let position = {
        title: '라이더1',
        latlng: new kakao.maps.LatLng( 현재위도 , 현재경도 )
	}
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = position.latlng
	
	// 마커를 생성합니다
	현재마커 = new kakao.maps.Marker({
	    position: markerPosition ,
	    image : markerImage, // 마커의 이미지
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	현재마커.setMap(map);
	
}


let 클라이언트소켓 = new WebSocket("ws://localhost:80/ezenTeam1/gpssocket");

document.querySelector('.rigjtBtn').addEventListener('click' , (e)=>{
	console.log('앞으로');
	현재경도 += 0.0001; 
	클라이언트소켓.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})

document.querySelector('.leftBtn').addEventListener('click' , (e)=>{
	console.log('뒤로')
	현재경도 -= 0.0001; 
	클라이언트소켓.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})

document.querySelector('.topBtn').addEventListener('click' , (e)=>{
	console.log('위로')
	현재위도 += 0.0001; 
	클라이언트소켓.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})

document.querySelector('.bottomBtn').addEventListener('click' , (e)=>{
	console.log('아래로')
	현재위도 -= 0.0001; 
	클라이언트소켓.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
})


클라이언트소켓.onmessage = (e)=>{
	let data =  JSON.parse(e.data); console.log( data );
	현재위도 = data.현재위도
	현재경도 = data.현재경도
	마커셋팅();
}



/*
	// 1. 특정시간때마다 실행
navigator.geolocation.getCurrentPosition( e => {
	 현재위도 = e.coords.latitude;
	 현재경도 = e.coords.longitude;
	 클라이언트소켓.send( JSON.stringify( { 현재위도 : 현재위도 , 현재경도 : 현재경도 } ) );
});

*/





