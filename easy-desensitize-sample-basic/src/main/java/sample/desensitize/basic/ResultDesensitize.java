package sample.desensitize.basic;


import io.github.zhengyuelaii.desensitize.core.EasyDesensitize;
import sample.desensitize.basic.domain.User;
import sample.desensitize.basic.util.Result;

/**
 * 泛型数据脱敏
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-02-25
 */
public class ResultDesensitize {

    public static void main(String[] args) {
        Result<User> result = Result.success(new User("张小凡", "13700001234", "123456"));
        EasyDesensitize.mask(result);
        System.out.println(result);
    }

}
