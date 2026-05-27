<%@page import="jakarta.mail.Transport"%>
<%@page import="jakarta.mail.internet.InternetAddress"%>
<%@page import="jakarta.mail.Message"%>
<%@page import="jakarta.mail.internet.MimeMessage"%>
<%@page import="jakarta.mail.Authenticator"%>
<%@page import="jakarta.mail.PasswordAuthentication"%>
<%@page import="jakarta.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String sender = request.getParameter("sender");
	String receiver = request.getParameter("receiver");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	// Gmail SMTP 설정
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "465");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.ssl.enable", "true");
	props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	
	// Gmail SMTP 세션 생성
	Session sess = Session.getInstance(props, new Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication(){
			String APP_PASS = "앱비밀번호";
			return new PasswordAuthentication(sender, APP_PASS);
		}
		
	});
	
	// 이메일 전송을 위한 마임메세지 작성
	Message message = new MimeMessage(sess);
	
	try {
		message.setFrom(new InternetAddress(sender, "보내는사람", "UTF-8"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		message.setSubject(title);
		message.setContent(content, "text/html;charset=UTF-8");
		
		// 최종 전송
		Transport.send(message);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	// 이메일 작성 폼 이동
	response.sendRedirect("../3_emailTest.jsp");
%>