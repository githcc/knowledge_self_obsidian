## 作用
1. 服务间调用

## maven
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```

### 调用其它服务
```
@FeignClient(value = "hm-item-service", configuration = DefaultFeignConfig.class)
```

### 开启FeignClient
```
@EnableFeignClients(basePackages = "com.cc.client")
```

### 设置Feign日志
```java
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
```

## 整合OK Http连接池
```xml
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-okhttp</artifactId>
</dependency>
```
```yaml
feign:
  okhttp:
    enabled: true
```

## 原理
动态代理

## 其它
1. 负载均衡版本：Ribbon/loadbalancer
2. openfeign日志级别
    1. none
    2. basic
    3. headers
    4. full
3. 流控默认效果：快速失败提示429

## 拦截器
1. 实现原理：WebMvcConfigurer
2. 可能需要配置spring.factories让其被扫描
```
@Bean
public RequestInterceptor userInfoRequestInterceptor(){
    return new RequestInterceptor() {
        @Override
        public void apply(RequestTemplate template) {
            // 获取登录用户
            Long userId = UserContext.getUser();
            if(userId == null) {
                // 如果为空则直接跳过
                return;
            }
            // 如果不为空则放入请求头中，传递给下游微服务
            template.header("user-info", userId.toString());
        }
    };
}
```

## 参考资料
1. bilibili：[SpringCloud微服务技术栈实战教程](https://www.bilibili.com/video/BV1kH4y1S7wz?p=16,17,19)
