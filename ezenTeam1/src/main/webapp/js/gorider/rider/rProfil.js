// 라이더 프로필 js
console.log('js실행됩니다.');

// - 로그인된 라이더 이름과 프로필사진이 등록되야한다. 

// 1. 라이더 식별번호 전역변수 선언 
let rno = new URL( location.href ).searchParams.get("rno");
console.log(rno);

   $.ajax({
      url : "/ezenTeam1/RiderInfoController",      
      data : {type: "rphoto" , rno: rno},      
      method : "put",   
      success : r => {console.log(r);
      
      		// 1. 해당 로그인된 라이더 프로필사진 이미지 출력
      		document.querySelector('.rphoto').src=`/ezenTeam1/gorider/rider/img/${r.rphoto}}`;
      		
      		// 2. 해당 로그인된 라이더 이름 출력 
      		document.querySelector('.rname').src=`/ezenTeam1/gorider/rider/img/${r.rname}`;
      		
      } ,       
      error :  e => {} ,         
   });