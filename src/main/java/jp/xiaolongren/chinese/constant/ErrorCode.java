package jp.xiaolongren.chinese.constant;

public enum ErrorCode {

	// common error
	ACCOUNT_NOT_EXIST("E0001", "登陆用户不存在!"),
	PASSWORD_NOT_CORRECT("E0002", "密码不正确!"),
	ACCOUNT_EXISTED("E0003", "用户名已被注册!"),
	
	// check error
	PASSWORD_UNMATCH("E1001", "两次输入密码不一致！"),
	PASSWORD_MORETHAN6("E1002", "密码必须大于6位！");
	
	private String code;
	private String desc;

	private ErrorCode(String code, String desc) {
		this.setCode(code);
		this.setDesc(desc);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
