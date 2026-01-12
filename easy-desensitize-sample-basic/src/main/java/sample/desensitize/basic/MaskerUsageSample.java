package sample.desensitize.basic;

import com.github.zhengyuelaii.desensitize.core.util.Masker;

public class MaskerUsageSample {

	public static void main(String[] args) {
		System.out.println("========= 1. 基础脱敏 (指定索引) =========");
        String raw = "1234567890";
        // 脱敏索引 3 到 7 (即：4567)
        String basic = Masker.hide(raw, 3, 7);
        System.out.println("原字符串: " + raw);
        System.out.println("脱敏结果: " + basic); // 123****890

        System.out.println("\n========= 2. 自定义掩码字符 =========");
        // 使用 '#' 代替 '*'
        String customChar = Masker.hide(raw, "#", 3, 7);
        System.out.println("自定义掩码 (#): " + customChar); // 123####890

        System.out.println("\n========= 3. 常见业务场景模拟 =========");
        
        // 手机号脱敏示例 (保留前3后4)
        String phone = "13812345678";
        String maskedPhone = Masker.hide(phone, 3, phone.length() - 4);
        System.out.println("手机号脱敏: " + maskedPhone); // 138****5678

        // 姓名脱敏示例 (保留第1位)
        String name = "张无忌";
        String maskedName = Masker.hide(name, 1, name.length());
        System.out.println("姓名脱敏: " + maskedName); // 张**
	}
	
}
