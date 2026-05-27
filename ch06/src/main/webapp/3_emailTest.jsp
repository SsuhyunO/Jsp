<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>3_emailTest</title>
		<!-- 
			이메일 설정
			
			1) 구글 앱 비밀번호 생성
			- 구글 계정관리 > 보안 > 2단계 인증 > 2단계 인증 사용 설정
			- 구글 계정관리 > 보안 > 앱 비밀번호 > 앱 생성(Gmail SMTP App) 후 생성코드
		
			2) 이메일 전송 라이브러리 추가
			- jakarta.mail-api-2.1.5.jar
			- jakarta.activation-api-2.1.4.jar
			- angus-mail-2.0.5.jar
		
		 -->
		
	</head>
	<body>
		<h3>3. 이메일 전송 실습</h3>
		
		<form action="proc/emailSend.jsp" method="post">
			<table border="1">
				<tr>
					<td>보내는 사람</td>
					<td><input type="text" name="sender"></td>
				</tr>
				<tr>
					<td>받는 사람</td>
					<td><input type="text" name="receiver"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" rows="20" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="전송하기">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>