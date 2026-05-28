package sub1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// 서블릿이 최초 요청될 때 한 번만 실행
		System.out.println("HelloServlet init...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET 요청 처리
		System.out.println("HelloServlet doGet...");
		
		// HTML 생성
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("<title>HelloServlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h3>HelloServlet</h3>");
		writer.println("<a href='1_ServletTest.jsp'>메인</a>");
		writer.println("<a href='welcome.do'>WelcomeServlet</a>");
		writer.println("<a href='greeting.do'>GreetingServlet</a>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST 요청 처리
		System.out.println("HelloServlet doPost...");
		
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		System.out.println("아이디 : " + userid);
		System.out.println("비밀번호 : " + pass);
		
		// 리다이렉트
		resp.sendRedirect("welcome.do");
	}
	
	@Override
	public void destroy() {
		// 서블릿이 종료될 때(WAS가 종료될 때)
		System.out.println("HelloServlet destroy...");
	}
}
