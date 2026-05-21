package sub1;

public class User1 {
	private String userid;
	private String name;
	private String birth;
	private String hp;
	private int age;
	
	public User1() {};
	
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
	
	@Override
	public String toString() {
		return "User1 [userid=" + userid + ", name=" + name + ", birth=" + birth + ", hp=" + hp + ", age=" + age + "]";
	}
	
	
}
