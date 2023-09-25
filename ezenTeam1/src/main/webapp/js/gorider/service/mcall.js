
let gpsClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/gpssocket");

function call (){


	gpsClientSocket.onmessage = (e)=>{
		let data =  JSON.parse(e.data); console.log( data );
		현재위도 = data.현재위도;
		현재경도 = data.현재경도;	
	}

}


let 현재위도 = 0;
let 현재경도 = 0;
let 현재주소 = "";
let 도착위도 = 0;
let 도착경도 = 0;
let destination = "";
let 요청내용 = "";


let JsonInfo = sessionStorage.getItem('info');
if (JsonInfo) {
    let info = JSON.parse(JsonInfo);

    let destinationAddress = info.address;

    // 현재 위치 가져오기
    navigator.geolocation.getCurrentPosition(function(position) {
        let currentLocation = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude);


        // 도착지 주소를 좌표로 변환
        let geocoder = new kakao.maps.services.Geocoder();
        geocoder.addressSearch(destinationAddress, function(result, status) {
            if (status === kakao.maps.services.Status.OK) {
                let destinationLocation = new kakao.maps.LatLng(result[0].y, result[0].x);
                
                
                

                // 지도 생성
                var mapContainer = document.getElementById('map');
                var mapOption = {
                    center: currentLocation, // 현재 위치를 중심으로 지도 생성
                    level: 3
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
				
				

                // 현재 위치 마커 생성
                let currentLocationMarker = new kakao.maps.Marker({
                    position: currentLocation,
  
                    map: map,
                    image: startImage
                });
				
				// 출발 마커에 dragstart 이벤트를 등록합니다
				kakao.maps.event.addListener(currentLocationMarker, 'dragstart', function() {
					// 출발 마커의 드래그가 시작될 때 마커 이미지를 변경합니다
					currentLocationMarker.setImage(startDragImage);
				});

				// 출발 마커에 dragend 이벤트를 등록합니다
				kakao.maps.event.addListener(currentLocationMarker, 'dragend', function() {
					// 출발 마커의 드래그가 종료될 때 마커 이미지를 원래 이미지로 변경합니다
					currentLocationMarker.setImage(startImage);
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
				
				
                // 도착지 마커 생성
                let destinationMarker = new kakao.maps.Marker({
                    position: destinationLocation,

                    map: map,
                    image: arriveDragImage
                });
                
				// 도착 마커에 dragstart 이벤트를 등록합니다
				kakao.maps.event.addListener(destinationMarker, 'dragstart', function() {
					// 도착 마커의 드래그가 시작될 때 마커 이미지를 변경합니다
					destinationMarker.setImage(arriveDragImage);
				});

				// 도착 마커에 dragend 이벤트를 등록합니다
				kakao.maps.event.addListener(destinationMarker, 'dragend', function() {
					// 도착 마커의 드래그가 종료될 때 마커 이미지를 원래 이미지로 변경합니다
					destinationMarker.setImage(arriveImage);
				});
				
				
				

                // 지도 영역 설정
                let bounds = new kakao.maps.LatLngBounds();
                bounds.extend(currentLocation);
                bounds.extend(destinationLocation);
                map.setBounds(bounds);
                
                

                // 장소 정보 출력
                let placeinfo = document.querySelector('.placeinfo');
                let html = `
                    <div>장소명 : ${info.name} </div>
                    <div>주소 : ${info.address} </div>
                    <div>전화번호 : ${info.phone} </div>
                    <div><input class = "ccontent" type = "text" placeholder="요청사항을 적어주세요!"></div>
                `;
                placeinfo.innerHTML = html;
                
                destination = { 장소명 : info.name , 주소 : info.address};
                console.log(destination);
                
                
                
            }
            도착위도 =result[0].y;
    		도착경도 =result[0].x;
        });
        
        현재위도 = position.coords.latitude;
   		현재경도 = position.coords.longitude;
   		
		geocoder.coord2Address(현재경도, 현재위도, function(result, status) {
			if (status === kakao.maps.services.Status.OK) {
				현재주소 = result[0].address;
				}
				console.log(현재주소)
		});


	});

    
 
	
		
}


let callClientSocket = new WebSocket("ws://localhost:80/ezenTeam1/callsocket");

document.querySelector('.call').addEventListener('click' , (e)=>{
	
	
	requestContent = document.querySelector('.ccontent').value;	
	let callInfo = {
		현재위도 : 현재위도 , 현재경도 : 현재경도 , mno : 1 , 도착위도 : 도착위도 , 도착경도 : 도착경도 , 요청내용 : requestContent
		, 목적지 : destination , 출발지 : 현재주소
	}
	callClientSocket.send( JSON.stringify(callInfo) );
})




