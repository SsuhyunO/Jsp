package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User1DTO;
import util.DBHelper;
import util.SQL;

// DAO(Data Access Object) : 데이터베이스와 상호작용(SQL 처리)하는 MVC 컴포넌트
public class User1DAO extends DBHelper{
	// 싱글톤
	public static User1DAO insatnce = new User1DAO();
	public static User1DAO getInsatnce() {
		return insatnce;
	}
	private User1DAO() {};
	
	// 기본 CRUD 메서드
	public void insert(User1DTO dto) {
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.INSERT_USER1);
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getHp());
			psmt.setInt(5, dto.getAge());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User1DTO select(String userid) {
		User1DTO dto = null;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.SELECT_USER1);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new User1DTO();
				dto.setUserid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAge(rs.getInt(5));				
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<User1DTO> selectAll() {
		List<User1DTO> dtoList = new ArrayList<>();
		try {
			conn = getConnection();
								
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ALL_USER1);
			
			while(rs.next()) {
				User1DTO dto = new User1DTO();
				dto.setUserid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAge(rs.getInt(5));	
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void update(User1DTO dto) {
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.UPDATE_USER1);
			psmt.setString(5, dto.getUserid());
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void delete(String userid) {
		try {
			conn = getConnection();
			
			PreparedStatement psmt = conn.prepareStatement(SQL.DELETE_USER1);
			psmt.setString(1, userid);
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
