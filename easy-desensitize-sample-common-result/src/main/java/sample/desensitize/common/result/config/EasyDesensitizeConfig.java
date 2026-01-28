package sample.desensitize.common.result.config;

import io.github.zhengyuelaii.desensitize.resolver.AbstractMaskingDataResolver;
import io.github.zhengyuelaii.desensitize.core.util.MaskingDataResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.desensitize.common.result.util.Page;
import sample.desensitize.common.result.util.ResultMaskingDataResolver;

/**
 * EasyDesensitize 配置类
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-19
 */
@Configuration
public class EasyDesensitizeConfig {

    @Bean
    public ResultMaskingDataResolver resultMaskingDataResolver() {
        return new ResultMaskingDataResolver();
    }

    @Bean
    public MaskingDataResolver<Page<?>> pageMaskingDataResolver() {
        return new AbstractMaskingDataResolver<Page<?>>() {
            @Override
            protected Object resolveInternal(Page<?> source) {
                return source.getRecords().iterator();
            }
        };
    }

}
