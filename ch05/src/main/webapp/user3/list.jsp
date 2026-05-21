<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="sub1.User3"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	// 목록 출력 리스트
	List<User3> user3List = new ArrayList<>();

	//----------------------------------
	// 데이터베이스 저장
	// ----------------------------------
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "osh7313240";
	String password = "1234";
	
	try {
		// 1) 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2) 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, password);

		// 3) SQL 실행 객체 생성
		Statement stmt = conn.createStatement();

		// 4) SQL 실행
		String sql = "SELECT * FROM `user3`";
		ResultSet rs = stmt.executeQuery(sql);

		// 5) 결과셋(ResultSet) 처리
		while(rs.next()){
			User3 user3 = new User3();
			user3.setUserid(rs.getString(1));
			user3.setName(rs.getString(2));
			user3.setBirth(rs.getString(3));
			user3.setHp(rs.getString(4));
			user3.setAddr(rs.getString(5));
			
			user3List.add(user3);
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
		<title>user3::목록</title>
	</head>
	<body>
		<h3>user3 목록</h3>
		<a href="/ch05/1_jdbc.jsp">메인</a>
		<a href="/ch05/user3/register.jsp">등록</a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<%
				for(User3 user3 : user3List){
			%>
			<tr>
				<td><%=user3.getUserid() %></td>
				<td><%=user3.getName() %></td>
				<td><%=user3.getBirth()%></td>
				<td><%=user3.getHp() %></td>
				<td><%=user3.getAddr() %></td>
				<td>
					<a href="modify.jsp?userid=<%=user3.getUserid()%>">수정</a>
					<a href="proc/delete.jsp?userid=<%=user3.getUserid()%>">삭제</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>	
	</body>
</html>