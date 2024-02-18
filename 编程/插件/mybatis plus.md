## 功能
1. 代码生成(使用mybatis x)
2. 单表baseMapper
3. 单表baseService
4. swagger
5. 多数据源

### mybatis x 逆向配置
annotation None
options Comment/Lombok/JSR310: Date API/Model/Lombok
template Mybatis-Plus 3
使用@MapperScan

### mybatis x 配置说明
1. annotation
   1. Mybatis-Plus 3 实体类字加入@TableName/@TableId/@Column
   2. JPA 实体类字加入@Table/@Id
2. options
   1. Actual Column 实体类字段名保留下划线
   2. JSR310: Date API 实体类日期类型使用LocalDateTime

## Wrapper
1. 查询 queryWrapper
   1. condition 条件
   2. map 字段
   3. where
   4. and/or
      1. 默认and
      2. 可以嵌套
   5. limit
   6. 子查询
   7. lambda
2. 修改
   1. queryWrapper Object
   2. updateWrapper
      1. where
      2. set
      3. lambda
3. 删除（不存在）
   1. 间接使用queryWrapper

## BaseMapper
1. 新增  
2. 删除
   1. 根据id
   2. 根据多个id
   3. 根据特定条件
3. 修改
4. 查询
   1. 根据id
   2. 根据多个id
   3. 根据特定条件
      1. 获取一条
      2. 获取数量
5. 判断
   1. 根据特定条件

## BaseService
1. count
2. saveBatch
3. SaveOrUpdateBatch

## 注解
1. @TableName
2. @TableId(value="field",type=IdType.AUTO)
   1. ## 雪花算法
      1. 组成
         1. 1位符号位
         2. 41位时间戳
         3. 10位工作进程
         4. 12位序列号
      2. 用于取代主键自增
3. @TableField(value=""field")
4. @TableLogic
   1. 逻辑删除，0：存在 1：删除
5. @Version 版本号，用于乐观锁，是否需要配合其它插件？
6. @EnumValue 

## maven
```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.5</version>
</dependency>
```

## 代码示例
编写一个的 [[controller|controller]]

## 分页
1. 注入一个[[编程/代码/片段/插件/mybatis x/MyBatisPlusConfig|MyBatisPlusConfig Bean]]
2. 编写一个单元测试[[UserControllerTest|UserControllerTest]]
### 自定义分页
编写mapper方法
   1. 要求第一个参数为：page
   2. 范围值为：page

## yml
```
#开启sql
mybatis-plus:
   configuration:
      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
#表前缀
   global-config:
      db-config:
         table-prefix: t_
#主键策略
         id-type: auto
#枚举
   type-enums-package:
```

## 其它
1. 数据发生变化，修改时间的相关注解
2. 枚举自带final？

## 多数据源
### maven
```
<dependency
   <groupId>com.baomidou</groupId>
   <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
   <version>3.5.0</version>
</dependency>
```

### yml
```
spring:
   # 配置数据源信息
   datasource:
      dynamic:
      # 设置认的数据源或者数据源组，默认值即为master
      primary:master
      # 严格匹配数据源，默认false.true未匹配到指定数据源时抛异常，false使用黑认数据源
      strict: false
      datasource:
         master:
            ur1: jdbc:mysgl://localhost:3306/mybatis_plus
            driver-class-name: com.mysql.cj.jdbc.Driver
            username: root
            password:123456
         slave_l:
            ur1: jdbc:mysql://1ocalhost:3306/mybatis_plus_1
            driver-class-name: com.mysql.cj.jdbc.Driver
            username：root
            password: 123456
```

### 注解
```
@DS("slave_1") 方法上或类上
```

## 参考资料
1. bilibili
   1. [MyBatisPlus教程](https://www.bilibili.com/video/BV12R4y157Be)


