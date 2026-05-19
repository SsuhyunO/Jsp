<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>redirect2</title>
	</head>
	<body>
		<h3>리다이렉트2 페이지</h3>
		<%
			// 리다이렉트 - 다른 페이지나 사이트로 이동
			response.sendRedirect("https://naver.com");
		%>
		
	</body>
</html>