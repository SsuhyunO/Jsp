package kr.co.jboard.dao;

import java.util.List;

import kr.co.jboard.dto.TermsDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class TermsDAO extends DBHelper{
	
	// 싱글톤
	private static TermsDAO instance = new TermsDAO();
	public static TermsDAO getInstance() {
		return instance;
	}
	private TermsDAO () {};
	
	// 기본 CRUD 메서드
	public TermsDTO select(String no) {
		TermsDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_TERMS);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new TermsDTO();
				dto.setNo(rs.getInt(1));
				dto.setBasic(rs.getString(2));
				dto.setPrivacy(rs.getString(3));
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<TermsDTO> selectAll() {
		List<TermsDTO> dtoList = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(SQL.SELECT_ALL_TERMS);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				TermsDTO dto = new TermsDTO();
				dto.setNo(rs.getInt(1));
				dto.setBasic(rs.getString(2));
				dto.setPrivacy(rs.getString(3));
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void insert(TermsDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_TERMS);
			psmt.setString(1, dto.getBasic());
			psmt.setString(2, dto.getPrivacy());
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(TermsDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_TERMS);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_TERMS);
			psmt.setString(1, no);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
