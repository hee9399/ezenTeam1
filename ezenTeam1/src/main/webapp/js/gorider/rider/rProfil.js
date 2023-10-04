// 라이더 프로필 js
console.log('js실행됩니다.');

// - 로그인된 라이더 이름과 프로필사진이 등록되야한다. 

// 1. 라이더 식별번호 전역변수 선언 

   $.ajax({
      url : "/ezenTeam1/RiderInfoController",      
      data : {type: "info" },  // 로그인정보를 갖고있는 info 로 보낸다.  
      method : "get",   
      success : r => {console.log(r);
      
      		// 1. 해당 로그인된 라이더 프로필사진 이미지 출력
      		document.querySelector('.rphoto img').src=`/ezenTeam1/gorider/rider/img/${r.rphoto}`;
      		
      		// 2. 해당 로그인된 라이더 이름 출력 
      		document.querySelector('.rname').value =`${r.rname}`;
      		
      		
      } ,       
      error :  e => {} ,         
   });