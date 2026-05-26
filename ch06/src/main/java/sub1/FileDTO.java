package sub1;

public class FileDTO {
	
	private int no;
	private String userid;
	private String name;
	private String ofname;
	private String sfname;
	private String rdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOfname() {
		return ofname;
	}
	public void setOfname(String ofname) {
		this.ofname = ofname;
	}
	public String getSfname() {
		return sfname;
	}
	public void setSfname(String sfname) {
		this.sfname = sfname;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "FileDTO [no=" + no + ", userid=" + userid + ", name=" + name + ", ofname=" + ofname + ", sfname="
				+ sfname + ", rdate=" + rdate + "]";
	}
}