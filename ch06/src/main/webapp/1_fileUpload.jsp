<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_fileUpload</title>
		<!--
			날짜 : 2026/05/26
			이름 : 오수현
			내용 : JSP 파일 업로드/다운로드 실습
			
			JSP 업로드 방식
			
			1) cos.jar 방식
			- 전통적 고전 업로드 방식
			- cos.jar 외부 라이브러리 사용
			
			2)apache fileupload 라이브러리 방식
			- apache fileupload 라이브러리를 이용한 방식
			- Springboot에 기본 내장된 업로드 방식
			
			3) Tomcat Part 방식
			- Servlet 6버전에 추가된 업로드 방식
			- 최신 JSP/Servlet에서는 해당 방식 권장
			
			Tomcat Part 설정
			- context.xml > Context 태그에 allowCasualMultipartParsing="true" 선언
			- server.xml > Connector 태그에 maxPostSize="10485760" 선언 (10MB = 1024 x 1024 x 10)
		 -->
	</head>
	<body>
		<h3>1. 파일 업로드 실습</h3>
		
		<a href="2_fileDownload.jsp">파일 다운로드 목록</a>
		
		<form action="./proc/fileUpload.jsp" method="post" enctype="multipart/form-data">
			<input type="text" name="userid" placeholder="아이디 입력"> <br>
			<input type="text" name="name" placeholder="이름 입력"> <br>
			<input type="file" name="fname"> <br>
			<input type="submit" value="파일 전송" > <br>
		</form>
		
	</body>
</html>