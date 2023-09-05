/**
 * 
 */
// 출력
onList();
function onList(){
	console.log('리스트 로드');
	
	
	$.ajax({
		url : "/ezenTeam1/SnsController",
		method : "get",
		data : { type : 1 },
		success : r => {
			let html ='';
			let cWrap = document.querySelector('.cWrap')
			
				
			r.forEach( s => {
				console.log("s" + s)
				html+= `
					<div class="contBox">
						<div class="sphoto"><img src="/ezenTeam1/sns/file/${s.sfile}"></div>
						<div class="sdate">${s.sdate}</div>
						<div class="scontent">
						${s.scontent}
						</div>
						<div class="btnbox">
							<button class="btn" onclick ="onUpdate(${s.sno})" type="button">수정</button>
							<button class="btn" onclick ="sdelete()" type="button">삭제</button>
			
						</div>	
					</div>
				
				`;
				
			});
			
			
			cWrap.innerHTML = html;
			
			
			
		} , 
		error : e => { console.log('success :: '+ e);}
	});
	
}
// 글쓰기 화면으로 이동
function onWrite(){
	location.href='/ezenTeam1/sns/snsWrite.jsp';
}