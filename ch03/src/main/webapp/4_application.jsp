<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>4_application</title>
	</head>
	<body>
		<h3>4. application 객체</h3>
		
		<h4>서버 정보</h4>
		<p>
			WAS 정보 : <%= application.getServerInfo() %><br>	
			Servlet 버전 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>	
			JSP 버전 : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
		</p>
		
		<h4>환경 정보</h4>
		<%
			// web.xml 환경 설정파일에 초기 설정값 가져오기
			String host = application.getInitParameter("HOST");
			String user = application.getInitParameter("USER");
			String pass = application.getInitParameter("PASS");
		%>
		
		<p>
			host : <%= host %> <br>
			user : <%= user %> <br>
			pass : <%= pass %> <br>
		</p>
		
		<h4>자원정보</h4>
		<!-- WAS의 실제 실행 경로 -->
		<%= application.getRealPath("4_application.jsp") %>
	
		
	</body>
</html>