package kr.co.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.PageGroupDTO;
import kr.co.jboard.service.ArticleService;

@WebServlet("/article/search.do")
public class SearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 서비스 가져오기(열거 상수 객체)
	private ArticleService service = ArticleService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 파라미터 수신
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		String page = req.getParameter("page");
				
		// 검색용 DTO 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setSearchType(searchType);
		dto.setKeyword(keyword);
		
		// 전체 게시물 갯수 구하기
		int total = service.getcountsearch(dto);
		
		// 현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(page);
		
		// 마지막 페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);
		
		// 현재 페이지 그룹
		PageGroupDTO pageGroupDTO = service.getCurrentPageGroup(currentPage, lastPageNum);
		
		// 현재 페이지 시작번호 구하기
		int pageStart = service.getCurrentStartNum(total, currentPage);
		
		// Limit용 start 계산
		int start = service.getStart(currentPage);
		
		// 검색 키워드 글 목록 조회하기
		List<ArticleDTO> dtoList = service.findAllSearch(dto, start);
				
		// View 참조
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageStart", pageStart);
		req.setAttribute("pageGroupDTO", pageGroupDTO);	
		req.setAttribute("searchType", searchType);	
		req.setAttribute("keyword", keyword);	
		
		
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/search.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
