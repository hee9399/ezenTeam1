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
	
	let html =``;
	
	html = `
		<h3> 콜 도착 </h3>
	 	<div id="map" style="width:100%;height:350px;"></div><br/>
	 	<div class = "mname">${jsonData.mno}</div><br/>
	 	<div class = "start">${jsonData.출발위도},${jsonData.출발경도}</div><br/>
	 	<div class = "end">${jsonData.도착위도},${jsonData.도착경도}</div><br/>
	 	<div class = "call">${jsonData.요청내용}</div>
		
	`;
	
	callcontent.innerHTML = html;
	
}











