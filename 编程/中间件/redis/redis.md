## redis常用命令
1. SET key value：设置 key 的值为 value。
2. GET key：获取 key 的值。
3. DEL key：删除 key。
4. INCR key：将 key 的值加 1。
5. LPUSH key value：将 value 添加到 key 对应的列表的头部。
6. RPUSH key value：将 value 添加到 key 对应的列表的尾部。
7. FLUSHDB：删除当前数据库中的所有 key。
8. FLUSHALL：删除所有数据库中的所有 key。

## redis三个问题
1. 缓存穿透
   1. 缓存不起效，缓存没命中，
   2. 解决方式
      1. 查询要校验好
      2. 不存在的数据也要存起来，时间可以设置短些
      3. 布隆过滤器 #标题/TODO
2. 缓存击穿
   1. 某一热点缓存失效了，大量的请求打到数据库
   2. 解决方式
      1. 主动更新数据，不要存在空白期
      2. 双锁
3. 缓存雪崩
   1. 缓存大面积失效，大量的请求打到数据库
   2. 解决方式
      1. 过期时间加随机值
      2. 数据预热，数据提前存入redis
4. 双写不一致问题
   1. 使用读写锁

## redis支持的类型
1. 字符串（string）：Redis 最基本的数据类型，可以存储任何类型的数据，包括字符串、数字、对象等。
2. 哈希（hash）：Redis 的哈希类型可以存储多个键值对，每个键值对由键和值组成。
3. 列表（list）：Redis 的列表类型可以存储多个元素，元素可以是任意类型的数据。
4. 集合（set）：Redis 的集合类型可以存储多个元素，元素必须是唯一的。
5. 有序集合（sorted set）：Redis 的有序集合类型可以存储多个元素，元素必须是唯一的，并且每个元素都关联一个分数。

## 项目中使用redis 
[[编程/代码/工程/demo_redis/README.md|redis]]

## redis持久化
1. RDB持久化 默认选择,速度快，恢复到某一时刻 save xx xx 
2. AOF持久化 速度慢，恢复任意时刻

## redis淘汰策略
noeviction:返回错误当内存限制达到并且客户端尝试执行会让更多内存被使用的命令（大部分的写入指令，但DEL和几个例外）
allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。
volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。
allkeys-random: 回收随机的键使得新添加的数据有空间存放。
vlatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。
volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。

## 疑问 #标题/TODO
1. redis为什么要使用Resource进行注入
2. redis可以直接存对象吗
3. windows设置开机自启
4. 序列化与转json一样吗

## 参考资料
1. google：[gemini](https://gemini.google.com/app)