package service;

import java.util.List;

import dao.User4DAO;
import dto.User4DTO;

/*
   Service 컴포넌트
   - Controller와 DAO 사이에 상호작용을 대리하는 MVC 모델 컴포넌트
   - Business 로직 처리에 사용하는 컴포넌트
*/

public class User4Service {
	private static User4Service instance = new User4Service();
	public static User4Service getInstance() {
		return instance;
	}
	private User4Service() {}
	
	// DAO 객체 가져오기
	private User4DAO dao = User4DAO.getInsatnce();
	
	//DAO 호출 서비스 메서드
	public void register(User4DTO dto) {
		dao.insert(dto);
	}
	public User4DTO findbyId(String userid) {
		return dao.select(userid);
	}
	public List<User4DTO> findAll() {
		return dao.selectAll();
	}
	public void modify(User4DTO dto) {
		dao.update(dto);
	}
	public void remove(String userid) {
		dao.delete(userid);
	}
}
