package jp.xiaolongren.chinese.bean;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class RegisterPageInfo {
	private long id;
	
	@Length(min=6,max=15,message="用户名必须介于6到15位之间!")
	@Pattern(regexp="[a-z]+[a-z0-9]*",message="用户名必须以字母开头并且只包含字母和数字！")
	private String username;
    
    @Length(min=6,message="密码必须大于6位!")
	private String password;
    
    @Length(min=6,message="密码必须大于6位!")
	private String conformationPwd;
    
	private String name;
    
	private String email;
    
	private String phone;
    
	private String weixin;

	private String address;

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
	
    public String getConformationPwd() {
		return conformationPwd;
	}

	public void setConformationPwd(String conformationPwd) {
		this.conformationPwd = conformationPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RegisterPageInfo [id=" + id + ", username=" + username + ", password=" + password + ", conformationPwd="
				+ conformationPwd + ", name=" + name + ", email=" + email + ", phone=" + phone + ", weixin=" + weixin
				+ ", address=" + address + "]";
	}

}
