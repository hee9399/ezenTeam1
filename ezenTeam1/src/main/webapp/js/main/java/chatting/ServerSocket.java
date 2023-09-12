package chatting;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.msgDto;

@ServerEndpoint("/seversokcet/{mid}") // 서버소켓 URL
public class ServerSocket {
	
	
	// 0. 접속된 클라이언트소켓의 저장소
	public static List< ClientDto >  clientList = new Vector<>();
	
	
	
	// 1. 클라이언트소켓으로부터 접속받았을때
	@OnOpen // 매개변수 : 1. 접속된 클라이언소켓(세션) 2. 접속된 회원아이디
	public void onOpen(Session session , @PathParam("mid") String mid) {
		System.out.println("클라이언트 소켓이 입장했습니다."+session);
		System.out.println("접속한 회원아이디"+mid);
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add(clientDto);
		System.out.println("접속된 클라이언트들: "+clientDto);
	}
		//2 .
		//@OnError
		public void onError (Session session) {}
		// 3. 클라이언트소켓과 서버소켓이 연결이 끊겼을때.
		@OnClose
		public void onClose(Session session) {
			// * 접석목록에서 세션 제거
			for(ClientDto clientDto : clientList ) { // 접속목록에서 연결이 끊긴 세션 찾기
				if(clientDto.getSession()==session) {
					// 클라이언트소켓의 세션과 연결이 끊긴 세션과 같으면 해당 dto를 제거하기.
					clientList.remove(clientDto);
					break;
				}
			}
		}
		
	@OnMessage // 매개변서ㅜ : 1. 메세지를 보낸 클라이언트소켓(세션) 2. 메세지 내용 [문자열]
	public void onMessage(Session session , String msg) throws Exception {
		System.out.println("보낸 클라이언트[누가]"+session+"                 보낸 내용[무엇을]: "+msg);
		// 2-2 메세지를 보낼 내용 구성,. [ 보낸사람 , 보낸내용]
		msgDto msgDto = null;
		
		for(ClientDto clientDto : clientList) {
			if(clientDto.getSession() == session) {
				// 회원목록중에 보낸세션과 일치하면
				msgDto = new msgDto(clientDto.getMid(),msg);
				break;
			}
		}
		// - msgDto 를 JSON  사용할 수있 도록 형변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonMsg = objectMapper.writeValueAsString(msgDto);
		
		// 2-1 받은 메세지를 접속된 회원들에게 모두 전송
		for(ClientDto clientDto : clientList) { // 회원목록에서 하나씩 회원 꺼내기 
			clientDto.getSession().getBasicRemote().sendText(jsonMsg); // 예외처리 필수!!!
			
		}
	}
}
/*
  
  	
  		* WebSocket 서버 소켓 라이브러리 제공
  			1. 제공소켓 클래스생성
  				- 클래스위에 서버소켓의URL 만들기
  					@ServerEndpoint("/seversokcet")
  			2. 서버소켓 메소드 제공
  				- 메소드 매개변수의 규칙 존재
  				@OnOpen
  					public void onOpen(Session session ) {}
  							- Session : 서버소켓의 접속된 클라이언트소켓 정보
				@OnClose
				@OnError
				@OnMessage
  */
