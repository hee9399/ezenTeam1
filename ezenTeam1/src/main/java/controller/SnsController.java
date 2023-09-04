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
		String spwd = multi.getFilesystemName("spwd");
		
		SnsDto snsDto = new SnsDto(sfile, scontent, spwd);
		System.out.println(snsDto);
		
		boolean result = SnsDao.getInstance().swrite(snsDto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

}

	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		
		boolean result = SnsDao.getInstance().sdelete(sno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
