package controller.user2;

import java.io.IOException;

import dto.User2DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User2Service;

@WebServlet("/user2/register.do")
public class RegisterCtroller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// 서비스 가져오기
	private User2Service service = User2Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View forward
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/views/user2/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String addr = req.getParameter("addr");
		
		// 서비스 전송 객체 생성
		User2DTO dto = new User2DTO();
		dto.setUserid(userid);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setAddr(addr);
		
		// 등록 서비스 메서드 호출
		service.register(dto);
		
		// 목록 리다이렉트
		resp.sendRedirect("/ch09/user2/list.do?register=success");
	}
	
}
