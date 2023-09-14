package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


// 링크 : http://localhost/ezenTeam1/MemberInfoController
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public MemberInfoController() {}

    // 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String saveDirectory = request.getSession().getServletContext().getRealPath("/gorider/member/file");
    	MultipartRequest multi = new MultipartRequest(
    			request,
    			saveDirectory,
    			1024*1024*10,
    			"UTF-8",
    			new DefaultFileRenamePolicy()
    	);
    	// alter table tbl_query add qe_answer08 int comment '코멘트 제목')
    	//DB저장
    	String mname = multi.getParameter("mname");
    	String mid = multi.getParameter("mid");
    	String mpwd = multi.getParameter("mpwd");
    	String memail=multi.getParameter("memail");
    	String mpayinfo=multi.getParameter("mpayinfo1")
    			+ multi.getParameter("mpayinfo2")
    			+ multi.getParameter("mpayinfo3")
    			+ multi.getParameter("mpayinfo4");

    	System.out.println("mname ::"+mname);
    	System.out.println("mid ::"+mid);
    	System.out.println("mpwd ::"+mpwd);
    	System.out.println("memail ::"+memail);
    	System.out.println("mpayinfo ::"+mpayinfo);

    	MemberDto memberDto = new MemberDto(mname,mid,mpwd,memail, mpayinfo);
    	boolean result = MemberDao.getInstance().signup(memberDto);

    	response.setContentType(("application/json;charset=UTF-8"));
    	response.getWriter().print(result);





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
