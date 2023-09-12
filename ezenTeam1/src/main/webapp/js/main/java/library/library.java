package library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.libraryDao;
import model.dto.libraryDto;

/**
 * Servlet implementation class library
 */
@WebServlet("/library")
public class library extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public library() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
  }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lno = Integer.parseInt(request.getParameter("lno")); System.out.println(lno);
		String name = request.getParameter("name"); System.out.println(name);
		String phone = request.getParameter("phone"); System.out.println(phone);
		
		
		libraryDto dto = new libraryDto(lno,name,phone);
		
		boolean result = libraryDao.getInstance().lwriter(dto);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. AJAX data 데이터 요청한다.
           int lno = Integer.parseInt(request.getParameter("lno"));
           // 2. (데이터 많으면)객체화
           // 3. Dao에게 전달후 SQL결과를 받는다.
           boolean result = libraryDao.getInstance().ldelete(lno);
           // 4. 결과를 AJAX에게 전달한다.
           response.setContentType("application/json; charset=UTF-8");
           response.getWriter().print(result);   
  }

}
