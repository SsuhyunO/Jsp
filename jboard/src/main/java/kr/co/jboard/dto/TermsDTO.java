package kr.co.jboard.dto;

public class TermsDTO {
	private int no;
	private String basic;
	private String privacy;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	
	@Override
	public String toString() {
		return "TermsDTO [no=" + no + ", basic=" + basic + ", privacy=" + privacy + "]";
	}
}
