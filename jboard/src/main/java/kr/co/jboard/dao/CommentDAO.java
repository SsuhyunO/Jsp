package kr.co.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.jboard.dto.CommentDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class CommentDAO extends DBHelper{
	
	// 싱글톤
	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	private CommentDAO () {};
	
	// 기본 CRUD 메서드
	public CommentDTO select(String cno) {
		CommentDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENT);
			psmt.setString(1, cno);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setRegip(rs.getString(5));
				dto.setWdate(rs.getString(6));
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<CommentDTO> selectAll() {
		List<CommentDTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(SQL.SELECT_ALL_COMMENT);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setRegip(rs.getString(5));
				dto.setWdate(rs.getString(6));
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void insert(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String cno) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, cno);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
