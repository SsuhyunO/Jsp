package kr.co.jboard.dto;

import java.util.List;

public class ArticleDTO {
	private int ano;
	private String type;
	private String title;
	private String content;
	private int comment;
	private int file;
	private int hit;
	private String writer;
	private String regip;
	private String wdate;
	
	// 추가 필드
	private String nick;
	private List<FileDTO> fileList;
	
	// 검색용 추가필드
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public List<FileDTO> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileDTO> fileList) {
		this.fileList = fileList;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getWdate() {
		return wdate.substring(2, 16);
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	@Override
	public String toString() {
		return "ArticleDTO [ano=" + ano + ", type=" + type + ", title=" + title + ", content=" + content + ", comment="
				+ comment + ", file=" + file + ", hit=" + hit + ", writer=" + writer + ", regip=" + regip + ", wdate="
				+ wdate + "]";
	}
}
