package kr.co.jboard.dto;

public class PageGroupDTO {
	private int Start;
	private int End;
	
	public PageGroupDTO(int start, int end) {
		this.Start = start;
		this.End = end;
	}
	
	public int getStart() {
		return Start;
	}
	public void setStart(int start) {
		Start = start;
	}
	
	public int getEnd() {
		return End;
	}
	public void setEnd(int end) {
		End = end;
	}
}
