## 作用
1. 服务降级
   1. 线程隔离（限制线程数）
   2. 限制qps
   3. 熔断

## 引入sentinel
```
  <!--sentinel-->
   <dependency>
       <groupId>com.alibaba.cloud</groupId> 
       <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
   </dependency>
```
```yaml
spring:
  cloud:
    sentinel:
      transport:
        dashboard: 192.168.50.144:8858
```

## 设置block内容


