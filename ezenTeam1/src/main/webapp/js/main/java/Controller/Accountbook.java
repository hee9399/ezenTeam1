package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.AccountbookDao;
import model.dto.AccountbookDto;

@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Accountbook() {
        super();
        
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String acontent = request.getParameter("acontent"); 
		System.out.println(acontent);
		int aprice = Integer.parseInt(request.getParameter("aprice")) ;
		System.out.println(aprice);
		String adate = request.getParameter("adate");
		System.out.println(adate);
		
		//객체화
		AccountbookDto accountbookDto  = new AccountbookDto(acontent,aprice,adate);
		System.out.println(accountbookDto);
		boolean result = AccountbookDao.getInstanct().awriter(accountbookDto);
		
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
	}
    
    //출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AccountbookDto> result = AccountbookDao.getInstanct().aread();
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray= mapper.writeValueAsString(result); 
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		System.out.println(jsonArray);
	}

	

	//수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano")) ;System.out.println("ano :"+ano);
		String acontent = request.getParameter("acontent"); System.out.println("acontent :"+acontent);
		int aprice = Integer.parseInt(request.getParameter("aprice")) ;System.out.println("aprice :"+ano);
		String adate = request.getParameter("adate"); System.out.println("adate :"+adate);
		boolean result = AccountbookDao.getInstanct().aupdate(ano,acontent,aprice,adate);
		response.setContentType("applicateion/json; charset=UTF-8");
		response.getWriter().print(result);
	}

	//삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		boolean result = AccountbookDao.getInstanct().adelete(ano);
		response.setContentType("applicateion/json; charset=UTF-8");
		response.getWriter().print(result);
	}

}