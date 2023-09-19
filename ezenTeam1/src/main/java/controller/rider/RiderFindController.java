package controller.rider;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RiderDao;
import model.dto.RiderDto;


// 링크 : http://localhost/ezenTeam1/RiderFindController
@WebServlet("/RiderFindController")
public class RiderFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RiderFindController() {}

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 1. js매개변수 요청 
    	String rid = request.getParameter("rid"); System.out.println("rid: "+rid);
    	String rpwd = request.getParameter("rpwd"); System.out.println("rpwd: "+rpwd);
    	
    	
    	// 3. Dao 에게 전달후 결과 받기 
    	boolean result = RiderDao.getInstance().Riderlogin(rid, rpwd);
    	
    	// * 만약에 로그인 성공하면 세션에 로그인한 정보를 담기 
    	if(result == true) {
    		
    		// 1. 세션에 저장할 데이터를 만든다.
    		// RiderDto loginDto = RiderDao.getInstance()
    		
    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
