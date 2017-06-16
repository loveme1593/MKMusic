package global.sesoc.music.vo;

/**
 * 회원 정보 VO 
 */
public class UserVO {
	String user_id;			//아이디
	String user_password;	//비밀번호
	String user_name;		//이름
	String user_type;
	int user_password_q;
	String user_password_a;
	
	
	public UserVO() {
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_type() {
		return user_type;
	}


	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}


	public int getUser_password_q() {
		return user_password_q;
	}


	public void setUser_password_q(int user_password_q) {
		this.user_password_q = user_password_q;
	}


	public String getUser_password_a() {
		return user_password_a;
	}


	public void setUser_password_a(String user_password_a) {
		this.user_password_a = user_password_a;
	}


	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_type=" + user_type + ", user_password_q=" + user_password_q + ", user_password_a="
				+ user_password_a + "]";
	}
	
}
