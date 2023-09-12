/*

	 공공데이터 포털
	 https://www.data.go.kr/data/15036759/fileData.do
	 

*/
api1();
// 1. 안산시 착한가격업소 API 호출
function api1(){
	$.ajax({
            url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=45&serviceKey=WVpYX0IJ%2BCCDNXhFYEMsDhYakGNXHmx9xFWG1yjjFfm5VRHY5cfgBhTmSX%2B%2BDTYllWNtInEyIP3F0ZnJJbTlLw%3D%3D",   
            metdod : "get",   
            data : {},      
           success : response =>{  console.log(response);
			  let data = response.data; console.log(data);
			  console.log(data[0]);
			  console.log(data[0].업소명);
			  
			  // 1. 출력할 dop객체
			  let apiTable1 = document.querySelector('.apiTable1');
			  
			  // 2. HTML 구성
			  let html = `<tr>
								<th>번호</th>
								<th>상호명</th>
								<th>주소</th>
								<th>연락처</th>
								<th>대표메뉴1</th>
								<th>대표메뉴2</th> 101
								<th>대표메뉴3</th>
							</tr>`;
			  		// 2.2
			  data.forEach( ( d , i ) =>{
				  html += `<tr>
						<td>${i+1}</td>
						<td>${d.업소명}</td>
						<td>${d.소재지도로명주소}</td>
						<td>${d.연락처}</th>
						<td>${d.품목1} / ${d.가격1} </td>
						<td>${d.품목2} / ${d.가격2}</td>
						<td>${d.품목3} / ${d.가격3}</td>
					</tr>`;
				  
			  });
			  //3. 출력할 위치에 HTML 대입
			  apiTable1.innerHTML=html;
			   } ,       
            error : e=>{} ,         
   });
 }
 
 // ------------------------------------------ 1. 카카오 지도 출력하는 객체 ------------------------------------------- //
 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });
 // -------------------마커 이미지 설정----------------- //
var markerImageUrl = '/jspweb/img/아구몬.jpg', 
		    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    }; 
// 마커 이미지를 생성한다
var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);


 
  // ------------------------------------------ 2.마커 클러스터러를 생성합니다.------------------------------------------- //
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });
  // ------------------------------------------ 3.마커 클러스터러를 추가할 .------------------------------------------- //  
     $.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=WVpYX0IJ%2BCCDNXhFYEMsDhYakGNXHmx9xFWG1yjjFfm5VRHY5cfgBhTmSX%2B%2BDTYllWNtInEyIP3F0ZnJJbTlLw%3D%3D", function(response) {
        console.log(response);
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        // response : 공공데이터 응답 객체
        // response.data : 응답객체내 검색된 전기차충전소 목록/배열 리스트
        
        
        var markers = $(response.data).map(function(i, position) {
			
			console.log(i); // 반복 인덱스
			console.log(position); // 목록내 하나씩 대입되는 반복 변수명
			
			// 개별 마커 생성후
				// let marker = new kakao.maps.Marker ({   })
			let marker = new kakao.maps.Marker ({  
				
				position : new kakao.maps.LatLng(position['위도(WGS84)'], position['경도(WGS84)'] ),
				image : markerImage, // 마커의 이미지
				
			 })
			
			// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
		kakao.maps.event.addListener(marker, 'click', function() {
		    
		   	let html = ``;
		   	
		   	html +=`<div> 충전소명 ${position.충전소명}</div>`
		   	html +=`<div> 충전소명 ${position.충전기타입명}</div>`
		   	html +=`<div> 충전소명 ${position.운영기관명}</div>`
		   	html +=`<div> 충전소명 ${position.소재지도로명주소}</div>`
    		
    		document.querySelector('.detaibox').innerHTML=html;
    		
		});
			
			
			
			
			// 생성된 마커 리턴
            return marker;
                   
          
            
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });
 
 /*
 	$.ajax({url:"",method:"",,data : {}, success : ()=> P{} })
 	$.method(url , data , () =>{} )
 	
 	객체내 속성 호출
 		객체명.속성명
 		객체명['속성명'] : 속성명에 특수문자가 있는 경우
 		
	 		- for 문
	      - 배열명 : arrayList
	      
	      1. 인덱스 0부터 배열의 길이만큼 반복
	         for(let i = 0 ; i<arrayList.length ; 1++){}
	      
	      2. 배열의 첫번째 인덱스부터 마지막인덱스까지 반복
	         for( let 인덱스변수 in arrayList){ }
	      
	      3. 배열의 첫번째 데이터 부터 마지막 데이터까지 반복
	         for(let 반복변수 of arrayList){ }
	         
	      4. 배열의 반복변수or인덱스를 첫번째부터 마지막 반복 [return x]
	         arrayList.forEach( (반복변수)=>{})
	         arrayList.forEach( (반복변수,인덱스번호)=>{})
	      
	      5. 배열의 반복변수or인덱스를 첫번째부터 마지막 반속   [ return o ]
	         arrayList.map((반복변수) =>{})
	         arrayList.map((반복변수,인덱스번호) =>{})
	         let newArrayList= arrayList.map( (반복변수,인덱스변수)=>{return})
	         
	      6. filter 
 				

 
 */
let arrayList = ['a','b','c','d']
console.log("=======================")
for(let i = 0; i<arrayList.length; i++){console.log(i);}
console.log("=======================")
for(let data1 in arrayList){console.log(data1);}
console.log("=======================")
for(let data2 of arrayList){console.log(data2);}
console.log("=======================")
arrayList.forEach((data3)=>{console.log(data3); } );
console.log("=======================")
arrayList.forEach((data4 , index4)=>{console.log(data4); console.log(index4);} );
console.log("========map1=========")
 let newArrayList = arrayList.map((data5)=>{return data5+"map";} );
 
 console.log(arrayList);
 console.log(newArrayList);
 /*
 	 카카오 개발자 센터
 	 		https://developers.kakao.com/
 			1. 애플리케이션 추가
 			2. 플렛폼 web - > 사이트 도메인 등록
 			
 			https://apis.map.kakao.com/
 */
// 1. 접속한 브라우저의 GPS 좌표 얻기 [geolocation]
/*
navigator.geolocation.getCurrentPosition(pos=>{
	console.log(pos ); 
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	 // 카카오지도 출력
 var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(lat, lng); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
    
 
});
// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

})
*/
/*
	 // 카카오지도 출력
 var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
*/
 
 
 
