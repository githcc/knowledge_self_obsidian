## jdk变化
1. jdk8 Lambda优化了编码
2. jdk9 模块化，jshell， 集合的of方法， 输出的文档改用h5
3. jdk10 类型推导

## jdk8接口中新增的方法
弥补定义方法后实现类必须实现，Map的forEach
1. 默认方法
2. 静态方法

## 使用的话放置于方法的定义那就可以了
[[supplier]] get 无参，有返回值
[[consumer]] accept 有参，无返回值
[[function]] apply 有参，有返回值
[[predicate]] test 有参，返回值为boolean

BiFunction 3个参数 入参，返回类型

## 组合使用
andThen 同时执行
and 与
or 或
negate 取反

## 方法引用
1. 类名::方法
2. 类名::静态方法
3. 对象::方法
4. 类型::new
5. 类型[]::new

## 串行stream
1. 数组
    1. 基本数据类型转集合
    2. 包装类 Stream.of();
2. 集合 list.stream();

## 并行stream
1. 集合 list.parallelStream();
2. 转化 stream.parallel();

## stream常用方法
1. forEach
2. filter
3. map
4. count
5. limit
6. skip
7. concat
8. distinct
9. reduce [[reduce| 归纳]]
10. collect #标题/todo
    1. [[collect/转化]]
    2. [[collect/分组]] 结果是1，多
    3. [[collect/分区]] 结果为两个，true或false
    4. [[collect/拼接]]

## 并行的使用
1. 需要通过测试才能验证效率的提高，简单的任务，一般提升不了啥
2. 需要控制线程数，避免系统崩溃
3. 并行可能会引发一些安全问题
    1. 加同步锁
    选择安全的容器（初始化或进行转化[[集合转化| Collections方式]] [[转化| collect方式]]）

## Fork/join
1. 线程池：ForkjoinPool
2. 任务对象：ForkJoinTask
3. 执行线程：ForkJoinWorkerThread
4. 可以修改的参数：java.util.concurrent.ForkJoinPool.common.parallelism=N 线程数量
5. 原理
    1. 使用了分治
    2. 当部分线程提前处理完任务后空闲使用工作窃取法，结构是双端队列，取的是从最后取

Optional类
避免空指针

## 创建Optional
1. of方法不支持null
2. ofNullable 支持null
3. empty 获取一个空对象
4. ifPresent 可以类比 if
5. ifPresentOrElse 可以类比 if ... else

## Optional常用方法
1. [[编程/代码/jdk8/optional/ge| get]] 获取值
2. [[isPresent|isPresent]] 判断是否存在
3. orElse 设置默认值
4. orElseGet(Supplier sup) 设置默认值
5. [[ifPresent|ifPresent]] 如果不为空执行

## 老版本时间与日期不友好的例子
1. Date包同名较多
2. 日期的起始点为1900
3. 时间格式化，在多线程环境会出错
4. 不提供国际化

## 新版时间与日期的相关类
1. LocalDate
    1. of 设置日期
    2. now 获取现在日期
    3. getYear，getMonth，getDayOfMonth，getDayOfWeek ...
    4. withYear，withMonth，withDayOfMonth，withDayOfWeek ... 修改会生产一个新的LocalDate
    5. plusYear，plusMonth，plusDayOfMonth，plusDayOfWeek ...（minus）
    6. isAfter isBefore isEqual 比较时间大小
2. LocalTime 同上
3. LocalDateTime 同上
4. DateTimeFormat 日期格式化
	1. ofPattern 自定义格式
5. Instant 时间戳
	1. 时间戳是从1970/01/01
6. Duration 计算时间差
	1. between 后减前
	2. toDays toHours toMinutes toMillis
7. TemporalADjusters 时间矫正器
8. ZoneDate，ZoneTime，ZoneDateTime 支持时区
	1. now 可以获取时间，也可以设置时间
	2. Clock.systemUTC 可以获取标准时间
	3. ZoneID.of 设置时区
	4. ZOneID.getAvailableZoneIDs 获取所有时区

## 注解
1. 重复注解 Repeatable
2. 元注解新增
	1. TYPE_PARAMETER 用于泛型
	2. TYPE_USE 任何类型

## 参考资料
1. bilibili:
   1. [2021最新版JDK8新特性详解](https://www.bilibili.com/video/BV1k64y1R7sA)