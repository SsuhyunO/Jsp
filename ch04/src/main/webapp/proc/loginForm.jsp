<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 자동 로그인 여부 검사
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		String cookieName = cookie.getName();
		if(cookieName.equals("auto")){
			// 쿠키에서 사용자 아이디 가져오기
			String userid = cookie.getValue(); 
			
			// 세션 저장
			session.setAttribute("sessUser", userid);
			
			// 로그인 성공 페이지 이동
			response.sendRedirect("./loginSuccess.jsp?login=auto");
			return; // 실행 흐름 종료
		}
	}
%>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>loginForm</title>
	</head>
	<body>
		<h3>로그인</h3>
		
		<form action="loginProc.jsp" method="post">
			<input type="text" name="userid" placeholder="아이디 입력"><br>
			<input type="password" name="pass" placeholder="비밀번호 입력"><br>
			<label><input type="checkbox" name="auto">자동 로그인</label><br>
			<input type="submit" value="로그인">
		</form>
	</body>
</html>