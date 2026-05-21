<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="sub1.User5"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String seq = request.getParameter("seq");

	// 수정 데이터 선언
	User5 user5 = null;

	//----------------------------------
	// 데이터베이스 작업 - 수정 데이터 조회
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
		String sql = "SELECT * FROM `user5` WHERE `seq` = ? ";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, seq);
		
		// 4) SQL 실행
		ResultSet rs = psmt.executeQuery();
		
		// 5) 결과셋(ResultSet) 처리
		while(rs.next()){
			user5 = new User5();
			user5.setSeq(rs.getInt(1));
			user5.setName(rs.getString(2));
			user5.setGender(rs.getString(3));
			user5.setAge(rs.getInt(4));
			user5.setAddr(rs.getString(5));
		}

		// 6) 데이터베이스 종료
		rs.close();
		psmt.close();
		conn.close();
		
	}catch (Exception e){
		e.printStackTrace();
	}

%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5::수정</title>
	</head>
	<body>
		<h3>user5 수정</h3>
		<a href="./1_jdbc.jsp"></a>
		<a href="list.jsp"></a>

	<form action="/ch05/user5/proc/modify.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="seq" value="<%=user5.getSeq()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=user5.getName()%>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="text" name="gender" value="<%=user5.getGender()%>"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="<%=user5.getAge()%>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="<%=user5.getAddr()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
	</form>		
		
		
	</body>
</html>