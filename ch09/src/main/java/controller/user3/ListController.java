package controller.user3;

import java.io.IOException;
import java.util.List;

import dto.User3DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Service 가져오기
	private User3Service service = User3Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// User1 데이터 요청
		List<User3DTO> dtoList = service.findAll();
		
		// View 데이터 참조(Controller에서 View로 forward하기 때문에 Cotroller와 View는 같은 Request Scope를 가짐)
		req.setAttribute("dtoList", dtoList); // View(JSP)에서 dtoList를 참조할 수 있게됨
		
		// View forward
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/views/user3/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
