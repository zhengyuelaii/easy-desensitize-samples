package sample.desensitize.web.config;

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
    public MyDesensitizeInterceptor myDesensitizeInterceptor() {
        return new MyDesensitizeInterceptor();
    }

}
