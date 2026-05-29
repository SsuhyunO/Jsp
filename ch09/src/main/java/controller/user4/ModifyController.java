package controller.user4;

import java.io.IOException;

import dto.User4DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/modify.do")
public class ModifyController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// 서비스 가져오기
	private User4Service service = User4Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		
		// 수정 데이터 조회
		User4DTO dto = service.findbyId(userid);
		
		// View 데이터 참조
		req.setAttribute("user4DTO", dto);
		
		// View forward
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/views/user4/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String hp = req.getParameter("hp");
		String addr = req.getParameter("addr");
		
		// 서비스 전송 객체 생성
		User4DTO dto = new User4DTO();
		dto.setUserid(userid);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(Integer.parseInt(age));
		dto.setHp(hp);
		dto.setAddr(addr);
		
		
		// 수정 서비스 메서드 호출
		service.modify(dto);
		
		// 목록 리다이렉트
		resp.sendRedirect("/ch09/user4/list.do?modify=success");
	}
	
}
