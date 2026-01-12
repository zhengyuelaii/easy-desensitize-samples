package sample.desensitize.basic.domain;

import com.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import com.github.zhengyuelaii.desensitize.core.handler.FixedMaskHandler;
import com.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;

import sample.desensitize.basic.handler.MobileMaskingHandler;

public class User {

	@MaskingField(typeHandler = KeepFirstAndLastHandler.class)
	private String name;

	@MaskingField(typeHandler = MobileMaskingHandler.class)
	private String mobile;

	@MaskingField(typeHandler = FixedMaskHandler.class)
	private String password;

	public User() {
		super();
	}

	public User(String name, String mobile, String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", mobile=" + mobile + ", password=" + password + "]";
	}

}
