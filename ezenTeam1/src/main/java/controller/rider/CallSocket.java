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
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.CallDao;
import model.dto.RiderDto;
import model.dto.ServiceDto;


@ServerEndpoint("/callsocket/{userType}")
public class CallSocket {
	
	public static Map<String,Session> callList = new HashMap<>(); 
	public static List<Session> riderlist = new ArrayList<>();
	
	

	@OnOpen
	public void OnOpen( Session session, @PathParam("userType") String userType ) {
		

		
		if ("rider".equals(userType)) {
            // 라이더인 경우 riderList에 세션 추가
			riderlist.add(session);
            System.out.println("라이더 세션 : " + session);
            System.out.println(riderlist);
        } else {
            // 사용자인 경우 callList에 세션 추가
            callList.add(session);
            System.out.println("사용자 세션 : " + session);
            System.out.println(callList);
        }
	}
	
	

	@OnClose
	public void OnClose( Session session ) {
		riderlist.remove(session);
		callList.remove(session);
	}
	
	@OnMessage
	public void OnMessage(Session session, String msg) {
		System.out.println(msg);

		// String(json형식)을 Dto로 바꾼다.
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jsonNode = mapper.readTree(msg);
			String type = jsonNode.get("type").asText();

			if ("call".equals(type)) { // 사용자가 -> 콜 요청
				ServiceDto servicedto = mapper.convertValue(jsonNode, ServiceDto.class);
				boolean result = CallDao.getInstance().MemberCall(servicedto.getMno(), servicedto.getSfromla(),
						servicedto.getSfromlo(), servicedto.getStola(), servicedto.getStolo());
				if (result) {
					System.out.println("사용자 정보 성공");
					// 라이더들에게 메시지 보내기.
					riderlist.forEach(s -> {
						try {
							s.getBasicRemote().sendText(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
				} else {
					System.out.println("실패");
				}
			} else if ("accept".equals(type)) { // 라이더가 -> 콜 수락
				RiderDto riderDto = mapper.convertValue(jsonNode, RiderDto.class);
				boolean result = CallDao.getInstance().RiderAccept(riderDto.getRno(),riderDto.get라이더위도(),riderDto.get라이더경도());
				 if (result) {
			            System.out.println("라이더 정보 성공");
			            // 라이더들에게 메시지 보내기.
			            callList.forEach( (id,ses) ->{
			    			try {id.getBasicRemote().sendText(msg);
			    				ses.getBasicRemote().sendText(msg);
			    			} 
			    			catch (IOException e) { e.printStackTrace(); }
			    		});
			        } else {
			            System.out.println("라이더 실패");
			        }
			} else {
				System.out.println("알 수 없는 메시지 타입: " + type);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
	


