package sample.desensitize.common.result.util;

import io.github.zhengyuelaii.desensitize.autoconfigure.AbstractMaskingDataResolver;

/**
 *
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-19
 */
public class ResultMaskingDataResolver extends AbstractMaskingDataResolver<Result<?>> {

    @Override
    protected Object resolveInternal(Result<?> source) {
        return source.getData();
    }

}
