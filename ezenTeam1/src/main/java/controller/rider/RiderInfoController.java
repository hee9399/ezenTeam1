package controller.rider;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 링크 : http://localhost/ezenTeam1/RiderInfoController
@WebServlet("/RiderInfoController")
public class RiderInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RiderInfoController() {}

    // 저장
    // 1. 첨부파일 있을때 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 도착");
    	
		// 첨부파일 있을때 회원가입
		String uploadpath = request.getSession().getServletContext().getRealPath("rider/img");
		System.out.println("rider 폴더 img 폴더 실제(서버) 경로 : "+uploadpath);
		
		// 첨부파일 전송 했을때 
			// 1. 첨부파일 서버pc에 업로드 
		MultipartRequest mulit = new MultipartRequest(
				request, 		// 1. 요청방식 
				uploadpath ,	// 2. 첨부파일을 저장할 폴더 경로
				1024*1024*10 , // 3. 첨부파일 용량 허용 범위 [ 바이트단위 ]
				"UTF-8" ,
				new DefaultFileRenamePolicy() // 5. [ 파일명중복제거 ]
				);
	// 2. from 안에 있는 각 데이터 호출 
		//  rname , rid , rpwd , rphoto , rlicense ,  rregistration , raccount , rbank 
		// 1. ajax 통신받은 data객체의 '속성명' 요헝한다. 
			// 이름
		String rname = mulit.getParameter("rname");     			System.out.println("rname"+rname);
			// 아이디
		String rid = mulit.getParameter("rid"); 	    			System.out.println("rid"+rid);
			// 비밀번호
		String rpwd = mulit.getParameter("rpwd"); 					System.out.println("rpwd"+rpwd);
			// 프로필사진 
		String rphoto = mulit.getParameter("rphoto");   			System.out.println("rphoto"+rphoto);	
			// 면허증 
		String rlicense = mulit.getParameter("rlicense");			System.out.println("rlicense"+rlicense);
			// 차량등록증 
		String rregistration = mulit.getParameter("rregistration"); System.out.println("rregistration"+rregistration);
			// 계좌번호
		String raccount = mulit.getParameter("raccount"); 			System.out.println("raccount"+raccount);
			// 은행명 
		String rbank = mulit.getParameter("rbank");					System.out.println("rbank"+rbank);
		
		// 2. 객체화
    
		// 3. Dao 객체 전달후 결과 응답받기 
		
    }
    
    // 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
