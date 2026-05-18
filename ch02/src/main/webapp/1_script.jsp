<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_script</title>
		<%--
			날짜 : 2026/05/18
			이름 : 오수현
			내용 : JSP 스크립트 요소 실습
		 --%>
	</head>
	<body>
		<h3>1. 스크립트 요소</h3>
		
		<h4>스크립트릿(Scriplet)</h4>
		<%	
			/*
				스크립트릿 영역(자바 프로그래밍)
			*/
		
			// 변수 선언
			int 	var1 = 1;
			boolean var2 = true;
			double 	var3 = 3.21;
			String 	var4 = "Hello";
			
			// 동적 태그 생성
			out.println("<p>var1 : " + var1 + "</p>");
			out.println("<p>var2 : " + var2 + "</p>");
		%>
		
		
		<h4>표현식(Expression)</h4>
		<p>var3 : <%= var3 %></p><!-- 표현식은 간단하게 Java 변수 출력 -->
		<p>var4 : <%= var4 %></p>
		
	</body>
</html>