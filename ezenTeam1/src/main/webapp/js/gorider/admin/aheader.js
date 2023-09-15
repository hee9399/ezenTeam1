
 function goMain(){
	 location.href='amain.jsp';
 }
 function goMenu(to){
	 
	 if(to == 'R'){
		 location.href='aRequestList.jsp'
	 } else if(to == 'S'){
		 location.href='aServiceList.jsp'
	 } else if(to == 'V'){
		 location.href='aReviewList.jsp'
	 } else if(to == 'D'){
		 location.href='aDepositList.jsp'
	 } else{
		 location.href='aClosingList.jsp'

	 }
	 
 }
 // 1. 라이더 승잉 요청 목록에 간단하기 회원가입 번호랑 라이더 id ,  요청일 뿌려주는 함수
 function ApprovalPrint(){
	 $.ajax({
      
            url : "/ezenTeam1/AdminController",   
            method : "",   
            data : {get},      
           success : r =>{
			  
			  // 1. 출력할 위치
			  let listTitle = document.querySelector('.listTitle');
			  
			  // 2. 출력할 내용 구성
			 let html = ` <li class="col10">No</li>
                <li class="col35">라이더ID</li>
                <li class="col35">요청일</li>
                <li class="col20" onclick="ApprovalView">상세보기</li>`;
		   } ,       
            error : e=>{} ,        
             
   });
 }
 
 // 1. 라이더가 회원가입했을때 그라이더에 대한 상세보기 함수.
 function ApprovalView(){
	 
 }