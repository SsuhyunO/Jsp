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

@WebServlet("/user/logout.do")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 서비스 가져오기(열거 상수 객체)
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그아웃 처리
		HttpSession session = req.getSession();
		session.removeAttribute("sessUser");
		session.invalidate();
		
		// 로그인 이동
		resp.sendRedirect("/jboard/user/login.do?logout=success");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
