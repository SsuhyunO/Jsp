package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.TermsDAO;
import kr.co.jboard.dto.TermsDTO;

public enum TermsService {
	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private TermsDAO dao = TermsDAO.getInstance();
	
	// 기본 서비스 메서드
	public void register(TermsDTO dto) {
		dao.insert(dto);
	}

	public TermsDTO findById(String no) {
		return dao.select(no);
	}

	public List<TermsDTO> findAll() {
		return dao.selectAll();
	}

	public void modify(TermsDTO dto) {
		dao.update(dto);
	}

	public void remove(String no) {
		dao.delete(no);
	}
	
}
