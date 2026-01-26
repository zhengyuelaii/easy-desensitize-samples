package sample.desensitize.web.handler;

import cn.hutool.core.util.DesensitizedUtil;
import io.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;

/**
 * 手机号脱敏处理器
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-26
 */
public class MobileMaskingHandler implements MaskingHandler {
    @Override
    public String getMaskingValue(String value) {
        return DesensitizedUtil.mobilePhone(value);
    }
}
