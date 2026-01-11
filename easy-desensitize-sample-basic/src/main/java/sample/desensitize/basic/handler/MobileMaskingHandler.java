package sample.desensitize.basic.handler;

import com.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;
import com.github.zhengyuelaii.desensitize.core.util.Masker;

/**
 * 手机号脱敏
 */
public class MobileMaskingHandler implements MaskingHandler {

	@Override
	public String getMaskingValue(String value) {
		return Masker.hide(value, 3, 7);
	}

}
