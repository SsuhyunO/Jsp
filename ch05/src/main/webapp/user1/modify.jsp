<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="sub1.User1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String userid = request.getParameter("userid");

	// 수정 데이터 선언
	User1 user1 = null;

	//----------------------------------
	// 데이터베이스 작업 - 수정 데이터 조회
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
		String sql = "SELECT * FROM `user1` WHERE `userid` = ? ";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, userid);
		
		// 4) SQL 실행
		ResultSet rs = psmt.executeQuery();
		
		// 5) 결과셋(ResultSet) 처리
		while(rs.next()){
			user1 = new User1();
			user1.setUserid(rs.getString(1));
			user1.setName(rs.getString(2));
			user1.setBirth(rs.getString(3));
			user1.setHp(rs.getString(4));
			user1.setAge(rs.getInt(5));
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
		<title>user1::수정</title>
	</head>
	<body>
		<h3>User1 수정</h3>
		<a href="./1_jdbc.jsp"></a>
		<a href="list.jsp"></a>

	<form action="/ch05/user1/proc/modify.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" value="<%=user1.getUserid()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=user1.getName()%>"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" value="<%=user1.getBirth()%>"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="<%=user1.getHp()%>"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="<%=user1.getAge()%>"></td>
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