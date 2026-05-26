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
		파일 업로드 처리	
	*/

	// 파일 업로드 경로 구하기
	String savedDirectory = application.getRealPath("/upload");
	System.out.println("savedDirectory : " + savedDirectory);

	// 파일 업로드 디렉토리가 없으면 생성하기
	File fdirectory = new File(savedDirectory);
	
	if(!fdirectory.exists()){
		fdirectory.mkdir();
	}
	
	// 첨부 파일 정보 구하기 
	Part part = request.getPart("fname"); // Part는 업로드한 파일 정보 객체
	String partHeader = part.getHeader("content-disposition");
	System.out.println("partHeader : " + partHeader); // 'form-data'로 출력
	
	String[] filenames = partHeader.split("filename=");
	String fileName = filenames[1].trim().replace("\"", "");
	System.out.println("fileName : " + fileName); // 첨부한 파일명 출력
	
	// 업로드한 파일 저장
	if(!fileName.isEmpty()){
		part.write(savedDirectory + File.separator + fileName);
	}
	
	// 증복될 수 없는 파일명 생성
	int idx = fileName.lastIndexOf(".");
	String ext = fileName.substring(idx);
	
	String saveName = UUID.randomUUID().toString() + ext; // UUID(Universal Unique ID)
	System.out.println("savedName : " + saveName); // 고유 파일명 출력
	
	// 파일명 수정
	File ofile = new File(savedDirectory + File.separator + fileName);
	File sfile = new File(savedDirectory + File.separator + saveName);
	
	ofile.renameTo(sfile);
	
	/* 
		데이터베이스 작업 처리
	*/
	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	
	try {
		Context ctx = (Context)new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/studydb");
		
		Connection conn = ds.getConnection();
		
		String sql = "INSERT INTO `FileTable` (userid, name, ofname, sfname, rdate) VALUES (?,?,?,?, NOW())";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, userid);
		psmt.setString(2, name);
		psmt.setString(3, fileName);
		psmt.setString(4, saveName);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
	}catch (Exception e){
		e.printStackTrace();
	}
	
	// 폼 이동
	response.sendRedirect("../1_fileUpload.jsp");
%>