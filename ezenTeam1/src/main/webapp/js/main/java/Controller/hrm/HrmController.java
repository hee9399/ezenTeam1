package Controller.hrm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDao;
import model.dto.HrmDto;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HrmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HrmDto> result = HrmDao.getInstance().hread();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
		System.out.println(json);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getServletContext().getRealPath("/hrm/img");
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()	
				);
		
		
		
		String name = multi.getParameter("name"); System.out.println(name);
		String phone = multi.getParameter("phone");	System.out.println(phone);
		String himg = multi.getFilesystemName("himg");	System.out.println(himg);
		String position = multi.getParameter("position"); System.out.println(position);
		
		// 1. 만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = defult.webp
   		if(himg==null) {himg ="defult.webp";}
		
   		//2. 객체화
		HrmDto dto = new HrmDto(name,phone,himg,position);
		
		boolean result = HrmDao.getInstance().save(dto);
		
		
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(result);
	
}

	
	

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
