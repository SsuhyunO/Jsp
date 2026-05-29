package service;

import java.util.List;

import dao.User2DAO;
import dto.User2DTO;

/*
   Service 컴포넌트
   - Controller와 DAO 사이에 상호작용을 대리하는 MVC 모델 컴포넌트
   - Business 로직 처리에 사용하는 컴포넌트
*/

public class User2Service {
	private static User2Service instance = new User2Service();
	public static User2Service getInstance() {
		return instance;
	}
	private User2Service() {}
	
	// DAO 객체 가져오기
	private User2DAO dao = User2DAO.getInsatnce();
	
	//DAO 호출 서비스 메서드
	public void register(User2DTO dto) {
		dao.insert(dto);
	}
	public User2DTO findbyId(String userid) {
		return dao.select(userid);
	}
	public List<User2DTO> findAll() {
		return dao.selectAll();
	}
	public void modify(User2DTO dto) {
		dao.update(dto);
	}
	public void remove(String userid) {
		dao.delete(userid);
	}
}
