let rno = new URL( location.href ).searchParams.get("rno")
console.log(rno);

 $.ajax({
        url: "/ezenTeam1/AdminController",
        method: "get",
        data: { type: 2, rno: rno },
        success: r => { console.log(r);
         
        
       
			 document.querySelector('.rimg1').src=`/ezenTeam1/gorider/rider/img/${r.rlicense}`;
			 document.querySelector('.rimg2').src=`/ezenTeam1/gorider/rider/img/${r.rphoto}`;
			 document.querySelector('.rimg3').src=`/ezenTeam1/gorider/rider/img/${r.rregistration}`;
         	 document.querySelector('.rname').innerHTML=`이름 : ${r.rname}`;
         	 document.querySelector('.rphone').innerHTML=`연락처 : ${r.rphone}`;	

        
        },
        error: e => {
            console.error(e);
        }
});

// 승인 거부 함수
function ondeny(){
	let rejectionReason = prompt('승인거부 사유를 알려주세요: ');
	$.ajax({
        url: "/ezenTeam1/AdminController",
        method: "post",
        data: { type: 1, rno: rno, rcomment : rejectionReason},
        success: r => { console.log(r);
        	
				location.href="/ezenTeam1/gorider/admin/aRequestList.jsp"
			
        },
        error: e => {
            console.error(e);
        }
	});
}
// 승인 함수
function onapprove(){
	$.ajax({
        url: "/ezenTeam1/AdminController",
        method: "post",
        data: { type: 2, rno: rno },
        success: r => { console.log(r);
        	
        },
        error: e => {
            console.error(e);
        }
	});
}

function serer(){
	$.ajax
	
}