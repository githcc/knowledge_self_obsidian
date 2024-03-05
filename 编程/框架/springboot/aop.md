    
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

```java
@Aspect
@Component
public class MethodLoggingAspect {

    @Before("execution(* com.example.demo_springboot.*.*.add*(..))")
    public void logMethodStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("开始执行方法：" + methodName);
    }

    @After("execution(* com.example.demo_springboot.*.*.add*(..))")
    public void logMethodEnd(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法执行结束：" + methodName);
    }
}
```

## 解释
- `execution`: 这是用于定义切点（pointcut）的关键词，表示匹配方法执行的连接点。

- `(* com.example.demo_springboot.*.*.add*(..))`: 这部分是切点表达式的一部分，用于描述要匹配的方法模式。具体来说：
    - `*`: 第一个 * 表示匹配任意的返回类型。
    - `com.example.demo_springboot.*`: 这个部分匹配的是包路径，表示 com.example.demo_springboot 包及其子包。
    - `*.*`: 这两个星号分别表示类名和方法名，其中第一个星号表示任意类，第二个星号表示方法名以 "add" 开头。
    - `add*(..)`: 括号里的 `..` 表示任意参数列表，这个模式匹配方法名以 "add" 开头且参数列表任意的方法。
