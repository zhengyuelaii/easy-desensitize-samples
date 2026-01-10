package sample.desensitize.web.handler;

import com.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;
import com.github.zhengyuelaii.desensitize.core.util.Masker;

public class NameMaskingHandler implements MaskingHandler {

	@Override
	public String getMaskingValue(String value) {
		return Masker.hide(value, 1, value.length() - 1);
	}

}
