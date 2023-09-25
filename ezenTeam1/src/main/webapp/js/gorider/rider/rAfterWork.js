
console.log('rAfterWork.js');

let callstate = 'Y';
function goWork(){

	/* riderState 테이블 업데이트 후 */arguments
	location.href = '/ezenTeam1/gorider/rider/rWorking.jsp'


}

function outWork(){

	/* riderState 테이블 업데이트 후 */arguments
	window.close();


}
function onMove(to){

	if(to == 'myMenu'){
		location.href = '/ezenTeam1/gorider/rider/rMyMenu.jsp';
	} else if(to == 'goBack'){
		window.history.back();
	}else if(to == 'callList'){
		location.href = '/ezenTeam1/gorider/rider/rCallListg.jsp'
	}




}
let currentIndex = 0;
var colors = ['#EBC12F',  '#90772B', '#4D421B' ]
function changeColor() {

    console.log(colors[currentIndex]);
    document.querySelector('.dot1').style.color = colors[currentIndex];
	document.querySelector('.dot2').style.color = colors[Math.abs(currentIndex-1)];
	document.querySelector('.dot3').style.color = colors[Math.abs(currentIndex-2)];

	currentIndex = (currentIndex + 1) % colors.length;
}
setInterval(changeColor, 800);








