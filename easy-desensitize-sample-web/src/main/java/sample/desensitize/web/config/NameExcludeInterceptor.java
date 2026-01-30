package sample.desensitize.web.config;

import io.github.zhengyuelaii.desensitize.advice.ResponseMaskingContext;
import io.github.zhengyuelaii.desensitize.interceptor.EasyDesensitizeInterceptor;
import org.springframework.core.MethodParameter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

/**
 * 自定义拦截器
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-29
 */
public class NameExcludeInterceptor implements EasyDesensitizeInterceptor {

    @Override
    public boolean preHandle(Object body, ResponseMaskingContext context, MethodParameter returnType,
                             ServerHttpRequest request, ServerHttpResponse response) {
        context.addExcludedField("username");
        return true;
    }
}
