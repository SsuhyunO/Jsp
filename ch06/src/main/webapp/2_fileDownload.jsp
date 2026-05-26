<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sub1.FileDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터베이스 파일 정보 가져오기
	List<FileDTO> fileList = new ArrayList<>();
	
	try {
		Context ctx = (Context)new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/studydb");
		
		Connection conn = ds.getConnection();
		Statement smt = conn.createStatement();
		
		String sql = "SELECT * FROM `FileTable`";
		ResultSet rs = smt.executeQuery(sql);
		
		while(rs.next()){
			FileDTO file = new FileDTO();
			file.setNo(rs.getInt(1));
			file.setUserid(rs.getString(2));
			file.setName(rs.getString(3));
			file.setOfname(rs.getString(4));
			file.setSfname(rs.getString(5));
			file.setRdate(rs.getString(6));
			fileList.add(file);
		}
		
		rs.close();
		smt.close();
		conn.close();
	}catch (Exception e){
		e.printStackTrace();
	}


%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2_fileDownload</title>
	</head>
	<body>
		<h3>2. 파일 다운로드 실습</h3>
		
		<a href="1_fileUpload.jsp">파일 업로드 폼</a>
		
		<table border="1">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>원본 파일명</th>
				<th>저장 파일명</th>
				<th>등록일</th>
				<th>관리</th>
			</tr>
			<% for(FileDTO file : fileList) { %>
				<tr>
					<td><%= file.getNo() %></td>
					<td><%= file.getUserid() %></td>
					<td><%= file.getName() %></td>
					<td><%= file.getOfname() %></td>
					<td><%= file.getSfname() %></td>
					<td><%= file.getRdate() %></td>
					<td>
						<a href="proc/fileDelete.jsp?no=<%= file.getNo() %>">삭제</a>
						<a href="proc/fileDownload.jsp?no=<%= file.getNo() %>">다운</a>
					</td>
				</tr>
			<% } %>
		</table>
		
	</body>
</html>