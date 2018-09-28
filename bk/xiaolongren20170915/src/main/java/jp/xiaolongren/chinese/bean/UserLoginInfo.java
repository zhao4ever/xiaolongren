package jp.xiaolongren.chinese.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserLoginInfo {
	private long id;
	
    @NotEmpty(message="Name couldn't be blank.")
	private String username;
    

    @NotEmpty(message="Password shouldn't be blank.")
    @Length(min=6,message="password should be more than 6.")
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserLoginInfo [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
