console.log("js시작")
//1.등록
function awriter() {
	console.log('awriter')
	let acontent = document.querySelector('.acontent');
	let aprice = document.querySelector('.aprice');
	let adate = document.querySelector('.adate');

	let info = {
		acontent: acontent.value, aprice: aprice.value,
		adate: adate.value
	};
	console.log(info)

	$.ajax({
		url: "/jspweb/Accountbook",
		method: "post",
		data: info,
		success: function f(r) {
			console.log("통신완료")
			
			if (r == true) {alert('입력값이 저장되었습니다.');aview();}
			else alert('입력오류')
		},
		error: function f(r) { console.log(r) }
	})
}
aview();
//2.출력
function aview() {
	$.ajax({
		url: "/jspweb/Accountbook",
		method: "get",
		data: "",
		success: function f(r) {
			console.log("출력")

			let output = document.querySelector(".aBottom")
			let html = ``;
			for (let i = 0; i < r.length; i++) {
				html += `<div class = "aBottom"><!--아래 출력구역  -->
		<div class="abox">
			<div class="aBt_content">${r[i].acontent}</div>
			<div class="aBt_price">${r[i].aprice}</div>
			<div class="aBt_date">${r[i].adate}</div>
			<button onclick="aupdate(${r[i].ano});" type="button">수정</button>
			<button onclick="adelete(${r[i].ano});" type="button">삭제</button>
		</div>
	</div>`
			}
			output.innerHTML=html;
		},
		error: function f(r) { }
	})
}




//3.수정
function aupdate(ano) {
	//1. 수정내용 입력받기
	let acontent = prompt('수정할 가계부 내용 :')
	//시간남으니 날짜와 금액도 수정하는 코드
	let aprice = prompt('수정할 금액 : ')
	let adate = prompt('수정할 날짜 :')

	$.ajax({
      url : "/jspweb/Accountbook",
      method : "put",
      data :{ ano : ano ,acontent:acontent ,aprice:aprice,adate:adate} ,
      success : function f(r){
		  if(r==true){alert("가계부 수정완료"); aview();}
		  else{alert("오류")}
	  } ,
      error : function f(r){}
   })
}




//4.삭제
function adelete(ano) {
	console.log("삭제")
	$.ajax({
      url : "/jspweb/Accountbook",
      method : "delete",
      data : {ano:ano},
      success : function f(r){
		  if(r==true){alert("가계부 삭제완료"); aview();}
		  else{alert("오류")}
	  } ,
      error : function f(r){}
   })
}