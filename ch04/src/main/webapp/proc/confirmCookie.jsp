<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>confirmCookie</title>
	</head>
	<body>
		<h3>쿠키 확인</h3>
		
		<%
			// 쿠키 가져오기
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies){
		%>	
			<p>
				쿠키명 : <%= cookie.getName() %> <br>
				쿠키값 : <%= cookie.getValue() %> <br>			
			</p>
		<% 	
			}
		%>
		
		<a href="../1_cookie.jsp">처음으로</a>

	</body>
</html>