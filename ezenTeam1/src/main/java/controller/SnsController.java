package controller;

import java.io.IOException;

import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.fasterxml.jackson.databind.ObjectMapper;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import model.dao.SnsDao;
import model.dto.SnsDto;




/**
 * Servlet implementation class SnsController
 */



@WebServlet("/SnsController")
public class SnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SnsController() {}

	// 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		String type = request.getParameter("type");
		String json = null;
		System.out.println("type >>  :: "+ type);
		ObjectMapper objectMapper = new ObjectMapper();
		
		if(type.equals("1")) { //게시물 전체 출력
			//json으로 변환
			ArrayList<SnsDto> result = SnsDao.getInstance().snsList();
			System.out.println(result);
			
			json = objectMapper.writeValueAsString( result );
			
		} else if (type.equals("2")){ //게시물 1개 출력할때
			
			
		}
		
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(  json );

	}

	// 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/sns/upload"),
				1024*1024*1024, // 1GB
				"UTF-8",
				new DefaultFileRenamePolicy() // 만약에 업로드파일명이 서버내 존재하면 (중복) 자동으로 파일명뒤에 숫자 붙이기
				);
		System.out.println(request.getServletContext().getRealPath("/sns/upload"));
		
		// 1. (입력받은 매개변수) 요청
		String sfile = multi.getFilesystemName("sfile");
		String scontent = multi.getParameter("scontent");
		String spwd = multi.getParameter("spwd");
		
		SnsDto snsDto = new SnsDto(sfile, scontent, spwd);
		System.out.println(snsDto);
		
		boolean result = SnsDao.getInstance().swrite(snsDto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

}

	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컨트롤러 수정 도착");
		
		// 1. 수정할 첨부파일 업로드 
				MultipartRequest multi = new MultipartRequest(
						request, 
						request.getServletContext().getRealPath("/board/upload") ,
						1024 * 1024 * 1024 ,
						"UTF-8" ,
						new DefaultFileRenamePolicy() 
						);
		// 2. 수정할 데이터 요청 
		int sno = Integer.parseInt( multi.getParameter("sno") );
		String sfile = multi.getFilesystemName("sfile");
		String scontent = multi.getParameter("scontent");
		
		// sno를 보낸다 
		SnsDto updateDto = new SnsDto(sno, sfile, scontent);
		
		System.out.println("수정할dto"+updateDto);
		
		if( updateDto.getSfile() == null ) {
			
			
			
		}
		
		// 3. DAO
		boolean result = SnsDao.getInstance().snsUpdate(updateDto);
		// 4. 응답 
		response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
		
	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		String spwd = request.getParameter("spwd");
		boolean result = SnsDao.getInstance().sdelete(sno,spwd);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
