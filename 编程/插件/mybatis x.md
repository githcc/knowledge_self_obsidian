## 插件配置
1. annotation
   1. Mybatis-Plus 3 实体类字加入@TableName/@TableId/@Column
   2. JPA 实体类字加入@Table/@Id
2. options
   1. Actual Column 实体类字段名保留下划线
   2. JSR310: Date API 实体类日期类型使用LocalDateTime

### 我的配置
annotation None
options Comment/Lombok/JSR310: Date API/Model/Lombok
template Mybatis-Plus 3
在UserMapper添加@Mapper

mybatis plus 依赖
```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.4.1</version>
</dependency>
```

mybatis plus 最新依赖 [mybatis-plus](https://central.sonatype.com/artifact/com.baomidou/mybatis-plus-boot-starter) 

编写一个的 [[controller|controller]]

## 分页
1. 注入一个[[编程/代码/片段/插件/mybatis x/MyBatisPlusConfig|MyBatisPlusConfig Bean]]
2. 编写一个单元测试[[UserControllerTest|UserControllerTest]]
