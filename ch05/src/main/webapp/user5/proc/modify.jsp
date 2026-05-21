<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String seq 		= request.getParameter("seq");
	String name		= request.getParameter("name");	
	String gender	= request.getParameter("gender");
	String age		= request.getParameter("age");
	String addr		= request.getParameter("addr");

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
		String sql = "UPDATE `user5` SET ";
		sql += "name = ?,";
		sql += "gender= ?,";
		sql += "age = ?,";
		sql += "addr = ? ";
		sql += "WHERE seq=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(5, seq);
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
	response.sendRedirect("/ch05/user5/list.jsp?modify=success");
%>