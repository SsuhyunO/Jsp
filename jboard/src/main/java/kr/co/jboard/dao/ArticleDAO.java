package kr.co.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class ArticleDAO extends DBHelper{
	
	// 싱글톤
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO () {};
	
	// 기본 CRUD 메서드
	public int selectCount() {
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(SQL.SELECT_COUNT_ARTICLE);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public int selectCountSearch(ArticleDTO articleDTO) {
		int total = 0;
		
		// 동적 쿼리 생성
		StringBuilder sql = new StringBuilder(SQL.SELECT_COUNT_ARTICLE_JOIN);
		
		if(articleDTO.getSearchType().equals("title")) {
			sql.append(SQL.WHERE_TITLE_KEYWORD);
		}else if(articleDTO.getSearchType().equals("content")) {
			sql.append(SQL.WHERE_CONTENT_KEYWORD);
		}else if(articleDTO.getSearchType().equals("writer")) {
			sql.append(SQL.WHERE_NICK_KEYWORD);
		}
		
		try {
			conn = getConnection();
			psmt = conn.prepareCall(sql.toString());
			psmt.setString(1, "%"+articleDTO.getKeyword()+"%");
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public ArticleDTO select(String ano) {
		ArticleDTO dto = null;
		List<FileDTO> fileList = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, ano);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				if(dto == null) {
					dto = new ArticleDTO();
					dto.setAno(rs.getInt(1));
					dto.setType(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setComment(rs.getInt(5));
					dto.setFile(rs.getInt(6));
					dto.setHit(rs.getInt(7));
					dto.setWriter(rs.getString(8));
					dto.setRegip(rs.getString(9));
					dto.setWdate(rs.getString(10));
					dto.setNick(rs.getString(11));
				}
				FileDTO fileDTO = new FileDTO();
				fileDTO.setFno(rs.getInt(12));
				fileDTO.setAno(rs.getInt(13));
				fileDTO.setOfname(rs.getString(14));
				fileDTO.setSfname(rs.getString(15));
				fileDTO.setDownload(rs.getInt(16));
				fileDTO.setRdate(rs.getString(17));
				fileList.add(fileDTO);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dto.setFileList(fileList);
		
		return dto;
	}
	
	public List<ArticleDTO> selectAll(int start) {
		List<ArticleDTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ALL_ARTICLE);
			psmt.setInt(1, start); // 0: 1페이지, 10: 2페이지, 20: 3페이지 ...
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setAno(rs.getInt(1));
				dto.setType(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public List<ArticleDTO> selectAllSearch(ArticleDTO articleDTO, int start) {
		List<ArticleDTO> dtoList = new ArrayList<>();
		
		// 동적 쿼리 생성
		StringBuilder sql = new StringBuilder(SQL.SELECT_ALL_ARTICLE_JOIN);
		
		if(articleDTO.getSearchType().equals("title")) {
			sql.append(SQL.WHERE_TITLE_KEYWORD);
			sql.append(SQL.ORDER_LIMIT);
		}else if(articleDTO.getSearchType().equals("content")) {
			sql.append(SQL.WHERE_CONTENT_KEYWORD);
			sql.append(SQL.ORDER_LIMIT);
		}else if(articleDTO.getSearchType().equals("writer")) {
			sql.append(SQL.WHERE_NICK_KEYWORD);
			sql.append(SQL.ORDER_LIMIT);
		}
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, "%" + articleDTO.getKeyword() + "%");
			psmt.setInt(2, start); // 0: 1페이지, 10: 2페이지, 20: 3페이지 ...
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setAno(rs.getInt(1));
				dto.setType(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				dtoList.add(dto);
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public int insert(ArticleDTO dto) {
		int ano = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getRegip());
			psmt.executeUpdate();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_MAX_ANO);
			
			if(rs.next()) {
				ano = rs.getInt(1);
			}
			
			conn.commit();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				
			}
		}
		return ano;
	}
	
	public void updateHit(String ano) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_HIT);
			psmt.setString(1, ano);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(ArticleDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getAno());
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String ano) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ARTICLE);
			psmt.setString(1, ano);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
