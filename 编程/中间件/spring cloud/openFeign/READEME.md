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

## 注解
```
@FeignClient

@EnableFeignClients
```

## 整合OK Http连接池
### maven
```
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-okhttp</artifactId>
</dependency>
```
### yaml
```
feign:
  okhttp:
    enabled: true
```

## 注入
### 方式一：
```
@EnableFeignClients(basePackages = "com.hmall.api.clients")
```
### 方式二：
```
@EnableFeignClients(clients = {UserClient.class})
```


## 修改日志级别
### bean
```
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}

```

### 注入
#### 方式一
```
@FeignClient(value = "item-service", configuration = DefaultFeignConfig.class)
```
#### 方式二
```
@EnableFeignClients(defaultConfiguration = DefaultFeignConfig.class)
```

## 原理
动态代理

## 细节
1. 负载均衡版本：Ribbon/loadbalancer
2. openfeign日志级别
    1. none
    2. basic
    3. headers
    4. full

## 最佳实践
1. 方案一：每一个微服务作为要给pom，给别人引用
2. 方案二：抽离一个api项目（包含所有项目对外接口）

## 参考资料
1. bilibili：[SpringCloud微服务技术栈实战教程](https://www.bilibili.com/video/BV1kH4y1S7wz?p=16,17,19)