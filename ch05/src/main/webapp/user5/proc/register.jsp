<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String name		= request.getParameter("name");	
	String gender	= request.getParameter("gender");
	String age		= request.getParameter("age");
	String addr		= request.getParameter("addr");

	// ----------------------------------
	// 데이터베이스 저장
	// ----------------------------------
	// String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	// String user = "osh7313240";
	// String password = "1234";
	
	try{
		//----------------------------------
		// DBCP 방식
		//----------------------------------
		
		// 1) JNDI 서비스 객체 생성
		Context initCtx = new InitialContext();
		Context ctx = (Context)initCtx.lookup("java:comp/env"); // JNDI 기본 환경 이름

		// 2) 커넥션풀 데이터베이스 커넥션 가져오기
		DataSource ds = (DataSource)ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();		

		// 3) SQL 실행 객체 생성
		String sql = "INSERT INTO `user5` (name, gender, age, addr) VALUES (?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, gender);
		psmt.setString(3, age);
		psmt.setString(4, addr);

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
	response.sendRedirect("/ch05/user5/list.jsp?register=success");
%>