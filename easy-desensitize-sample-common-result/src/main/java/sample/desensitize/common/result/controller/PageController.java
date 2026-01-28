package sample.desensitize.common.result.controller;

import io.github.zhengyuelaii.desensitize.annotation.ResponseMasking;
import io.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.desensitize.common.result.domain.Person;
import sample.desensitize.common.result.handler.MobileMaskingHandler;
import sample.desensitize.common.result.util.Page;

import java.util.Collections;

/**
 *
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-27
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @GetMapping("/get")
    @ResponseMasking(fields = {
            @MaskingField(name = "mobile", typeHandler = MobileMaskingHandler.class)
    })
    public Page<Person> get() {
        Person person = new Person();
        person.setName("李小龙");
        person.setMobile("13888888888");
        person.setIdNumber("420000000000000000");
        Page<Person> page = new Page<>();
        page.setPageNum(1);
        page.setPageSize(10);
        page.setTotal(1);
        page.setRecords(Collections.singletonList(person));
        return page;
    }

}
