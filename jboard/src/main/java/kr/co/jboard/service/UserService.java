package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.UserDAO;
import kr.co.jboard.dto.UserDTO;

public enum UserService {
	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private UserDAO dao = UserDAO.getInstance();
	
	// 기본 서비스 메서드
	public void register(UserDTO dto) {
		dao.insert(dto);
	}

	public UserDTO findById(String userid) {
		return dao.select(userid);
	}
	
	public UserDTO findById(String userid, String pass) {
		return dao.select(userid, pass);
	}

	public List<UserDTO> findAll() {
		return dao.selectAll();
	}

	public void modify(UserDTO dto) {
		dao.update(dto);
	}

	public void remove(String userid) {
		dao.delete(userid);
	}
	
}
