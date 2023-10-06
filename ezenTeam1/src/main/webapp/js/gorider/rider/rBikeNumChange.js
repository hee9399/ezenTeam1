console.log('js실행됩니다.');


// 1. 라이더 차량번호 출력
$.ajax({
      url : "/ezenTeam1/RiderInfoController",      
      data : { type: "info" },      // 로그인정보를 갖고있는 info 로 보내서 차량번호 정보를 가져온다.
      method : "get",   
      success : r => { console.log(r);
		  
		  // 1. 로그인된 라이더 차량번호 출력 
		  document.querySelector('.rBikeChange').value = `${r.rno}`;
		  
		  // document.getElementById("id명")
		  // getelementsbyclassname("class명")
		  
		  	// vs  vs  vs  vs vs vs 
		  	
		  // document.querySelector("#id명")
		  // document.querySelector(".class명")
		  
	  } ,       
      error : e => {} ,         
   });



// 1. 차량번호 수정함수 
function rBikeNumChange(){
	
	$.ajax({
      url : "/ezenTeam1/RiderInfoController",      
      data : { 'type': "라이더차량번호" },
      method : "put",   
      success : r => { console.log(r);
		  
		  if(r == true){
			  alert('차량번호 수정했습니다.')
		  }else{
			  alert('차량번호 수정 실패했습니다.')
		  }
		  
	  } ,       
      error : e => {} ,         
   });
	   
	
	
}//f e

