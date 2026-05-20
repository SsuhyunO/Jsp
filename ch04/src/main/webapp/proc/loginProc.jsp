<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String userid = request.getParameter("userid");
	String pass = request.getParameter("pass");
	String auto = request.getParameter("auto"); // checkbox value는 on/null
	
	// 수신 파라미터 콘솔 출력해서 확인하는 습관!!!
	// System.out.print("auto : " + auto);
	
	// 데이터베이스 비교 처리 생략
	// abc1234, 1234라고 가정
	if(pass.equals("1234")) {
		// 자동 로그인 처리
		if(auto != null){
			// 쿠키 생성
			Cookie autoCookie = new Cookie("auto", userid);
			autoCookie.setMaxAge(60 * 60* 24 * 7); // 7일(초, 분, 시, 일)
			
			// 클라이언트 전송
			response.addCookie(autoCookie);
		}
		
		// 회원 맞으면 세션(Session Table)에 사용자 아이디를 sesUser 이름으로 저장
		session.setAttribute("sessUser", userid);
	
		// 리다이렉트
		response.sendRedirect("loginSuccess.jsp");
	}else {
		// 회원 아닐 경우 다ㅣ 로그인폼 화면으로 이동(로그인 실패 파라미터 들고)
		response.sendRedirect("loginForm.jsp?login=fail");
	}

%>