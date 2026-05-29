package controller.user1;

import java.io.IOException;
import java.util.List;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/delete.do")
public class DeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Service 가져오기
	private User1Service service = User1Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		
		// 삭제 서비스 메서드 호출
		service.remove(userid);
		
		// 목록 리다이렉트
		resp.sendRedirect("/ch09/user1/list.do?delete=success");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
