## 日志框架对比
1. log4j 功能突出
2. logback 性能突出
3. slf4j 兼容性更好
4. log4j2 之前出过漏洞问题

## 日志级别
1. TRACE
2. DEBUG
3. INFO
4. WARN
5. ERROR

## 日志的管理
1. 设置日志级别
2. 设置日志形式，控制台或文件
3. 设置日志文件的切割
   1. 每天一份
   2. 单文件大小上限
   3. 单文件行数上限
4. 设置切面日志，不是很确定


## slf4j(lombok)
### 依赖
```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
</dependency>
```
### 使用
```
@RestController
@RequestMapping("/user")
@Slf4j
public class T {
    @GetMapping("login")
    public void login() {
        log.info("导出客户对账单 start ... {}", "开始");
        // 业务逻辑..
        log.info("导出客户对账单 end ... {}", "结束");
    }
}
```

