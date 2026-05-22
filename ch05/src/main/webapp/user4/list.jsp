<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="sub1.User4"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	// 목록 출력 리스트
	List<User4> user4List = new ArrayList<>();

	//----------------------------------
	// 데이터베이스 저장
	// ----------------------------------
	// String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	// String user = "osh7313240";
	// String password = "1234";
	
	try {
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
		Statement stmt = conn.createStatement();

		// 4) SQL 실행
		String sql = "SELECT * FROM `user4`";
		ResultSet rs = stmt.executeQuery(sql);

		// 5) 결과셋(ResultSet) 처리
		while(rs.next()){
			User4 user4 = new User4();
			user4.setUserid(rs.getString(1));
			user4.setName(rs.getString(2));
			user4.setGender(rs.getString(3));
			user4.setAge(rs.getInt(4));
			user4.setHp(rs.getString(5));
			user4.setAddr(rs.getString(6));
			
			user4List.add(user4);
		}

		// 6) 데이터베이스 종료
		rs.close();
		stmt.close();
		conn.close();
		
	}catch (Exception e){
		e.printStackTrace();
	}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::목록</title>
	</head>
	<body>
		<h3>user4 목록</h3>
		<a href="/ch05/1_jdbc.jsp">메인1</a>
		<a href="/ch05/2_dbcp.jsp">메인2</a>	
		<a href="/ch05/user4/register.jsp">등록</a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>휴대폰</th>
				<th>주소</th>
			</tr>
			<%
				for(User4 user4 : user4List){
			%>
			<tr>
				<td><%=user4.getUserid() %></td>
				<td><%=user4.getName() %></td>
				<td><%=user4.getGender()%></td>
				<td><%=user4.getAge() %></td>
				<td><%=user4.getHp() %></td>
				<td><%=user4.getAddr() %></td>
				<td>
					<a href="modify.jsp?userid=<%=user4.getUserid()%>">수정</a>
					<a href="proc/delete.jsp?userid=<%=user4.getUserid()%>">삭제</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>	
	</body>
</html>