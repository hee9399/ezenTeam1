package controller.rider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/gpssocket")
public class GpsSocket {
	
	public static List< Session > 접속명단 = new ArrayList<>();
	
	@OnOpen
	public void OnOpen( Session session ) {
		접속명단.add(session);
	}
	
	@OnClose
	public void OnClose( Session session ) {
		접속명단.remove(session);
	}
	
	@OnMessage
	public void OnMessage( Session session , String msg ) {
		System.out.println( msg );
		접속명단.forEach( s ->{
			try {s.getBasicRemote().sendText(msg);} 
			catch (IOException e) { e.printStackTrace(); }
		});
	}
	
}
