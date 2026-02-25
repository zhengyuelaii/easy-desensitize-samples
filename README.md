# Easy Desensitize：Java 高性能脱敏引擎的试用与实测

在企业级应用开发中，数据脱敏是合规性的刚需。然而，开发者往往在“功能完整性”与“系统性能”之间面临权衡：基于 AOP 的方案难以穿透复杂的嵌套对象（如 List<Map>），而基于 Jackson 序列化的方案又难以应用于非 Web 输出场景（如 Excel 导出、日志记录）。

开源项目 easy-desensitize 提供了一个值得关注的解法。该框架通过精简的反射缓存架构，在保证深度递归处理的同时，将损耗压制在了纳秒级别。

## 核心特性

- **高性能**：基于反射缓存的零拷贝架构，性能损耗极低
- **全场景支持**：兼容 Web API、Excel 导出、日志记录等多种使用场景
- **智能识别**：自动处理 List、Map、数组及多层嵌套对象
- **灵活扩展**：支持自定义脱敏策略和处理器
- **无缝集成**：提供 Spring Boot Starter，一键开启全局脱敏

## 1. 概述
`easy-desensitize-core`是一个独立于业务逻辑的`Java`脱敏引擎。其核心价值在于提供了一套结构自适应的脱敏机制。

该框架不依赖特定的 Web 容器，其底层设计避开了高开销的正则表达式，转而采用基于字符索引的高效切分算法。它最显著的特征是能够自动探测对象图（Object Graph），在处理包含集合、Map、数组以及多层嵌套 Bean 的复杂数据模型时，表现出了极高的鲁棒性。

## 2. 快速开始
该框架遵循“声明式定义，编程式调用”的设计原则，接入成本极低。

### 2.1 依赖引入
在 Maven 项目中引入核心库

```xml
<dependency>
    <groupId>io.github.zhengyuelaii</groupId>
    <artifactId>easy-desensitize-core</artifactId>
    <version>${latest.version}</version> <!-- 使用变量替换最新版本 -->
</dependency>
```
### 2.2 规则标注

定义脱敏处理器
```java
/**
 * 手机号脱敏处理器示例
 */
public class MobileMaskingHandler implements MaskingHandler {
   @Override
   public String getMaskingValue(String value) {
      // 使用内置 Masker 工具类隐藏中间 4 位
      return Masker.hide(value, 3, 7);
   }
}
```

定义实体类
```java
public class User {
    @MaskingField(typeHandler = KeepFirstAndLastHandler.class)
    private String name;
    @MaskingField(typeHandler = MobileMaskingHandler.class)
    private String mobile;
    @MaskingField(typeHandler = FixedMaskHandler.class)
    private String password;
    // getter、setter 略
}
```
> 通过在实体类字段上添加 @MaskingField 注解，开发者可以精确定义脱敏策略。


执行脱敏

```java
public class QuickStart {
   public static void main(String[] args) {
      User user = new User();
      user.setName("张小凡");
      user.setMobile("13700001234");
      user.setPassword("123456");
      
      EasyDesensitize.mask(user);
      System.out.println(user);
      // 输出：User [name=张*凡, mobile=137****1234, password=******]
   }
}
```


## 3. 复杂对象支持
在实际业务中，数据往往以 Result<T> 或嵌套列表的形式存在。`easy-desensitize`在处理这类复杂结构时表现出了关键技术优势。

* List脱敏

```java
public class ListTypeDesensitize {
   
   public static void main(String[] args) {
      User user = new User();
      user.setName("李小鹏");
      user.setMobile("13700001234");
      user.setPassword("123456");
      
      // List脱敏
      List<User> list = Collections.singletonList(user);
      EasyDesensitize.mask(list);
      System.out.println(list);
      // 输出：[User [name=李*鹏, mobile=137****1234, password=******]]
   }
}
```

* Map脱敏

```java
public class MapTypeDesensitize {
	
   public static void main(String[] args) {
      User user1 = new User("李小鹏", "13700001234", "123456");
      User user2 = new User("张三", "13888880000", "456789");
      
      // Map脱敏
      Map<String, Object> map = new HashMap<>();
      map.put("code", 200);
      map.put("data", user1);
      map.put("list", Collections.singleton(user2));
      
      EasyDesensitize.mask(map);
      System.out.println(map);
      // 输出：{code=200, data=User [name=李*鹏, mobile=137****1234, password=******], list=[User [name=张*, mobile=138****0000, password=******]]}
   }
}
```

* 树形数据脱敏

```java
public class TreeVO {
   private String id;
   @MaskingField(typeHandler = KeepFirstAndLastHandler.class)
   private String name;
   private List<TreeVO> children;
   // ...
}

public class TreeTypeDesensitize {

   public static void main(String[] args) {
      TreeVO root = new TreeVO();
      root.setId("1");
      root.setName("XXX有限公司");
      
      TreeVO t1 = new TreeVO();
      t1.setId("1001");
      t1.setName("行政部");
      
      TreeVO t2 = new TreeVO();
      t2.setId("1001");
      t2.setName("研发部");
      
      root.setChildren(Arrays.asList(t1, t2));
      EasyDesensitize.mask(root);
      System.out.println(root);
      // 输出：TreeVO [id=1, name=X*****司, children=[TreeVO [id=1001, name=行*部, children=null], TreeVO [id=1001, name=研*部, children=null]]]
   }
}
```

* 泛型数据脱敏

```java
// 统一包装
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    // ...
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }
    // ...
}

// 测试脱敏
public class ResultDesensitize {
    public static void main(String[] args) {
        Result<User> result = Result.success(new User("张小凡", "13700001234", "123456"));
        EasyDesensitize.mask(result);
        System.out.println(result);
        // 输出：Result{code=200, message='success', data=User [name=张*凡, mobile=137****1234, password=******]}
    }
}
```

项目仓库： https://github.com/zhengyuelaii/easy-desensitize-core

## 4. 与 Spring 集成

通过`easy-desensitize-spring-boot-starter`，框架实现了自动装配逻辑。它利用 Spring MVC 的 ResponseBodyAdvice 切面，在 HTTP 响应序列化前的最后一步自动触发脱敏。这意味着开发者无需在 Service 层编写任何脱敏代码，即可实现全局的安全加固。

### 4.1 引入依赖

```xml
<dependency>
    <groupId>io.github.zhengyuelaii</groupId>
    <artifactId>easy-desensitize-spring-boot-starter</artifactId>
    <version>${latest.version}</version> <!-- 使用变量替换最新版本 -->
</dependency>
```

### 2. 创建实体类

在字段上使用 @MaskingField 定义脱敏策略。

```java
import io.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import io.github.zhengyuelaii.desensitize.core.handler.FixedMaskHandler;
import io.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;

public class User {
    @MaskingField(typeHandler = KeepFirstAndLastHandler.class)
    private String name; // 李小龙 -> 李*龙
    @MaskingField(typeHandler = FixedMaskHandler.class)
    private String password; // 123456 -> ******
    private String address;

    // getter/setter
}
```
### 3. 在Controller启用脱敏

在 **方法或类** 上添加 @ResponseMasking 注解。

```java
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    @ResponseMasking
    public User get() {
        return new User( "李小龙", "12345678", "上海");
    }

}
```

响应结果

```json
{
    "username": "李*龙",
    "password": "******",
    "address": "上海"
}
```

项目仓库： https://github.com/zhengyuelaii/easy-desensitize-spring-boot-starter

## 总结
从实测结果看，easy-desensitize 不仅仅是一个简单的注解工具，它更像是一个经过精细调优的性能引擎。对于追求高吞吐量、且需处理复杂对象模型的 Java 应用，它提供了一个高性能且低侵入的标准化方案。

测试代码：https://github.com/zhengyuelaii/easy-desensitize-samples