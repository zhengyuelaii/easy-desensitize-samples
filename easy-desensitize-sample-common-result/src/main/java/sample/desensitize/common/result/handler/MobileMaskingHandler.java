package sample.desensitize.common.result.handler;

import io.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;
import io.github.zhengyuelaii.desensitize.core.util.Masker;

/**
 * 手机号脱敏
 */
public class MobileMaskingHandler implements MaskingHandler {

	@Override
	public String getMaskingValue(String value) {
		return Masker.hide(value, 3, 7);
	}

}
