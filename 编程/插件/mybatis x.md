## 使用
1. 可以辅助mybatis plus 使用

## 功能
1. 代码生成
2. 单表baseMapper
3. 单表baseService
4. swagger
5. 多数据源

### Generate Options
1. 编码
2. 继承类
3. 忽略字段前缀/后缀
4. 忽略表前缀/后缀

### mybatis x 目前使用配置
annotation Mybatis-Plus 3
options Comment/Lombok/JSR310: Date API/Model/Lombok
template Mybatis-Plus 3
使用@MapperScan

### mybatis x 配置说明
1. annotation
   1. Mybatis-Plus 3 实体类字加入@TableName/@TableId/@Column
   2. JPA 实体类字加入@Table/@Id
2. options
   1. Comment 注释
   2. Actual Column 实体类字段名保留下划线
   3. JSR310: Date API 实体类日期类型使用LocalDateTime

## Wrapper
1. 查询 queryWrapper
   1. lambda
   2. 条件
      1. like notLike
      2. eq ne
      3. in
      4. gt lt ge le
      5. isNull isNotNull
      6. and/or
         1. 默认and
         2. 可以嵌套
   3. 限制字段
      1. select
   4. limit
      1. last
   5. 子查询
      1. inSql
2. 修改
   1. queryWrapper Object
   2. updateWrapper
      1. 不建议，能使用使用一种即可
3. 删除（不存在）
   1. 间接使用queryWrapper

## BaseService
1. count
2. saveBatch
3. saveOrUpdateBatch

## BaseMapper
1. 新增
   1. insert
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

## 注解
1. @TableName
2. @TableId(value="field",type=IdType.AUTO)
   1. ## 雪花算法 IdType.ASSIGN_ID
      1. 组成
         1. 1位符号位
         2. 41位时间戳
         3. 10位工作进程
         4. 12位序列号
      2. 用于取代主键自增
3. @TableField(value=""field")
4. @TableLogic(value="0",delval="1")
   1. 逻辑删除，0：存在 1：删除
5. @Version 版本号，用于乐观锁
6. @EnumValue //不建议，直接使用getValue
7. @TableField(fill = FieldFill.INSERT_UPDATE) //配合Interceptor使用

## maven
```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.5</version>
</dependency>
```

## Interceptor配置类
```
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//分页
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());//版本号
        return interceptor;
    }
```

## 时间配置类(起始版本3.3.3)
```
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "insertTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}
```

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
#枚举
   type-enums-package:
```

## 其它
1. 版本号适用于mapper.updateById函数，不适用于service.update函数

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
