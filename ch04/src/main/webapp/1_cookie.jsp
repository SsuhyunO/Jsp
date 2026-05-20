<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_cookie</title>
	</head>
	<body>
		<h3>1. Cookie 실습</h3>
		
		<form action="./proc/createCookie.jsp" method="post">
			<input type="text" name="userid" placeholder="아이디 입력"><br>
			<input type="text" name="name" placeholder="이름 입력"><br>
			<input type="date" name="birth"><br>
			<input type="number" name="age" placeholder="나이 입력"><br>
			<input type="submit" value="전송">
		</form>
		
	</body>
</html>