package kr.co.jboard.controller.user;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.service.UserService;

@WebServlet("/user/check.do")
public class CheckController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 서비스 가져오기(열거 상수 객체)
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 데이터 수신
		String type = req.getParameter("type");
		String value = req.getParameter("value");
		
		int count = service.getCount(type, value);
		
		// 이메일 인증코드 전송
		if(type.equals("email") && count < 1) {
			int code = service.sendEmailCode(value);
			
			// 인증 코드 세션 저장
			HttpSession session = req.getSession();
			session.setAttribute("sessCode", String.valueOf(code));
		}
		
		// 결과용 JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("count", count); // 0: 사용가능, 1: 존재하는 아이디
		
		// JSON 전송
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print(json.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 인증코드 수신
		String code = req.getParameter("code");
		System.out.println(code);
		
		// 세션에 저장한 인증코드 가져오기
		HttpSession session = req.getSession();
		String sessCode = (String)session.getAttribute("sessCode");
		System.out.println(sessCode);
		
		JsonObject json = new JsonObject();
		
		// 인증코드 일치여부 검사
		if(sessCode.equals(code)) {
			json.addProperty("count", 0); // 0: 인증완료, 1: 인증코드 불일치
		}else {
			json.addProperty("count", 1); // 0: 인증완료, 1: 인증코드 불일치
		}
		
		// JSON 전송
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print(json.toString());
	}
}
