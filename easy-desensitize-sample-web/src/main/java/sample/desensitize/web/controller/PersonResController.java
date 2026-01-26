package sample.desensitize.web.controller;

import com.github.zhengyuelaii.desensitize.autoconfigure.ResponseMasking;
import io.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import io.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.desensitize.web.domain.Person;
import sample.desensitize.web.handler.IdNumberMaskingHandler;
import sample.desensitize.web.handler.MobileMaskingHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonResController {

    @GetMapping("/list")
    @ResponseMasking(excludeFields = { "name" })
    public List<Person> list() {
        Person person = new Person();
        person.setName("张小凡");
        person.setMobile("13700004586");
        person.setIdNumber("130535202206145195");

        return Collections.singletonList(person);
    }

    @GetMapping("/map")
    @ResponseMasking(fields = {
            @MaskingField(name = "name", typeHandler = KeepFirstAndLastHandler.class),
            @MaskingField(name = "mobile", typeHandler = MobileMaskingHandler.class),
            @MaskingField(name = "idNumber", typeHandler = IdNumberMaskingHandler.class)
    })
    public Map<String, Object> map() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张小凡");
        data.put("mobile", "13700004586");
        data.put("idNumber", "130535202206145195");

        return data;
    }

}
