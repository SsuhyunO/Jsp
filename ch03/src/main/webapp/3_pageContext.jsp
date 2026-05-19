<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>3_pageContext</title>
	</head>
	<body>
		<h3>3. pageContext 객체</h3>
		
		<h4>forward</h4>
		<a href="proc/forward1.jsp">포워드 페이지1 요청</a>
		<a href="proc/forward2.jsp">포워드 페이지2 요청</a>
		
		<h4>include</h4>
		<%
			// 동적 include
			pageContext.include("inc/_header.jsp");
			pageContext.include("inc/_footer.jsp");
		%>
		
		<!-- 정적 include -->
		<%@ include file="inc/_header.jsp" %>
		<%@ include file="inc/_footer.jsp" %>
		
	</body>
</html>