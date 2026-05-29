package service;

import java.util.List;

import dao.User1DAO;
import dto.User1DTO;

/*
   Service 컴포넌트
   - Controller와 DAO 사이에 상호작용을 대리하는 MVC 모델 컴포넌트
   - Business 로직 처리에 사용하는 컴포넌트
*/

public class User1Service {
	private static User1Service instance = new User1Service();
	public static User1Service getInstance() {
		return instance;
	}
	private User1Service() {}
	
	// DAO 객체 가져오기
	private User1DAO dao = User1DAO.getInsatnce();
	
	//DAO 호출 서비스 메서드
	public void register(User1DTO dto) {
		dao.insert(dto);
	}
	public User1DTO findbyId(String userid) {
		return dao.select(userid);
	}
	public List<User1DTO> findAll() {
		return dao.selectAll();
	}
	public void modify(User1DTO dto) {
		dao.update(dto);
	}
	public void remove(String userid) {
		dao.delete(userid);
	}
}
