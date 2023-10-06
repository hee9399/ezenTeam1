package controller.rider;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.RiderDao;
import model.dto.MemberDto;
import model.dto.RiderDto;

// 링크 : http://localhost/ezenTeam1/RiderInfoController
@WebServlet("/RiderInfoController")
public class RiderInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RiderInfoController() {}
    
    // 저장
    // 1. 첨부파일 있을때 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 도착");
    	
		// 첨부파일 있을때 회원가입
		String uploadpath = request.getSession().getServletContext().getRealPath("/gorider/rider/img");
		System.out.println("rider 폴더 img 폴더 실제(서버) 경로 : "+uploadpath);
		
		// 첨부파일 전송 했을때 
			// 1. 첨부파일 서버pc에 업로드 
		MultipartRequest mulit = new MultipartRequest(
				request, 		// 1. 요청방식 
				uploadpath ,	// 2. 첨부파일을 저장할 폴더 경로
				1024*1024*10 ,  // 3. 첨부파일 용량 허용 범위 [ 바이트단위 ]
				"UTF-8" ,
				new DefaultFileRenamePolicy() // 5. [ 파일명중복제거 ]
			);
		
	// 2. from 안에 있는 각 데이터 호출 
		//  rname , rid , rpwd , rphoto , rlicense ,  rregistration , raccount , rbank 
		// 1. ajax 통신받은 data객체의 '속성명' 요헝한다. 
			// 이름
		String rname = mulit.getParameter("rname");     			System.out.println("rname: "+rname);
			// 아이디
		String rid = mulit.getParameter("rid"); 	    			System.out.println("rid: "+rid);
			// 비밀번호
		String rpwd = mulit.getParameter("rpwd"); 					System.out.println("rpwd: "+rpwd);
			// 라이더 전화번호 
		String rphone = mulit.getParameter("rphone"); 				System.out.println("rphone: "+rphone);
			// 프로필사진 
		String rphoto = mulit.getFilesystemName("rphoto");   			System.out.println("rphoto: "+rphoto);	
			// 면허증 
		String rlicense = mulit.getFilesystemName("rlicense");			System.out.println("rlicense: "+rlicense);
			// 차량등록증 
		String rregistration = mulit.getFilesystemName("rregistration"); System.out.println("rregistration: "+rregistration);
			// 계좌번호
		String raccount = mulit.getParameter("raccount"); 			System.out.println("raccount: "+raccount);
			// 은행명 
		String rbank = mulit.getParameter("rbank");					System.out.println("rbank: "+rbank);
			// 라이더 차량번호
		String rbikenum = mulit.getParameter("rbikenum"); 			System.out.println("rbikenum: "+rbikenum);
		
		// 2. 객체화
			// 입력받을 dto 설계 부르기 
		RiderDto riderDto = new RiderDto(rname, rid, rpwd, rphone, rphoto, 
				rlicense, rregistration, raccount, rbank, rbikenum);
		
		// 3. Dao 객체 전달후 결과 응답받기 
		boolean result = RiderDao.getInstance().RiderSignup(riderDto);
		
		// 4. 결과를 ajax에게 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
    }
    
    // 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// 1. 요청
		String type = request.getParameter("type");
			// * 만약에 타입이 info이면 
		if(type.equals("info") ) {
			// 섹션에 저장된 로그인 객체를 꺼낸다.
			// 1. 세션호출한다. [ 세션타입은 object ]
			Object session = request.getSession().getAttribute("loginDto");
			// 2. 타입변환한다. [ 부모 -> 자식 ( 캐스팅 / 강제타입변환 ) ]

			if (session instanceof RiderDto) {
			    RiderDto riderDto = (RiderDto) session;
			    ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(riderDto);
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(json);
			    // RiderDto로 형변환된 객체를 사용할 수 있습니다.
			} else if (session instanceof MemberDto) {
			    MemberDto memberDto = (MemberDto) session;
			    ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(memberDto);
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(json);
			    // MemberDto로 형변환된 객체를 사용할 수 있습니다.
			} else {
			    // 다른 타입의 객체일 경우 처리할 코드를 작성하세요.
			}

			System.out.println(session);

			RiderDto loginDto = (RiderDto) session ;
			
			System.out.println(loginDto);
			

		// Dto는 JS가 이해살수 없는 언어이기 때문에 JS가 이해할수 있게 JS언어로 변환해줘야한다. [ jackson 라이브러리사용 ]
			
			 
			// 응답한다.
			
			
		}else if(type.equals("logout") ) {
			// * 세션에 저장된 로그인 객체를 없애기/초기화/지우기/삭제 
			// 방법 : (세션 특정 속성) 초기화하는 방법 jvm GC(쓰레기수집기 = 해당 객체를 아무도 참조하고 있지 않으면) 
			request.getSession().setAttribute("logout", null);
			
		}
		
	}

	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPut시작");
		
		// 1. 첨부파일 서버pc에 업로드( COS.jar 라이브러리 )
		MultipartRequest multi = new MultipartRequest(
			request, 	// 1. 요청방식
			request.getServletContext().getRealPath("gorider/rider/img") , // 2. 첨부파일을 저장할 경로
			1024 * 1024 * 10 ,		// 3. 첨부파일 용량 허용 번위 [ 바이트 단위 ] 10mb
			"UTF-8" ,			// 4. 한글 인코딩타입 
			new DefaultFileRenamePolicy()
			);
		System.out.println("multi도착"+multi);
		
		// Dao [ 로그인된 라이더번호 , 수정할 값 ]
		Object object = request.getSession().getAttribute("loginDto");
		RiderDto riderDto = (RiderDto)object;
		int rno = riderDto.getRno();
		
		
		String change = multi.getFilesystemName("change");
		
		System.out.println("change: "+change);
		
		String type = null;
		String value = null;
		
		if(change.equals("프로필사진") ) { // 프로필사진수정할경우
			System.out.println("프로필사진if: ");
			
					
			
			type = "rphoto";
			value = multi.getFilesystemName("rphoto");
			
		}else if(change.equals("라이더차량번호") ) { // 라이더 차량번호 수정할경우
			
			type = "rbikenum";
			value = request.getParameter("rbikenum");
			
		}else if(change.equals("계좌번호")) {
			
			
		}
		
		System.out.println("컨트롤러type: "+type);
		
		boolean result = RiderDao.getInstance().rupdate(rno , type , value);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		}// doPut e
		

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
