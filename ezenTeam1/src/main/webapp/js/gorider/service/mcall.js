
let gpsClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/gpssocket");

// 사용자가 콜 버튼으로 라이더에게 메시지 전송.

// 현재위치, 도착지 , 요청사항을 담아 서버에 전송.

function call (){

navigator.geolocation.getCurrentPosition( e => {

	let 현재위도 = e.coords.latitude;
	let 현재경도 = e.coords.longitude;
	 
	let locPosition = new kakao.maps.LatLng(현재위도, 현재경도)
	 
});

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

let callClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/callsocket");

document.querySelector('.call').addEventListener('click' , (e)=>{
	let callInfo = {
		출발위도 : 현재위도 , 출발경도 : 현재경도 , mno : 1 , 도착위도 : 현재위도 , 도착경도 : 현재경도 , 요청내용 : '잘부탁드립니다.'
	}
	callClientSocket.send( JSON.stringify(callInfo) );
})








