<%@ page import="sub1.Account"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>4_directive</title>
	</head>
	<body>
		<h3>4. 지시자</h3>
		
		<h4>page import 지시자</h4>
		
		<%
			Account kb = new Account("국민은행", "101-12-1001", "김유신", 1000);
			kb.deposit(30000);
			kb.withdraw(5000);
			kb.show(out);
		%>
	
		<h4>include 지시자</h4>
		<%@ include file="./inc/_header.jsp" %>
		<%@ include file="./inc/_footer.jsp" %>
	
	</body>
</html>