let rno = new URL( location.href ).searchParams.get("rno")
console.log(rno);

 $.ajax({
        url: "/ezenTeam1/AdminController",
        method: "get",
        data: { type: 2, rno: rno },
        success: r => { console.log(r);
         
        
       		 // 1. 해당 라이더에 면허증이미지 출력
			 document.querySelector('.rimg1').src=`/ezenTeam1/gorider/rider/img/${r.rlicense}`;
			 // 1. 해당 라이더에 프로필이미지 출력
			 document.querySelector('.rimg2').src=`/ezenTeam1/gorider/rider/img/${r.rphoto}`;
			 // 1. 해당 라이더에 차량등록증 출력
			 document.querySelector('.rimg3').src=`/ezenTeam1/gorider/rider/img/${r.rregistration}`;
			 // 1. 해당 라이더에 이름 출력
         	 document.querySelector('.rname').innerHTML=`이름 : ${r.rname}`;
         	 // 1. 해당 라이더에 연락처 출력
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

