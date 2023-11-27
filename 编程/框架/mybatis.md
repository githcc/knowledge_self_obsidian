## springboot集成mybatis

### 步骤一：添加依赖
最好是在创建项目的时候选择相应依赖 SQL MyBatis Framework/MYSQL Driver

[更新依赖](https://central.sonatype.com/)

### 步骤二：配置数据源

在`application.properties`或`application.yml`中配置数据源，例如MySQL：

#### application.properties

### 步骤三：使用 [[编程/插件/mybatis x|mybatis x]]

[mybatis 创建](编程/代码/片段/框架/mybatis/创建.md)
[mybatis 工程](编程/代码/工程/demo_mybatis/README.md)

## 动态sql标签
if
foreach
sql片段
include

[mybatis 创建](编程/代码/片段/框架/mybatis/动态sql.md)

## 结果映射
1. collection property ofType
2. association property javaType
3. resultType、resultMap
4. parameterType

[mybatis 创建](编程/代码/片段/框架/mybatis/结果映射.md)