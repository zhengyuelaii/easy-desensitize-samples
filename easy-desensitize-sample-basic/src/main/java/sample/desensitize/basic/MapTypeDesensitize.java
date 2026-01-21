package sample.desensitize.basic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.github.zhengyuelaii.desensitize.core.EasyDesensitize;

import sample.desensitize.basic.domain.User;

public class MapTypeDesensitize {
	
	public static void main(String[] args) {
		User user1 = new User("李小鹏", "13700001234", "123456");
		User user2 = new User("张三", "13888880000", "456789");
		
		// Map脱敏
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("data", user1);
		map.put("list", Collections.singleton(user2));
		
		EasyDesensitize.mask(map);
		System.out.println(map);
	}

}
