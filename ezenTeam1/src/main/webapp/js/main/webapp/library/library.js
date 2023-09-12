
let lno="";


function getValue(button) {
    lno = button.textContent;
    alert("눌린 버튼의 값: " + lno+"번입니다.");
}



function admission() {
    let nameInput = document.querySelector('.name');
    let phoneInput = document.querySelector('.phone');
	
	 let name = nameInput.value;
   	 let phone = phoneInput.value;
	
	 if (name === "" || phone === "" || lno === "") {
        alert('안내] 모든 정보를 입력해주세요.');
        return; // 입력되지 않은 정보가 하나라도 있으면 입실 불가능
    }
    
    
   
    let info = {
        lno: lno, // 이미 선언된 전역 변수 lno 사용
        name: nameInput.value,
        phone: phoneInput.value,
    };

    console.log(info);

     $.ajax({
	      url : "/jspweb/library", 
	      method : "post",      
	      data : info ,
	      success : function f(r){console.log( r );
	      	if( r === "true"){alert('입실 성공'); lno=0; nameInput=""; phoneInput ="";}
	      	else{alert('안내] 이미 있는 방번호입니다. 다른 방번호를 눌러주세요!!!')}
	      
	      } ,       
	      error : function f( r ){}       
	   });
}

