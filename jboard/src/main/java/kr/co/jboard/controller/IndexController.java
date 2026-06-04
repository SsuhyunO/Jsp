package kr.co.jboard.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;

@WebServlet(urlPatterns = {"/index.do"})
public class IndexController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 여부에 따라 로그인, 글 목록 이동
		HttpSession session = req.getSession();
		UserDTO userDTO = (UserDTO)session.getAttribute("sessUser");
		
		if(userDTO != null) {
			// 글 목록 이동
			resp.sendRedirect("/jboard/article/list.do");
		}else {
			// 로그인 이동
			resp.sendRedirect("jboard/user/login.do");
		}
	}
}
