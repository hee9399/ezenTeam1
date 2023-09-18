package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

// 링크 : http://localhost/ezenTeam1/MemberFindController
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberFindController() {}

    // 로그인
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		 
 		String mid = request.getParameter("mid");
 		String mpwd = request.getParameter("mpwd");
 		
 		boolean result = MemberDao.getInstance().login(mid, mpwd);
 		
 		response.setContentType(("application/json;charset=UTF-8"));
    	response.getWriter().print(result);
 		
 	}
    
 	// 아이디/이메일 중복검사 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


}
