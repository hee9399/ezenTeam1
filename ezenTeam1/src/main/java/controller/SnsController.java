package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}

	// 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		
		boolean result = SnsDao.getInstance().sdelete(sno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
