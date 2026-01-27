package sample.desensitize.web.config;

import io.github.zhengyuelaii.desensitize.autoconfigure.EasyDesensitizeInterceptor;
import org.springframework.core.MethodParameter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

import java.util.List;
import java.util.Objects;

/**
 * 自定义拦截器
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-26
 */
public class MyDesensitizeInterceptor implements EasyDesensitizeInterceptor {

    @Override
    public boolean preHandle(Object body, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        String userId = request.getHeaders().getFirst("x-user-id");
        return !Objects.equals("1", userId);
    }

    @Override
    public void postHandle(Object body, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println(body);
    }

    @Override
    public void onException(Exception ex, Object body, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        ex.printStackTrace();
    }
}
