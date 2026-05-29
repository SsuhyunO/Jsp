package dto;

/* 
	DTO(Data Transfer Object) 
	- MVC 컴포넌트(Controller-serivce-dao) 간 데이터 교환을 위한 객체
	- 데이터베이스 테이블 튜플 객체(Entity, 테이블의 컬럼을 속성으로 갖는 객체)
*/
public class User4DTO {
	private String userid;
	private String name;
	private String gender;
	private int age;
	private String hp;
	private String addr;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "User4DTO [userid=" + userid + ", name=" + name + ", gender=" + gender + ", age=" + age + ", hp=" + hp
				+ ", addr=" + addr + "]";
	}
}
