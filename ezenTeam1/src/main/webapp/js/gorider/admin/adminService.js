// 서비스 이용 현황 함수
function ServiceStatus(){
	    $.ajax({
      
            url : "/jspweb/AdminController",   
            async : false ,
            method : "get",
            data : {type : 4},      
           success : r=>{
			   let listbox =document.querySelector('.listbox');
			   let html =`<ul class="listTitle rlistR">
               						 <li class="col15">R번호</li>
                					<li class="col15">S번호</li>
                					<li class="col10">★</li>
               						<li class="col40">리뷰</li>
                					<li class="col20">서비스일자</li>
          					 </ul>`;
          					 
          					 for(let i=0; i<r.length; i++){
								    html += `
						               	 <ul class="listContent rlistC">
						                    <li class="col10">${rno}</li>
						                    <li class="col35">${rid}</li>
						                    <li class="col35">${rdate}</li>
						                    <li class="col20"><button class="btnPd6" type="button" onclick="ApprovalView(${rno})">상세보기</button></li>
						                </ul>`;
							   }
			   } ,
                          
   });
   
}