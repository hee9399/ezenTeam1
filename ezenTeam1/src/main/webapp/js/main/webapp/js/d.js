// Mapbox API 키를 여기에 입력하세요
mapboxgl.accessToken = '3fb15e33b93bb6f921e4522dce2dbbf6';

var longitude = -122.4194; // 라이더의 현재 경도
var latitude = 37.7749;   // 라이더의 현재 위도

// 지도 초기화
var map = new mapboxgl.Map({
  container: 'map',
  style: 'mapbox://styles/mapbox/streets-v11', // 적절한 스타일 선택
  center: [longitude, latitude], // 초기 중심 좌표
  zoom: 12 // 초기 줌 레벨
});



// 라이더의 마커 생성
var riderMarker = new mapboxgl.Marker()
  .setLngLat([longitude, latitude]) // 라이더의 초기 위치
  .addTo(map);

// 라이더의 위치를 실시간으로 업데이트하는 함수 (예: 1초마다 업데이트)
function updateRiderLocation() {
	newLongitude=51.5074;
	newLatitude=-0.1278;
  // 라이더의 새로운 위치를 얻는 코드를 여기에 추가하세요 (예: AJAX 요청 또는 WebSocket 사용)
  var newLngLat = [newLongitude, newLatitude]; // 새로운 위치 좌표
  riderMarker.setLngLat(newLngLat); // 마커 위치 업데이트
  map.setCenter(newLngLat); // 지도 중심 업데이트
}

// 실시간 업데이트 설정 (1초마다 업데이트)
setInterval(updateRiderLocation, 1000);