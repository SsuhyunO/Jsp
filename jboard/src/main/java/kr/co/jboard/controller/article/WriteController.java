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
import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.service.ArticleService;
import kr.co.jboard.service.FileService;

@WebServlet("/article/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 서비스 가져오기(열거 상수 객체)
	private ArticleService articleService = ArticleService.INSTANCE;
	private FileService fileService = FileService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 파라미터 수신
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();
		
		// 파일 업로드 처리
		List<FileDTO> fileList = fileService.upload(req);
		
		// DTO 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setFile(fileList.size()); // 첨부파일 갯수
		dto.setRegip(regip);
		
		// 글 등록 서비스 요청
		int ano = articleService.register(dto);
		System.out.println(ano);
		
		// 파일 등록 서비스 요청
		for(FileDTO fileDTO:fileList) {
			fileDTO.setAno(ano);
			fileService.register(fileDTO);
		}
		
		// 목록 이동
		resp.sendRedirect("/jboard/article/list.do?write=success");
		
	}
}
