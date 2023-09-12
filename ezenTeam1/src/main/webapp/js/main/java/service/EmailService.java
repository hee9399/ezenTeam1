package service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.rowset.spi.TransactionalWriter;

public class EmailService { // 이메일 전송에 관련된 클래스 
	
	// 1.필드
	private String fromEmail ="mirage8569@naver.com";
	private String fromEmailPwd="";
	
	// 2. 생성자
	public EmailService() {}
	
	// 3. 메소드
	public boolean aushsend(String toEmail,String contentHTML) {
		
		// 1. 호스팅 설정 [네이버기준]
		Properties properties = new Properties();
		properties.put("mial.smtp.host", "smtp.naver.com");
		properties.put("mial.smtp.port", 587);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Authenticator authenticator = new Authenticator() {
			
			// 패스워드 검증 함수 [ 구현 ]
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, fromEmailPwd);
			}
		};
		
		Session session = Session.getDefaultInstance(properties, authenticator);
		try {
		// 3. 메일 전송
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		
		// 4. .sub
		message.setSubject("Ezen JSP 회원가입 인증코드 발송");
		
		message.setText("안녕하세요. 이메일 인증코드 : "+contentHTML);
		
		Transport.send(message);
		
			// ----------
		return true; // 메일ㅈ ㅓㄴ송 선공
		}catch (Exception e) {System.out.println(e);}
		
		
		return false;
	}
	

}

/*

- 자바에서 이메일 전송 보내기 
	- SMTP : 간이 우편 전송 프로토콜(규칙/규약/약속)
	- MIME : 주로 SMTP 사용. 이메일과 함께 보낼 내용/문자 형식 프로토콜 
	
	1. 이메일을 전송할 도메인 필요 [ 네이버 , 다음 , 구글 등등 ]
		[ 강의기준 : 네이버 ( git사용시 : 패스워드 감추거나 private 저장소 이용 ) , 2차 비밀번호 불가능 ]
		- 네이버 로그인 
			1. 메일 
			2. 메뉴 -> 환경설정 -> 메뉴 -> POP3/IMAP 설정 
				
				[ IMAP/SMTP ]
					- IMAP/SMTP 사용 : 사용함 
					[ 스마트폰 메일 애플리케이션 계정 설정 ] 확인 
						SMTP 서버명 : smtp.naver.com
						SMTP 포트 : 587, 보안 연결(TLS) 필요 (TLS가 없는 경우 SSL로 연결)
	
	2. SMTP 라이브러리 [ 이메일 전송에 관련된 클래스/라이브러리 제공 ]
		1. java-mail , java-activation 다운로드 -> build path add
	
	3. 메일 전송 함수 만들기 
		1. 호스트 설정 
			Properties Properties = new Properties();
			Properties.put( "mail.smtp.host", "호스트의주소");
			Properties.put( "mail.smtp.port", 호스트포트번호 );
			Properties.put( "mail.smtp.auth", true );
			Properties.put( "mail.smtp.ssl.protocols", "TLSv1.2");
			
		2. 보내는사람 계정 인증객체
			Authenticator authenticator = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication( "보내는사람이메일", "보낸사람의이메일비밀번호" );
				}
			};
		
		3. 인증처리 와 인증결과 객체 
			Session session = Session.getDefaultInstance( Properties , authenticator );
		
		4. 보내는 내용 설정 
			MimeMessage message = new MimeMessage( 인증된세션객체 );
			message.setFrom( new InternetAddress("보내는사람의이메일주소") );
			message.addRecipient( Message.RecipientType.TO , new InternetAddress( "받는사람의이메일주소" ));
			message.setSubject("이메일제목");
			message.setText( "이메일내용" );
			
		5. * 전송 
			Transport.send( message );
			
*/