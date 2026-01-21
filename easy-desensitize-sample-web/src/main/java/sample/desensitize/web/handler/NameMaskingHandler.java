package sample.desensitize.web.handler;

import io.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;
import io.github.zhengyuelaii.desensitize.core.util.Masker;

public class NameMaskingHandler implements MaskingHandler {

	@Override
	public String getMaskingValue(String value) {
		return Masker.hide(value, 1, value.length() - 1);
	}

}
