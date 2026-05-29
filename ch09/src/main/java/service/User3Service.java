package service;

import java.util.List;

import dao.User3DAO;
import dto.User3DTO;

/*
   Service 컴포넌트
   - Controller와 DAO 사이에 상호작용을 대리하는 MVC 모델 컴포넌트
   - Business 로직 처리에 사용하는 컴포넌트
*/

public class User3Service {
	private static User3Service instance = new User3Service();
	public static User3Service getInstance() {
		return instance;
	}
	private User3Service() {}
	
	// DAO 객체 가져오기
	private User3DAO dao = User3DAO.getInsatnce();
	
	//DAO 호출 서비스 메서드
	public void register(User3DTO dto) {
		dao.insert(dto);
	}
	public User3DTO findbyId(String userid) {
		return dao.select(userid);
	}
	public List<User3DTO> findAll() {
		return dao.selectAll();
	}
	public void modify(User3DTO dto) {
		dao.update(dto);
	}
	public void remove(String userid) {
		dao.delete(userid);
	}
}
