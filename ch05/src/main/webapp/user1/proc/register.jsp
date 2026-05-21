<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String userid 	= request.getParameter("userid");
	String name		= request.getParameter("name");	
	String birth	= request.getParameter("birth");
	String hp		= request.getParameter("hp");
	String age		= request.getParameter("age");

	// ----------------------------------
	// 데이터베이스 저장
	// ----------------------------------
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "osh7313240";
	String password = "1234";
	
	try{
		// 1) 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		// 2) 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, password);		

		// 3) SQL 실행 객체 생성
		String sql = "INSERT INTO `user1` VALUES (?, ?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, userid);
		psmt.setString(2, name);
		psmt.setString(3, birth);
		psmt.setString(4, hp);
		psmt.setString(5, age);

		// 4) SQL 실행
		psmt.executeUpdate();

		// 5) 결과셋 처리
		
	
		// 6) 데이터베이스 종료
		psmt.close();
		conn.close();

	} catch(Exception e){
		e.printStackTrace();
	}
	
	// 목록 이동
	response.sendRedirect("/ch05/user1/list.jsp?register=success");
%>