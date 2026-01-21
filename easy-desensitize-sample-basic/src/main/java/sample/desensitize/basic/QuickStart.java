package sample.desensitize.basic;

import io.github.zhengyuelaii.desensitize.core.EasyDesensitize;

import sample.desensitize.basic.domain.User;

public class QuickStart {
	
	public static void main(String[] args) {
		User user = new User();
		user.setName("张小凡");
		user.setMobile("13700001234");
		user.setPassword("123456");
		
		EasyDesensitize.mask(user);
		System.out.println(user);
	}

}
