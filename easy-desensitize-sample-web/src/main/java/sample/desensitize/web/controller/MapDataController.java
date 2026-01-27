package sample.desensitize.web.controller;

import io.github.zhengyuelaii.desensitize.autoconfigure.IgnoreResponseMasking;
import io.github.zhengyuelaii.desensitize.autoconfigure.ResponseMasking;
import io.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.desensitize.web.handler.MobileMaskingHandler;
import sample.desensitize.web.handler.NameMaskingHandler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-26
 */
@RestController
@RequestMapping("/map")
@ResponseMasking(fields = {
        @MaskingField(name = "name", typeHandler = NameMaskingHandler.class),
        @MaskingField(name = "mobile", typeHandler = MobileMaskingHandler.class)
})
public class MapDataController {

    @GetMapping("/get")
    public Map<String, Object> list() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张小凡");
        data.put("mobile", "13888888888");
        return data;
    }

    @GetMapping("/ignore")
    @IgnoreResponseMasking
    public Map<String,  Object> ignore() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张小凡");
        data.put("mobile", "13888888888");
        return data;
    }

}
