package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		System.out.println("type  :: "+ type);
		ObjectMapper objectMapper = new ObjectMapper();
		
		if(type.equals("1")) { //게시물 전체 출력
			//json으로 변환
			ArrayList<SnsDto> result = SnsDao.getInstance().snsList();
			
			json = objectMapper.writeValueAsString( result );
			
		} else if (type.equals("2")){ //게시물 1개 출력할때
			
			
		}
		
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(  json );

	}

	// 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
