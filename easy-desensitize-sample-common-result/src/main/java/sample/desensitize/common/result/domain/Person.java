package sample.desensitize.common.result.domain;

import com.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import com.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;

public class Person {

	@MaskingField(typeHandler = KeepFirstAndLastHandler.class)
	private String name;

	private String mobile;

	private String idNumber;

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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobile=" + mobile + ", idNumber=" + idNumber + "]";
	}

}
