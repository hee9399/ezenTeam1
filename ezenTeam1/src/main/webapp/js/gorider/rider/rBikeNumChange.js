console.log('js실행됩니다.');


// 1. 라이더 차량번호 출력
$.ajax({
      url : "/ezenTeam1/RiderInfoController",      
      data : { type: "info" },      // 로그인정보를 갖고있는 info 로 보내서 차량번호 정보를 가져온다.
      method : "get",   
      success : r => { console.log(r);
		  
		  // 1. 로그인된 라이더 차량번호 출력 
		  document.querySelector('.rBikeChange').value = `${r.rbikenum}`;
		  
		  // 2. 로그인된 라이더 은행이름 출력 
		  document.querySelector('.rbankinfo').value = `${r.rbank}`;
		  
		  // 3. 로그인된 라이더 계좌번호 출력 
		  document.querySelector('.raccountinfo').value = `${r.raccount}`;
		  
		  // document.getElementById("id명")
		  // getelementsbyclassname("class명")
		  
		  	// vs  vs  vs  vs vs vs 
		  	
		  // document.querySelector("#id명")
		  // document.querySelector(".class명")
		  
	  } ,       
      error : e => {} ,         
   });



// 1. 차량번호 , 계좌번호 수정함수 
function rBikeNumChange(){
	
	// 1. from 객체 호출
	let rNumChange = document.querySelectorAll('.rNumChange')[0];
		console.log('from객체 호출 했습니다.'+rNumChange);
		
	// 2. from 데이터 객체화 
	let rNumData = new FormData(rNumChange);
		console.log(rNumData);
		
	// 3. 차량번호 , 계좌번호 수정 타입으로 보내기 
	rNumData.append('type' , '라이더차량번호');
	rNumData.append('type' , '라이더계좌번호');
		
	$.ajax({
      url : "/ezenTeam1/RiderInfoController",      
      data : rNumData ,
      method : "put",   
      success : r => { console.log(r);
		  
		  if(r == true){
			  alert('차량번호 수정했습니다.');
		  }else{
			  alert('차량번호 수정 실패했습니다.');
		  }
		  
	  } ,       
      error : e => {} ,         
   });
	   
	
	
}//f e

