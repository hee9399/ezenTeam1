package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.AdminDao;
import model.dto.RiderDto;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminController() {
       
    }

	// 1. 회원가입 간단한 정보 최신순으로 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = "";

	    ArrayList<RiderDto> result = AdminDao.getInstance().ApprovalPrint();

	    // JSON 형식으로 응답 데이터 설정
	    response.setContentType("application/json;charset=UTF-8");

	    // Java 객체를 JSON 문자열로 변환
	    json = objectMapper.writeValueAsString(result);

	    // JSON 문자열을 응답에 출력
	    response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
