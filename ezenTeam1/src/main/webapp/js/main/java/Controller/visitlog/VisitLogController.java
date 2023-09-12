package Controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitDto;


@WebServlet("/VisitLogController") // 해당 서블릿(자바) 컨트롤러 클래스 호출하는 
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisitLogController() {
        
    }
    //1. 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX의 DATA 속성에 있는 객체 정보 (속석명이용) 를 요청하기
		String vwriter = request.getParameter("vwriter"); 		System.out.println("vwriter : "+vwriter);
		String vpwd =  request.getParameter("vpwd");				System.out.println("vpwd : "+vpwd);
		String vcontent =  request.getParameter("vcontent");	System.out.println("vcontent : "+vcontent);
		// 2. 객체화
		VisitDto visitDto = new VisitDto(vwriter,vpwd,vcontent); System.out.println("visitDto : "+visitDto);
		
		// 3. DAO 객체 전달후 결과 응답받고
		boolean result = VisitDao.getInstance().vwrite(visitDto);
		
		// 4. 결과를 AJAX에게 응답한다.
		//response.getWriter().print("응답할데이터")
		// response.setContentType("text/html;charset=UTF-8");
		// response.setContentType("application/json;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		
	}
	// 2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [X] : 모든 글 출력은 조건이 없으므로 요청 값이 없다. VS 개별 글 출력: 조건이 출력할 글 번호 
		
		// 2. 객체화 [X]
		
		// 3. DAO
		ArrayList<VisitDto> result = VisitDao.getInstance().vread();
			// * js는 ArrayList타입을 사용할수 없으므로 ArrayList json 으로 변환해서 전달하자.[라이브러리 :jackson ]
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
			System.out.println(jsonArray);
		// 4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}
	
	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.데이터 요청한다.
			//request.getParameter("속성명"); String 변환
		int vno = Integer.parseInt(request.getParameter("vno")); System.out.println("vno: "+vno);
		String vcontent = request.getParameter("vcontent");	System.out.println("vcontent "+vcontent);
		String vpwd = request.getParameter("vpwd");				System.out.println("vpwd: "+vpwd);
		// 2. (데이터 많으면)객체화
		// 3. Dao 에게 전달로 SQL결과를 받는다.
		boolean result =VisitDao.getInstance().vupdate(vno, vcontent, vpwd);
		// 4. 결과를 AJAX 에게 전달한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vno = Integer.parseInt(request.getParameter("vno")); System.out.println("vno: "+vno);
		String vpwd = request.getParameter("vpwd");					System.out.println("vpwd: "+vpwd);
		
		boolean result = VisitDao.getInstance().vdelete(vno, vpwd);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	/*  - HTTP서블릿클래스는 기본적으로 get,psot,put,delete 함수 제공
	 	- 기본 톰캣서버는 get,post만 매개변수(데이터) 전달 가능
	 	- put, delete 함수도 매개변수 전달 가능하도록 설정[서버마다]
	 	sever.xml
	 		63줄쯤 원본 코드
	 			<Connector connectionTimeout="20000" maxParameterCount="1000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
	 		put,delete 에도 매개변수 전달가능하도록 코드 설정
	 			<Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8"/>
	 			
	 		
	  */
	 
}
