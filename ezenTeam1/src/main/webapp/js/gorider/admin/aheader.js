
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
 function Request(){
	 console.log('Request() 실행')

	     $.ajax({
      
            url : "/jspweb/AdminController",   
            method : "get",
            data : {type : 3},      
           success: function (count) {
   
    			$(".hinfo").text("신규요청 : " + count + " 건");
		},
                          
   })
   
 }