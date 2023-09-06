package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.SnsReplyDao;

import model.dto.SnsReplyDto;



// 링크 : /ezenTeam1/SnsReplyController

@WebServlet("/SnsReplyController")
public class SnsReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public SnsReplyController() {}

	// 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 쓰기 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String rcontent = request.getParameter("rcontent");
			String rpwd = request.getParameter("rpwd");
			
			
			SnsReplyDto replyDto = new SnsReplyDto(rcontent, rpwd, rpwd);
			
			boolean result = SnsReplyDao.getInstance().replyWrite(replyDto);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
	
	}
	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno =  Integer.parseInt(request.getParameter("rno"));
		String rpwd = request.getParameter("rpwd");
		
		boolean result = SnsReplyDao.getInstance().replyDelete(rno, rpwd);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
