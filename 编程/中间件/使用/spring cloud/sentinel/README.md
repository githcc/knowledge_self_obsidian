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
      http-method-specify: true # 开启请求方式前缀
feign:
   sentinel:
      enabled: true # 开启feign对sentinel的支持
```

## 设置block内容
```
public class IItemClientFallback implements FallbackFactory<IItemClient> {
    @Override
    public IItemClient create(Throwable cause) {
        return new IItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                return null;
            }
        };
    }
}
```

