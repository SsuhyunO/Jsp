package kr.co.jboard.controller.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.service.UserService;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 서비스 가져오기(열거 상수 객체)
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		// 서비스 호출
		UserDTO userDTO = service.findById(userid, pass);
		
		if(userDTO != null) {
			// 회원 맞음 -> 세션 저장 후 글목록 이동
			HttpSession session =  req.getSession(); // request 객체로 현재 사용자(session) 구하기
			session.setAttribute("sessUser", userDTO);
			
			// 회원 맞음 -> 세션저장 후 글목록 이동
			resp.sendRedirect("/jboard/article/list.do");
		}else {
			// 회원 아님 -> 로그인 이동
			resp.sendRedirect("/jboard/user/login.do?login=fail");
		}
	}
}
