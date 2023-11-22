## springboot集成mybatis

### 步骤一：添加依赖
最好是在创建项目的时候选择相应依赖 SQL MyBatis Framework/MYSQL Driver
```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.2</version>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter-test</artifactId>
    <version>3.0.2</version>
    <scope>test</scope>
</dependency>
```
[更新依赖](https://central.sonatype.com/)

### 步骤二：配置数据源

在`application.properties`或`application.yml`中配置数据源，例如MySQL：

#### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

#### application.yml

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### 步骤三：使用 [[编程/插件/mybatis x|mybatis x]]
[mybatis 实例](编程/代码/工程/demo_mybatis/README.md)

## 动态sql标签
if
foreach
sql片段
include

## 标签/属性
1. collection property ofType
2. association property javaType
3. resultType、resultMap
4. parameterType
