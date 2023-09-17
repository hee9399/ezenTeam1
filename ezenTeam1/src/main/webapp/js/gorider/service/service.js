/**
 * 카카오지도 마커표시하기
 */

// 내 현재위치를 가져와서 중심좌표로 설정
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.319022, 126.836956), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
customOverlay = new kakao.maps.CustomOverlay({}),
infowindow = new kakao.maps.InfoWindow({ removable: true });

// 마커를 표시할 위치와 title 객체 배열입니다
var positions = [
    {
        title: '라이더1',
        latlng: new kakao.maps.LatLng(37.320682, 126.832668)
    },
    {
        title: '라이더2',
        latlng: new kakao.maps.LatLng(37.319987, 126.833672)
    },
    {
        title: '라이더3',
        latlng: new kakao.maps.LatLng(37.317693, 126.834695)
    },
    {
        title: '라이더4',
        latlng: new kakao.maps.LatLng(37.317585, 126.842023)
    },
    {
        title: '라이더5',
        latlng: new kakao.maps.LatLng(37.320866, 126.835650)
    },
    {
        title: '라이더6',
        latlng: new kakao.maps.LatLng(37.319285, 126.831765)
    },
    {
        title: '라이더7',
        latlng: new kakao.maps.LatLng(37.318940, 126.838298)
    },
    {
        title: '라이더8',
        latlng: new kakao.maps.LatLng(37.317986, 126.832454)
    },
    {
        title: '라이더9',
        latlng: new kakao.maps.LatLng(37.317478, 126.838119)
    },
    {
        title: '라이더10',
        latlng: new kakao.maps.LatLng(37.316616, 126.840186)
    }
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

var markers = [] ;

for (var i = 0; i < positions.length; i++) {
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image: markerImage // 마커 이미지 
    });
    
    markers.push(marker);
}



var polygonPath = [
    new kakao.maps.LatLng(37.321097, 126.831116),
    new kakao.maps.LatLng(37.320628, 126.840574),
    new kakao.maps.LatLng(37.319897, 126.840678),
    new kakao.maps.LatLng(37.317837, 126.842684),
    new kakao.maps.LatLng(37.316420, 126.842572),
    new kakao.maps.LatLng(37.317085, 126.830693)
];

// 다각형 객체 생성
var polygon = new kakao.maps.Polygon({
    path: polygonPath, // 다각형을 구성하는 좌표 배열 설정
    strokeWeight: 2,
    strokeColor: '#666666', // 선 색상 설정
    strokeOpacity: 0.8,
    fillColor: '#e8e8e8',   // 채우기 색상 설정
    fillOpacity: 0.4
});
// 다각형 객체를 지도에 추가
polygon.setMap(map);

// 마커를 이동시키는 함수
function moveMarkers() {
    // 각 마커의 이동 경로를 저장하는 배열
    var markerPaths = [];

    // 다각형 경계를 구성하는 좌표 배열
var polygonBounds = new kakao.maps.LatLngBounds();

for (var i = 0; i < polygonPath.length; i++) {
    polygonBounds.extend(polygonPath[i]);
}

// 최소, 최대 경도 및 위도를 가져오는 대신, polygonBounds 객체의 값 자체를 사용합니다.
var southLat = Math.min.apply(null, polygonPath.map(function(point) { return point.getLat(); })); // 남쪽 경계의 위도
var northLat = Math.max.apply(null, polygonPath.map(function(point) { return point.getLat(); })); // 북쪽 경계의 위도
var westLng = Math.min.apply(null, polygonPath.map(function(point) { return point.getLng(); })); // 서쪽 경계의 경도
var eastLng = Math.max.apply(null, polygonPath.map(function(point) { return point.getLng(); })); // 동쪽 경계의 경도
    // 각 마커의 경로를 다각형 영역 내에서 생성하여 설정합니다
    for (var i = 0; i < markers.length; i++) {
        var marker = markers[i];
        var randomPath = [];

        // 임의의 좌표 30개 생성 (다각형 영역 내에서)
        for (var j = 0; j < 30; j++) {
            var randomLat = southLat + Math.random() * (northLat - southLat);
            var randomLng = westLng + Math.random() * (eastLng - westLng);
            randomPath.push(new kakao.maps.LatLng(randomLat, randomLng));
        }

        markerPaths.push(randomPath);
    }

    // 모든 마커를 동시에 이동합니다
    for (var i = 0; i < markers.length; i++) {
        animateMarker(markers[i], markerPaths[i]);
    }
}

// animateMarker 함수 
function animateMarker(marker, path) {
    var index = 0;

    function move() {
        if (index < path.length) {
            marker.setPosition(path[index]);
            index++;
        } else {
            index = 0; // 경로를 끝까지 이동한 후 다시 처음부터 시작하도록 인덱스 초기화
        }
    }

    // 1초마다 move 함수 호출
    setInterval(move, 500);
}

// 이동 시작 버튼 클릭 이벤트 등록
document.getElementById("startButton").addEventListener("click", moveMarkers);