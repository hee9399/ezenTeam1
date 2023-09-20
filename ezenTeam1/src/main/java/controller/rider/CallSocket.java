package controller.rider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

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
	public void OnMessage( Session session , String msg ) {
		System.out.println( msg );
		callList.forEach( s ->{
			try {s.getBasicRemote().sendText(msg);} 
			catch (IOException e) { e.printStackTrace(); }
		});
	}
	
	
}
