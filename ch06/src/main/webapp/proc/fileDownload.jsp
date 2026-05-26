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
		파일 다운로드 처리	
	*/
	// 전송 데이터 수신
	String no = request.getParameter("no");
	
	/*
		데이터베이스 조회 처리
	*/
	FileDTO file = null;
	
	try {
		Context ctx = (Context)new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/studydb");
		
		Connection conn = ds.getConnection();
		
		String sql = "SELECT * FROM `FileTable` WHERE no = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, no);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			file = new FileDTO();
			file.setNo(rs.getInt(1));
			file.setUserid(rs.getString(2));
			file.setName(rs.getString(3));
			file.setOfname(rs.getString(4));
			file.setSfname(rs.getString(5));
			file.setRdate(rs.getString(6));
		}
		
		rs.close();
		psmt.close();
		conn.close();
	}catch (Exception e){
		e.printStackTrace();
	}
	
	// response 파일 다운로드 헤더 수정
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getOfname(),"utf-8"));
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "private");
	
	// 다운로드 파일 스트림 작업
	String path = application.getRealPath("/upload");
	File savedFile = new File(path + File.separator + file.getSfname());
	
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(savedFile));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	bis.transferTo(bos); // 스트림 전송
	
	bos.flush();
	bos.close();
	bis.close();
%>