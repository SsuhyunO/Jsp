package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User3DTO;
import util.DBHelper;
import util.SQL;

// DAO(Data Access Object) : 데이터베이스와 상호작용(SQL 처리)하는 MVC 컴포넌트
public class User3DAO extends DBHelper{
	// 싱글톤
	public static User3DAO insatnce = new User3DAO();
	public static User3DAO getInsatnce() {
		return insatnce;
	}
	private User3DAO() {};
	
	// 기본 CRUD 메서드
	public void insert(User3DTO dto) {
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.INSERT_USER3);
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getAddr());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User3DTO select(String userid) {
		User3DTO dto = null;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.SELECT_USER3);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new User3DTO();
				dto.setUserid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAddr(rs.getString(5));				
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<User3DTO> selectAll() {
		List<User3DTO> dtoList = new ArrayList<>();
		try {
			conn = getConnection();
								
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ALL_USER3);
			
			while(rs.next()) {
				User3DTO dto = new User3DTO();
				dto.setUserid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAddr(rs.getString(5));	
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void update(User3DTO dto) {
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.UPDATE_USER3);
			psmt.setString(5, dto.getUserid());
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void delete(String userid) {
		try {
			conn = getConnection();
			
			PreparedStatement psmt = conn.prepareStatement(SQL.DELETE_USER3);
			psmt.setString(1, userid);
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
