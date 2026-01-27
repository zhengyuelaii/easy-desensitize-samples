package sample.desensitize.common.result.controller;

import io.github.zhengyuelaii.desensitize.autoconfigure.ResponseMasking;
import io.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import io.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.desensitize.common.result.domain.Person;
import sample.desensitize.common.result.handler.MobileMaskingHandler;
import sample.desensitize.common.result.util.Result;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-19
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/one")
    @ResponseMasking(fields = {
            @MaskingField(name = "mobile", typeHandler = MobileMaskingHandler.class)
    })
    public Result<Person> one() {
        Person person = new Person();
        person.setName("张小凡");
        person.setMobile("13700004586");
        person.setIdNumber("130535202206145195");
        return Result.success(person);
    }

    @GetMapping("/map/get")
    @ResponseMasking(fields = {
            @MaskingField(name = "name", typeHandler = KeepFirstAndLastHandler.class),
            @MaskingField(name = "mobile", typeHandler = MobileMaskingHandler.class)
    })
    public Map<String, Object> mapGet() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("name", "张小凡");
        resultMap.put("mobile", "13700004586");
        resultMap.put("idNumber", "130535202206145195");
        return resultMap;
    }

}