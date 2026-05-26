<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2_dbcp</title>
		
		<!-- 
			DBCP(DataBase Connection Pool)
				- 데이터베이스 접속 커넥션 객체를 미리 생성해서 Pool(저장소)에 저장해 놓고 사용하는 방식
				- 일반 접속 커넥션 방식은 사용자가 많아지면 시스템 성능이 떨어지는 단점을 보완
			
			커넥션풀 설정
			- Tomcat(Servers) > context.xml 파일 아래 내용 추가 설정
			
			<Resource
				name="jdbc/studydb"							-- 커넥션풀 이름					
				auth="Container"							-- 기본 컨테이너 값
				type="javax.sql.DataSource"					-- 커넥션풀 클래스타입
				driverClassName="com.mysql.cj.jdbc.Driver"	-- 데이터베이스 드라이버 클래스
				url="jdbc:mysql://127.0.0.1:3306/studydb"	-- 데이터베이스 주소
				username="osh7313240"						-- 데이터베이스 아이디
				password="1234"								-- 데이터베이스 비밀번호
				maxTotal="13"								-- 최대 커넥션풀에 생성되는 커넥션 갯수
				maxIdle="13"								-- 활성화(준비된) 커넥션 갯수
				maxWaitMillis="3000"						-- 커넥션 대기 시간
			/>
		-->
		
	</head>
	<body>
		<h3>2. DBCP(DataBase Connection Pool) 실습</h3>
		
		<!-- 절대경로 시작-->
		<a href="/ch05/user1/list.jsp">User1 목록</a>
		<a href="/ch05/user2/list.jsp">User2 목록</a>
		<a href="/ch05/user3/list.jsp">User3 목록</a>
		<a href="/ch05/user4/list.jsp">User4 목록</a>
		<a href="/ch05/user5/list.jsp">User5 목록</a>
		
	</body>
</html>