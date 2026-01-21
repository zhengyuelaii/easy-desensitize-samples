package sample.desensitize.basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.github.zhengyuelaii.desensitize.core.EasyDesensitize;
import io.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;
import io.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;
import io.github.zhengyuelaii.desensitize.core.util.Masker;

import sample.desensitize.basic.domain.TestNode;

public class ProgrammaDesensitize {

	public static void main(String[] args) {
		// 准备数据
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("name", "张三");

		TestNode node = new TestNode("王小华", "13700001234");
		data.put("node", node);

		// 定义脱敏处理器
		Map<String, MaskingHandler> handler = new HashMap<>();
		handler.put("name", new KeepFirstAndLastHandler()); // 基于key自动匹配Map、Bean同名字段进行脱敏
		handler.put("mobile", value -> Masker.hide(value, 3, 7));
		
		// 执行脱敏
		EasyDesensitize.mask(data, handler);
		System.out.println(data);
	}

}
