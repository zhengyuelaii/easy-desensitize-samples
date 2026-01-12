package sample.desensitize.basic;

import java.util.Collections;

import com.github.zhengyuelaii.desensitize.core.EasyDesensitize;

import sample.desensitize.basic.domain.User;
import sample.desensitize.basic.handler.PageDataResoler;
import sample.desensitize.basic.util.Page;

public class PageWrapperDesensitize {
	
	public static void main(String[] args) {
		Page<User> page = new Page<>();
		page.setPageNum(1);
		page.setPageSize(10);
		
		User user = new User();
		user.setName("张小凡");
		user.setMobile("13700001234");
		user.setPassword("123456");
		page.setData(Collections.singletonList(user));
		
		// 执行脱敏
		EasyDesensitize.mask(page, new PageDataResoler());
		// 执行脱敏
//		EasyDesensitize.mask(page, p -> p.getData().iterator());
		System.out.println(page);
	}

}
