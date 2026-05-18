<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_request</title>
	</head>
	<body>
		<h3>1. request 내장객체</h3>
		
		<!-- 
			request 내장객체
			- 클라이언트 요청 정보를 갖는 내장객체
			- 클라이언트와 관련된 정보를 갖는 객체
		
			GET 요청
			- 기본 링크 페이지 요청, 
			- 데이터 전송은 주소 뒤 ? 파라미터 문자열(쿼리스트링)로 전송
			- 보안에 취약하지만 빠른 요청 처리
			
			POST 요청
			- 폼 전송 데이터 요청
			- 전송 데이터가 요청 객체 body에 저장되어 전송
			- 전송 데이터 보안에 유리하고 대량의 데이터 전송에 적합
		 -->
		
		<h4>GET 요청</h4>
		<a href="proc/result1.jsp?userid=a101">result1</a> <!-- 주소 뒤 ? 파라미터(쿼리스트링) 전송 -->
		<a href="proc/result2.jsp?userid=a101&name=홍길동">result2</a>
		<a href="proc/result3.jsp?userid=a101&name=홍길동&age=21">result3</a>
		
		<form action="proc/result3.jsp"> <!-- form method 속성이 없으면 GET 요청 -->
			<input type="text" name="userid"><br>
			<input type="text" name="name"><br>
			<input type="number" name="age"><br>
			<input type="submit" name="전송하기"><br>
		</form>
		
		<h4>POST 요청</h4>
		<form action="proc/result4.jsp" method="post"> <!-- form은 일반적으로 POST 요청 -->
			<input type="text" name="userid"><br>
			<input type="text" name="name"><br>
			<input type="number" name="age"><br>
			<input type="submit" name="전송하기"><br>
		</form>
		
		<h4>request 주요 정보</h4>
		<p>
			헤더정보 : <%= request.getHeader("User-Agent") %><br>
			프로토콜 : <%= request.getProtocol() %><br>
			서버이름 : <%= request.getServerName() %><br>
			서버포트 : <%= request.getServerPort() %><br>
			요청주소 : <%= request.getRequestURL() %><br>
			요청경로 : <%= request.getRequestURI() %><br>
			IP 주소 : <%= request.getRemoteAddr() %><br>
		</p>
		
	</body>
</html>