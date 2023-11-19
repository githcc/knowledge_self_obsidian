## redis常用命令
1. SET key value：设置 key 的值为 value。
2. GET key：获取 key 的值。
3. DEL key：删除 key。
4. INCR key：将 key 的值加 1。
5. LPUSH key value：将 value 添加到 key 对应的列表的头部。
6. RPUSH key value：将 value 添加到 key 对应的列表的尾部。

## redis三个问题
1. 缓存穿透
   1. 缓存不起效
   2. 解决方式
      1. 查询要校验好
      2. 不存在的数据也要存起来，时间可以设置短些
      3. 布隆过滤器 #标题/TODO
2. 缓存击穿
   1. 热点数据
   2. 解决方式
      1. 主动更新数据，不要存在空白期
      2. 双锁 #标题/TODO
3. 缓存雪崩
   1. 缓存大面积失效
   2. 解决方式
      1. 过期时间加随机值
      2. 数据预热，数据提前存入redis

## 建一个项目用一下redis #标题/TODO 