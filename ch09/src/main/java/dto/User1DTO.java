package dto;

/* 
	DTO(Data Transfer Object) 
	- MVC 컴포넌트(Controller-serivce-dao) 간 데이터 교환을 위한 객체
	- 데이터베이스 테이블 튜플 객체(Entity, 테이블의 컬럼을 속성으로 갖는 객체)
*/
public class User1DTO {
	private String userid;
	private String name;
	private String birth;
	private String hp;
	private int age;
	
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAge(String age) {
		if(age != null) {
			this.age = Integer.parseInt(age);
		}
	}
	
	@Override
	public String toString() {
		return "User1DTO [userid=" + userid + ", name=" + name + ", birth=" + birth + ", hp=" + hp + ", age=" + age
				+ "]";
	}
}
