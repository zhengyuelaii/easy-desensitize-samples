package sample.desensitize.web.handler;

import cn.hutool.core.util.DesensitizedUtil;
import io.github.zhengyuelaii.desensitize.core.handler.MaskingHandler;

/**
 * 身份证脱敏处理器
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-26
 */
public class IdNumberMaskingHandler implements MaskingHandler {
    @Override
    public String getMaskingValue(String value) {
        return DesensitizedUtil.idCardNum(value, 2, 2);
    }
}
