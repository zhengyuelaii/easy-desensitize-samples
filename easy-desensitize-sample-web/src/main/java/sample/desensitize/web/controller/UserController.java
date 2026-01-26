package sample.desensitize.web.controller;

import com.github.zhengyuelaii.desensitize.autoconfigure.ResponseMasking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.desensitize.web.domain.User;

/**
 * UserController
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    @ResponseMasking
    public User get() {
        return new User( "李小龙", "12345678", "上海");
    }

}
