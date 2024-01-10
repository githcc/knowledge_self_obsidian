1. springboot mapper扫包
   1. 启动类上加 @MapperScan("com.example.demo.generator.mapper")
2. springboot 返回报文中，当字段值为null不返回该字段
   1. 全局 配置文件上加 spring.jackson.default-property-inclusion=non_null
   2. 局部 在实体类上加 @JsonInclude(JsonInclude.Include.NON_NULL)

## 疑问
1. 如何使用filter与listen
2. 懒加载如何设置
3. springboot的请求是单例吗
4. 如何设置路径通配
5. 路径的优先级，如何查看
6. 如何设置多个环境

## web容器对比
1. tomcat
2. Jetty

## 核心注解
1. SpringBootApplication
   1. EnableAutoConfiguration
      1. AutoConfigurationImportSelector 回去扫描META-INF/spring.factories 然后进行装配
   2. ComponentScan
      1. 只知道会扫描主入口的Application同级下的包
   3. SpringBootConfiguration
      1. Configuration 配置类

## 常用的starter
1. web 引入springmvc，默认tomcat容器
2. test 引入测试框架，单元测试
3. jdbc 引入数据库
4. redis 引入redis