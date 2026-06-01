package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.CommentDAO;
import kr.co.jboard.dto.CommentDTO;

public enum CommentService {
	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private CommentDAO dao = CommentDAO.getInstance();
	
	// 기본 서비스 메서드
	public void register(CommentDTO dto) {
		dao.insert(dto);
	}

	public CommentDTO findById(String cno) {
		return dao.select(cno);
	}

	public List<CommentDTO> findAll() {
		return dao.selectAll();
	}

	public void modify(CommentDTO dto) {
		dao.update(dto);
	}

	public void remove(String cno) {
		dao.delete(cno);
	}
	
}
