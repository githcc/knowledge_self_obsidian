## 作用
1. 注册中心
2. 配置中心

## 注册到nacos
```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```
```yaml
spring:
  cloud:
    nacos:
      server-addr: 127.0.0.1:8848
```

## 调用其它服务
```java
List<ServiceInstance> instances=discovervclient.getInstances("item-service");
ServiceInstance instance=instances.get(RandomUtil.randomInt(instances.size()));
```

## 共享配置
```
  <!--nacos配置管理-->
  <dependency>
      <groupId>com.alibaba.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
  </dependency>
  <!--读取bootstrap文件-->
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-bootstrap</artifactId>
  </dependency>
```
```yaml
spring:
  cloud:
    nacos:
      config:
        file-extension: yaml # 文件后缀名
        shared-configs: # 共享配置
          - dataId: shared-jdbc.yaml # 共享mybatis配置
          - dataId: shared-log.yaml # 共享日志配置
          - dataId: shared-swagger.yaml # 共享日志配置
```
### 代码参数热更新
```java
@Component
@ConfigurationProperties(prefix = "hm.cart")
public class CartProperties {
    private Integer maxAmount;
}
```

## 其它
1. yaml文件也是可以使用变量，例如{hm.db.host}

## 参考资料
1. bilibili：[SpringCloud微服务技术栈实战教程](https://www.bilibili.com/video/BV1kH4y1S7wz?p=14)  [备份至github](https://github.com/githcc/webpage_self_markdown/blob/main/%E9%A3%9E%E4%B9%A6/%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%A1%86%E6%9E%B6/day04-%E5%BE%AE%E6%9C%8D%E5%8A%A102/README.md)
