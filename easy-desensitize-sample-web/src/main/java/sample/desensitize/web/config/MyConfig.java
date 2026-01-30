package sample.desensitize.web.config;

import io.github.zhengyuelaii.desensitize.interceptor.DesensitizeInterceptorRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试自定义配置类
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-26
 */
@Configuration
public class MyConfig {

    @Bean
    public DesensitizeInterceptorRegistry desensitizeInterceptorRegistry() {
        DesensitizeInterceptorRegistry registry = new DesensitizeInterceptorRegistry();
        registry.addInterceptor(new MyDesensitizeInterceptor())
                .addPathPatterns("/person/**");
        registry.addInterceptor(new NameExcludeInterceptor())
                .addPathPatterns("/user/**");
        return registry;
    }

}
