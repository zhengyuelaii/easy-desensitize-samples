package sample.desensitize.basic;

import java.util.Collections;
import java.util.List;

import io.github.zhengyuelaii.desensitize.core.EasyDesensitize;

import sample.desensitize.basic.domain.User;

public class ListTypeDesensitize {

	public static void main(String[] args) {
		User user = new User();
		user.setName("李小鹏");
		user.setMobile("13700001234");
		user.setPassword("123456");
		
		// List脱敏
		List<User> list = Collections.singletonList(user);
		EasyDesensitize.mask(list);
		System.out.println(list);
	}
	
}
