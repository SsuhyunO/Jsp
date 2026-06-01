package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {
	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private FileDAO dao = FileDAO.getInstance();
	
	// 기본 서비스 메서드
	public void register(FileDTO dto) {
		dao.insert(dto);
	}

	public FileDTO findById(String fno) {
		return dao.select(fno);
	}

	public List<FileDTO> findAll() {
		return dao.selectAll();
	}

	public void modify(FileDTO dto) {
		dao.update(dto);
	}

	public void remove(String fno) {
		dao.delete(fno);
	}
	
}
