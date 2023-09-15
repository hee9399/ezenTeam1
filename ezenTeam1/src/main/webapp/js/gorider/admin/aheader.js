
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
 