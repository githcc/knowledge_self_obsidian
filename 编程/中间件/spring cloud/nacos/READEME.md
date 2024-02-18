## 概况
1. 数据库表
2. 配置文件 conf
3. 引入依赖
4. 配置文件 yml

## maven
```
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

## yaml
```
spring:
  cloud:
    nacos:
      server-addr: 127.0.0.1:8848
```

## 代码
'''
List<ServiceInstance> instances=discovervciient. etInstances(item-service):
ServiceInstance instance=instances.get(RandomUtil.randomInt(instances.size())):
'''

## 参考资料
1. bilibili：[SpringCloud微服务技术栈实战教程](https://www.bilibili.com/video/BV1kH4y1S7wz?p=14)