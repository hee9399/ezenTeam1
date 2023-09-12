package Controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberFindController() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 매개변수 요청
		String mid = request.getParameter("mid"); System.out.println(mid);
		String mpwd = request.getParameter("mpwd"); System.out.println(mpwd);
		
		// 2. (객체화/유효성검사)
		
		// 3. DAO 에게 전달후 결과 받기
		boolean result =MemberDao.getInstance().login(mid, mpwd);
		
		
		// - 만약에 로그인 성공하면 세션에 로그인한 정보를 담기 ...
					if(result==true) {
						// 1. 세션에 저장할 데이터를 만든다.
						MemberDto loginDto = MemberDao.getInstance().info(mid);
						// 2. 세션에 저장한다.
						request.getSession().setAttribute("loginDto", loginDto);
						
						MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
						System.out.println("세션상태 :"+dto);
					}
		
		
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result); // "true"
	}
	
	// 하나의 메소드의 여러개 ajax 통신할때. type전송( 숫자 1:아이디중복검사 2.이메일중복검사 vs 필드명  mid : 아이디중복검사 , memail : 이메일중복검사 )  
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 1. 요청한다.
			String type = request.getParameter("type");
			String data = request.getParameter("data");
			// 2. 객체화/유효성검사
			// 3. DAO 요청 결과 
			boolean result = MemberDao.getInstance().findIdOrEmail( type , data);
			
			
			
			
			// 4. 결과 응답한다. 
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
		}
		
	}



/*
	- 저장소
		1. JAVA/JS 일반 메모리
			- JAVA 종료되거나 JS 종료되면 휘발성/초기화/사라짐
			- DTO 이동객체 , 로직 필요한 변수들 (생성조건에 따라 사용범위가 다름)
		2. DB 메모리
			- 영구 저장 [ 논리구조(관계형/표) 저장 ]
			- 회원정보,게시판정보,제품정보 등등
		3. 파일
			- 영구 저장 [ 문자열 저장 ]
			- 로그/기록	(예외처리 오류 정보, 접속수 , 최상위 보안 자료 등등) 
			- 실제 데이터
		4. 세션( static ) :
			- 장점 : 모든 곳에서 동일한 메모리 사용
			- 단점 : 프로그램/서버 가 종료될때까지 유지 (메모리)
			- 로그인정보 : 페이지전환 되더라도 로그인 상태 유지
		
	로그인 했다는 증거 => 인증 [ 인증서 -> 세션 저장 ]
	
		JS : sessionStroage
			세션타입 : 문자열 타입 (타입변환 필수!)
			세션저장 :sessionStroage.setItem(키,데이터)
			세션호출 :sessionStroage.setItem(키)
		JAVA(서블릿) : request.getSession() : 모든 서블릿 에서 사용가능한 메모리 공간
			세션타입 : Object
			세션저장 :request.getSession().setAttribute("속성명",데이터);
			세션호출 :request.getSession().getAttribute("속성명");
	서블릿
		내장객체
				request : 요청객체
						request.getParmeter()	: ajax 으로 부터 전달된 데이터 요청			: ajax으로부터 전달받은 데이터요청
					 	request.getServletContext().getRealPath("/Member/img")	: 서블릿 저장소의 실제(c:) 경로 검색
					 	request.getSession()													: 서버내 세션 객체 호출
				response	: 응답객체
					response.getWriter().print() 	: ajax에게  전달할 데이터 요청				[ 데이터 타임 설정]
					response.setContentType("application/json;charset=UTF-8");		[ 데이터 타임 설정]


*/