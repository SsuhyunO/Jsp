<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>result4</title>
	</head>
	<body>
		<h3>result4 결과 페이지 </h3>
		
		<%
			// 전송데이터 수신
			String params = request.getQueryString();
			String userid = request.getParameter("userid");
			String name = request.getParameter("name");
			String age = request.getParameter("age"); // 전송 데이터 수신은 무조건 문자열로 반환
		%>
		
		<p>
			파라미터 : <%= params %><br>
			아이디 : <%= userid %><br>
			이름 : <%= name %><br>
			나이 : <%= age %><br>
		</p>
		
		
		<a href="../1_request.jsp">1_request</a>
	</body>
</html>