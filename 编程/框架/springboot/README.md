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

## 基本使用
1. springboot的要点
   1. 无效且琐碎：配置信息
   2. 核心：模型的设计
   3. 主要工作量：增删改查
2. spring的要点
   1. 不变：对象注入到容器中
   2. 变：注入的形式
3. springboot特点
   1. 约定优于配置
4. EnableXXX 的本质
   1. 注册Bean到容器中
   2. 实现原理
      1. @Import
      2. @DeferredImportSelector
      3. @ImportSelector
         1. 自动调用selectImports
         2. 读取spring.factories文件，获取实现类
      4. @Configure @Bean
      5. @BeanPostProcessor
         1. @BeanPostBeforeInitialization
         2. @BeanPostAfterInitialization
5. spring的注解发展过程，核心去xml
   1. spring1.x
      1. ioc， aop
      2. 定义
         1. <bean id="userService" class="com.example.UserService">
         2. <property name="userDao" ref="userDao"></property>
         3. </bean>
      3. 使用
         1. applicationContext.getBean("userService")
   2. spring2.x
      1. @Repository @Aspect
      2. @Service @Controller @RequestMapping
      3. 定义
         1. <context:component-scan base-package="com. demo02"/> 扫包
   3. spring3.x
      1. @Configuration与@Bean取代applicationContext.xml
      2. 方案一：@ComponentScan
      3. 方案二：@Import
   4. spring4.x
      1. @Conditional
      2. @ConditionalOnClass（来自Spring Boot）
      3. @ConditionalOnXX
   5. spring5.x
6. SpringBoot的自动装配
   1. 实现定义好在spring.factories文件中，自动装配Bean到容器中
   2. @ImportSelector
7. springboot maven
   1. 官方spring-boot-starter-xxx
   2. 第三方xxx-spring-boot-starter
8. 自定义Starter
   1. application.properties
   2. spring.factories
   3. spring-boot-configuration-processor
