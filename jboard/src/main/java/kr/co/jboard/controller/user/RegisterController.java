package kr.co.jboard.controller.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.service.UserService;

@WebServlet("/user/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 서비스 가져오기(열거 상수 객체)
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass1");
		String name = req.getParameter("name");
		String nick = req.getParameter("nick");
		String email = req.getParameter("email");
		String auth = req.getParameter("auth");
		String hp = req.getParameter("hp");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String regip = req.getRemoteAddr(); // 사용자 IP주소
		
		// DTO 생성
		UserDTO dto = new UserDTO();
		dto.setUserid(userid);
		dto.setPass(pass);
		dto.setName(name);
		dto.setNick(nick);
		dto.setEmail(email);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setRegip(regip);
		
		// 서비스 호출
		service.register(dto);
		
		// 로그인 이동
		resp.sendRedirect("/jboard/user/login.do?register=success");
	}
}
