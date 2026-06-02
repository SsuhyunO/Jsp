package kr.co.jboard.dao;

import java.util.List;

import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class UserDAO extends DBHelper{
	
	// 싱글톤
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO () {};
	
	// 기본 CRUD 메서드
	public UserDTO select(String userid) {
		UserDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUserid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setNick(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setHp(rs.getString(6));
				dto.setRole(rs.getString(7));
				dto.setZip(rs.getString(8));
				dto.setAddr1(rs.getString(9));
				dto.setAddr2(rs.getString(10));
				dto.setRegip(rs.getString(11));
				dto.setRegDate(rs.getString(12));
				dto.setLeaveDate(rs.getString(13));
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public UserDTO select(String userid, String pass) {
		UserDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER_WITH_PASS);
			psmt.setString(1, userid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUserid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setNick(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setHp(rs.getString(6));
				dto.setRole(rs.getString(7));
				dto.setZip(rs.getString(8));
				dto.setAddr1(rs.getString(9));
				dto.setAddr2(rs.getString(10));
				dto.setRegip(rs.getString(11));
				dto.setRegDate(rs.getString(12));
				dto.setLeaveDate(rs.getString(13));
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<UserDTO> selectAll() {
		List<UserDTO> dtoList = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(SQL.SELECT_ALL_USER);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUserid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setNick(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setHp(rs.getString(6));
				dto.setRole(rs.getString(7));
				dto.setZip(rs.getString(8));
				dto.setAddr1(rs.getString(9));
				dto.setAddr2(rs.getString(10));
				dto.setRegip(rs.getString(11));
				dto.setRegDate(rs.getString(12));
				dto.setLeaveDate(rs.getString(13));
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void insert(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER);
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getNick());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.setString(10, dto.getRegip());
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_USER);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String userid) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_USER);
			psmt.setString(1, userid);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
