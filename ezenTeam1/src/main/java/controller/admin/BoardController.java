package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 2. 공지사항/이벤트 등록
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.저장경로 지정
		String uploadPath = request.getServletContext().getRealPath("/board/bfiles");

		// 2. 디스크파일아이템팩토리  객체 생성
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();

		//2-1 생성된 객체에 옵션set하기
		itemFactory.setRepository(new File(uploadPath)); 	//저장위치
		itemFactory.setSizeThreshold(1024*1024-1024);		//용량
		itemFactory.setDefaultCharset("UTF-8");				//한글인코딩

		//3 ServletFileUpload객체생성, itemFactory매개값 전달
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);

		try {
			//업로드된 파일명을 저장할 map컬렉션
			Map<Integer,String> imgList = new HashMap<>();

			//폼데이터에 저장된 모든 태그의 값들을 List컬렉션으로 저장
			List<FileItem> fileList = fileUpload.parseRequest(request);

			//업로드
			int i = 0;
			for(FileItem item:fileList) {
				item.write(new File(uploadPath));
				//일반필드이면
				if(item.isFormField()) {

				} else {//파일필드면
					//파일이름 가져오기 : itetm.getName();
					System.out.println( "업로드할 파일명 : " + item.getName() ); // .getName()

					//파일명 UUID로 식별id만들기
					UUID uuid = UUID.randomUUID();
					// 파일명에 "-"하이픈이 있으면 "_"언더바로 바꿔주고 uuid합쳐
					String filename = uuid+"-"+item.getName().replaceAll("-","_");

					//파일업로드 경로를 파일경로+파일명으로 파일타입설정
					File fileUploadPath = new File(uploadPath + "/" + filename);
					item.write(fileUploadPath);
					i++;

					imgList.put(i, filename);

				}
			}
			//BoardDto에 담기
			BoardDto boardDto = new BoardDto(
					  fileList.get(0).getString()
					, fileList.get(1).getString()
					, fileList.get(2).getString()
					, fileList.get(3).getString()
					, fileList.get(4).getString()
					, fileList.get(5).getString()
					, imgList);

			System.out.println(boardDto);
			boolean result = BoardDao.getInstance().save(boardDto);

			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(result);
		} catch (Exception e) {
			e.getStackTrace();
		}





	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
