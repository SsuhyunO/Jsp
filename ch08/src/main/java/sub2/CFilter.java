package sub2;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/greeting.do")
public class CFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// 해당 필터에서 수행되어야할 처리
		System.out.println("CFilter doFilter...");
		
		// 필터 체인 연결(다음 필터 호출)
		chain.doFilter(req, resp);
	}
}
