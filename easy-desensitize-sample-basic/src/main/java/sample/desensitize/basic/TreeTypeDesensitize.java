package sample.desensitize.basic;

import java.util.Arrays;

import io.github.zhengyuelaii.desensitize.core.EasyDesensitize;

import sample.desensitize.basic.domain.TreeVO;

public class TreeTypeDesensitize {

	public static void main(String[] args) {
		TreeVO root = new TreeVO();
		root.setId("1");
		root.setName("XXX有限公司");
		
		TreeVO t1 = new TreeVO();
		t1.setId("1001");
		t1.setName("行政部");

		TreeVO t2 = new TreeVO();
		t2.setId("1001");
		t2.setName("研发部");
		
		root.setChildren(Arrays.asList(t1, t2));
		EasyDesensitize.mask(root);
		System.out.println(root);
	}
	
}
