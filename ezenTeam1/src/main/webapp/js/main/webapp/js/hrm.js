hread();


function save() {
	let hrmForm = document.querySelectorAll('.hrmForm')[0];
	console.log(hrmForm);
	let hrmData = new FormData(hrmForm);
	console.log(hrmData);
	$.ajax({
         url : "/jspweb/HrmController",      
         data : hrmData,      
         method : "post",  
         contentType : false,		// form 객체 전송 타입
		 processData : false, 
         success : r => {
			 	if(r) {
					 alert('저장 성공');
					 hread();
					 
				 } else {
					 alert('저장 실패[관리자 문의]');
				 }
			 },
         error : e => {console.log(e);}        
      });

}

function preimg(object){ console.log('사진 선택 변경');
	console.log(object); // 이벤트 발생시킨 태그의 DOM객체를 인수로 받음
	console.log(document.querySelector('.himg'));
	// 1. input태그의 속성 [type , class , onchange , name 등등]
	// 1. input태그 이명서 type = "file" 이면 추가적인 속성
		// .files : input type = "file" 에 선택한 파일 정보를 리스트로 받음
	console.log(object.files);
	console.log(object.files[0]); // 리스트중에서 하나의 파일만 가져오기
	
	// ------ 해당 파일을 바이트코드 변환
	// 2. JS 파일클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일 읽기 객체 선언
	// 3. 파일 읽어오기 함수 제공
	file.readAsDataURL(object.files[0]); // input에 등록된 파일리스트중(object.files) 1개를 파일객체로 읽어오기
		console.log(file);
	// 4. 읽어온 파일을 해당 html img 태그에 load
	file.onload = e => { // onload() : 읽어온 파일의 바이트코드를 불러오기
		console.log(e); // e : 이벤트 정보
		console.log(e.target); 	// onload() 실행한 FileReader 객체
		console.log(e.target.result); // 읽어온 파일의 바이트 코드
		document.querySelector('.preimg').src = e.target.result; // img src 속성에 대입
	}
	
	
}


function hread(){ 
	$.ajax({
		url : "/jspweb/HrmController",
		method : "get",
		data : "",
		success : function f(r){console.log(r); 
		
		let output = document.querySelector('.hrm_Bottom');
		let html = ``;
		
			for (let i = 0; i < r.length; i++) {
    html += `<div class="hrmbox">
                <div class="accountbox_top">
                    <div>${r[i].hno}</div>
                    <div name="himg">${r[i].himg}</div>
                    <img width ="200px" class="preimg" alt="" src="/jspweb/hrm/img/${r[i].himg}">
                    <div class="accountdate">${r[i].hname}</div>
                </div>
                <div class="accountbox_center">${r[i].hphone}</div>
                <div class="accountbox_center">${r[i].hposition}</div>
                <div class="accountbox_center">${r[i].hdate}</div>
                <div class="accountbox_bottom">
                    <button class = "button" onclick="aupdate(${r[i].hno})" type="button">등록</button>
                    <button class = "button" onclick="adelete(${r[i].hno})" type="button">삭제</button>
                </div>
            </div>`;
}

		output.innerHTML = html;
		},		
		error : function f(r){}
	});
} // f e