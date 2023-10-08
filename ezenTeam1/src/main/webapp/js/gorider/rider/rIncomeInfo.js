console.log('list연결');

//비로그인 리턴
if(loginState== false){
	alert('로그인이 필요합니다.');
	location.href='/ezenTeam1/gorider/rider/rlogin.jsp'
}

 //리스트출력
getIncomeInfo('AD');
function getIncomeInfo(type){
	console.log("type :: "+ type);
	if(btype == 'AD'){
		document.querySelector('.btypeN').style.borderBottom  = "3px solid var(--dgray)";
		document.querySelector('.btypeN').style.backgroundColor  = "var(--dyellow)";
		document.querySelector('.btypeE').style.backgroundColor  = " #000";
		document.querySelector('.btypeE').style.borderBottom  = "3px solid #000";
		document.querySelector('.btypeE').style.color  = "var(--white)"
	}else if(btype =='ND'){
		document.querySelector('.btypeE').style.borderBottom  = "3px solid var(--dgray)";
		document.querySelector('.btypeE').style.backgroundColor  = "var(--dyellow)";
		document.querySelector('.btypeN').style.backgroundColor  = " #000";
		document.querySelector('.btypeN').style.borderBottom  = "3px solid #000";
		document.querySelector('.btypeN').style.color  = "var(--white)"

	}
	console.log("getIncomeInfo");
	//아작스함수 (출력)호출

    $.ajax({
        url:"/ezenTeam1/BoardController",
        method:"get",
        data: {type : type},

        success: r => {
            console.log(r);
            /*
             let histroyBox = document.querySelector('.histroyBox');
             let html = ``;

             r.forEach( b => {
             html +=	`<ul class="hContBox">
	            	 		<li><span class="hTitleA">운행번호</span><span class="hContent">${r.sno}</span><li>
	            	 		<li><span class="hTitleA">운행일자</span><span class="hContent"> ${r.sdate}</span><li>`
            	 if(type == 'AD'){
            		 html += ` <li><span class="hTitleA">입금일자</span><span class="hContent"> ${r.ddate}</span><li>
            		 <li><span class="hTitleA">운행수입</span><span class="hContent">  $ {r.spayment }원</span><li>`;
            	 } else{
             html+=`	<li><span class="hTitleA">예정수입</span><span class="hContent">  $ {r.spayment }원</span><li>`
            	 }
            	 html += `</ul>` ;


               });
             histroyBox.innerHTML = html;
			*/

            },
        error: e => { console.log("에러"+ e)}

    });

}

//상세보기
function onViewDetails(bno){
	console.log("onViewList");

}





























