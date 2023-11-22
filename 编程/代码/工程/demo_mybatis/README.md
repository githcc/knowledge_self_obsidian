## 当前项目使用技术点
1. 使用了mybatis，mybatis-plus
2. 使用嵌套结果查询 MapperTest
   1. 一对一 VO11
   2. 一对多 VO21
   3. 多对多 VO31
3. 使用了分页查询 UserServiceImplTest

## 暂无法处理的问题
1. 嵌套结果查询无法使用mybatis-plus的分页
   1. 可以使用自定义个Page，然后拼接sql，再count总数等，不太优雅
2. mybatis-plus其它一些操作逻辑
   1. mybatis-plus的基础增删改查不熟悉
   2. 多表数据同时发生变化，如何编写优雅进行写入