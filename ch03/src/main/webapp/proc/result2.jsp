<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>result2</title>
	</head>
	<body>
		<h3>result2 결과 페이지 </h3>
		
		<%
			// 전송데이터 수신
			String params = request.getQueryString();
			String userid = request.getParameter("userid");
			String name = request.getParameter("name");
		%>
		
		<p>
			파라미터 : <%= params %><br>
			아이디 : <%= userid %><br>
			이름 : <%= name %><br>
		</p>
		
		
		<a href="../1_request.jsp">1_request</a>
	</body>
</html>