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
import model.dto.ServiceDto;


@WebServlet("/AdminServiceControoler")
public class AdminServiceControoler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminServiceControoler() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = "";
	    if(type.equals("1")) {
	    	ArrayList<ServiceDto> result = AdminDao.getInstance().ServicePrint();
	    	  response.setContentType("application/json;charset=UTF-8");

	  	    // Java 객체를 JSON 문자열로 변환
	  	    json = objectMapper.writeValueAsString(result);

	  	    // JSON 문자열을 응답에 출력 
	  	    response.getWriter().print(json);
	  	    
	    }else if(type.equals("2")){
	    	ArrayList<ServiceDto> result=AdminDao.getInstance().getServiceUsageStatus();
	    	 response.setContentType("application/json;charset=UTF-8");

		  	    // Java 객체를 JSON 문자열로 변환
		  	    json = objectMapper.writeValueAsString(result);

		  	    // JSON 문자열을 응답에 출력 
		  	    response.getWriter().print(json);
		  	    
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
