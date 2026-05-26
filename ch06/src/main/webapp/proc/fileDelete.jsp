<%@page import="java.sql.Statement"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="sub1.FileDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	/*
		파일 삭제 처리	
	*/
	// 전송 데이터 수신
	String no = request.getParameter("no");
	String sfname = null;
	
	/*
		데이터베이스 삭제 처리
	*/
	
	try {
		Context ctx = (Context)new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/studydb");
		
		Connection conn = ds.getConnection();
		
		conn.setAutoCommit(false); // 트랜잭션 시작
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT sfname FROM FileTable WHERE no=" + no);
		
		if(rs.next()){
			sfname = rs.getString(1);
		}
		
		String sql = "DELETE FROM `FileTable` WHERE no = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, no);
		
		psmt.executeUpdate();
		
		conn.commit(); // 트랜잭션 작업완료
		
		rs.close();
		stmt.close();
		psmt.close();
		conn.close();
	}catch (Exception e){
		e.printStackTrace();
	}
	
	// 디렉토리 파일 삭제
	String path = application.getRealPath("/upload");
	File savedFile = new File(path + File.separator + sfname);
	savedFile.delete();
	
	// 목록 이동
	response.sendRedirect("../2_fileDownload.jsp?delete=success");
%>