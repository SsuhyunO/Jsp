package kr.co.jboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;

@WebFilter(urlPatterns = {"/article/*"})
public class LoginCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 기본 ServletRequest를 HttpServletRequest로 변환
		HttpServletRequest request = (HttpServletRequest)req;
		
		// 현재 사용자 세션 구하기
		HttpSession session = request.getSession();
		UserDTO sessUser = (UserDTO)session.getAttribute("sessUser");
		
		if(sessUser == null) {
			// 로그인을 하지 않으면 로그인페이지로 이동
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect("/jboard/user/login.do?login=required");
		
		}else {
			// 로그인을 했으면 해당 표청 페이지로 이동
			chain.doFilter(req, resp);
		}
		
	}

}
