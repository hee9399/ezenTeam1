package controller.rider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.CallDao;

import model.dto.ServiceDto;


@ServerEndpoint("/callsocket")
public class CallSocket {
	
	public static List<Session> callList = new ArrayList<>(); 
	public static List<Session> riderlist = new ArrayList<>();
	
	

	// 세션을 라이더 또는 사용자로 식별하는 메서드
	private boolean isRider(Session session) {
	    // 세션에서 "userType" 속성 값을 가져옵니다.
	    String userType = (String) session.getUserProperties().get("userType");

	    // "userType" 속성이 "rider"인 경우 라이더로 식별합니다.
	    return "rider".equals(userType);
	}
	
	@OnOpen
	public void OnOpen( Session session ) {
		
		if(isRider(session)) {
			riderlist.add(session);
		} else  {
			callList.add(session);
		}
		
		
		
		// 접속했을때 라이더인지 사용자인지 식별
			// 1. 서로 다른 접속명단 리스트 2개 사용
			// 2. Map컬렉션을 이용해서 < 라이더 , [] >   < 사용자 , [] >
		
		callList.add(session);
		System.out.println( session );
	}
	
	
	@OnClose
	public void OnClose( Session session ) {
		callList.remove(session);
	}
	
	@OnMessage
	public void OnMessage( Session session , String msg ) throws JsonProcessingException {
		System.out.println( msg );
		
		//String(json형식)을 Dto로 바꾼다.
		ObjectMapper mapper = new ObjectMapper();
		ServiceDto servicedto = mapper.readValue(msg, ServiceDto.class);
		
		
		
		 if ( servicedto.getType() == 1 ) { // 사용자가 -> 콜요청
		        boolean result = CallDao.getInstance().MemberCall(servicedto.getMno(), servicedto.getSfromla(), servicedto.getSfromlo(), servicedto.getStola(), servicedto.getStolo());
		        if (result) {
		            System.out.println("성공");
		            // 라이더들에게 메시지 보내기.
		        } else {
		            System.out.println("실패");
		        }
		    }
		 else if( servicedto.getType() == 2 ) { // 라이더가 -> 콜 수락
			 
		 }else if( servicedto.getType() == 3 ) {  // 라이더가 -> 콜 거절
			 
		 }else if( servicedto.getType() == 4 ) {  // 라이더의 위치
			 
		 }
	
		
		callList.forEach( s ->{
			try {s.getBasicRemote().sendText(msg);} 
			catch (IOException e) { e.printStackTrace(); }
		});
		
	}
	
	
}
