<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_ServletTest</title>
		<!-- 
			서블릿 등록(주소맵핑)
			1) xml 설정 방법
			- web.xml > servlet 태그 설정
			
			2) 어노테이션 설정 방법
			- 서블릿 클래스 상단 @WebServlet("주소") 선언
		 -->
	</head>
	<body>
		<h3>1. 서블릿 실습</h3>
		
		<h4>Get 요청</h4>
		<a href="/ch08/hello.do">HelloServlet</a><br>
		<a href="/ch08/welcome.do">WelcomeServlet</a><br>
		<a href="/ch08/greeting.do">GreetingServlet</a><br>
		
		<h4>Post 요청</h4>
		<form action="hello.do" method="post">
			<input type="text" name="userid"><br>
			<input type="password" name="pass"><br>
			<input type="submit" value="전송"><br>
		
		</form>
		
	</body>
</html>