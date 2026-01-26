package sample.desensitize.web.domain;

import io.github.zhengyuelaii.desensitize.core.annotation.MaskingField;

import sample.desensitize.web.handler.IdNumberMaskingHandler;
import sample.desensitize.web.handler.MobileMaskingHandler;
import sample.desensitize.web.handler.NameMaskingHandler;

public class Person {

	@MaskingField(typeHandler = NameMaskingHandler.class)
	private String name;

	@MaskingField(typeHandler = MobileMaskingHandler.class)
	private String mobile;

	@MaskingField(typeHandler = IdNumberMaskingHandler.class)
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
