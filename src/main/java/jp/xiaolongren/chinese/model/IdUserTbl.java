package jp.xiaolongren.chinese.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="IdUserTbl")
public class IdUserTbl {
	
	@Id
	@Field("_id")
	private String id;
	
	@Field("username")
	private String username;
	
	@Field("password")
	private String password;
	
	@Field("deleted")
	private String deleted;
	
	@Field("name")
	private String name;
	
	@Field("email")
	private String email;
	
	@Field("phone")
	private String phone;
	
	@Field("weixin")
	private String weixin;
	
	@Field("address")
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
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
		return "IdUserTbl [id=" + id + ", username=" + username + ", password=" + password + ", deleted=" + deleted
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", weixin=" + weixin + ", address="
				+ address + "]";
	}

}
