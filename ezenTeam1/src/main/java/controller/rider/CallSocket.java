package controller.rider;

import java.io.IOException;
import java.util.ArrayList;
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
	
	@OnOpen
	public void OnOpen( Session session ) {
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
		
		if(servicedto.getType() == 1) {
			
			
			
			boolean result = CallDao.getInstance().MemberCall(servicedto.getMno(), servicedto.getSfromla(), servicedto.getSfromlo(), servicedto.getStola(), servicedto.getStolo());
			if(result) {System.out.println("성공");}
			else {System.out.println("실패");}
			
		}
		else if(servicedto.getType() == 2) {
			
		}
		
	
	
		
		callList.forEach( s ->{
			try {s.getBasicRemote().sendText(msg);} 
			catch (IOException e) { e.printStackTrace(); }
		});
		
	}
	
	
}
