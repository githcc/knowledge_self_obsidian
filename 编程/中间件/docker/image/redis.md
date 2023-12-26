```
//创建目录
   mkdir -p /docker_volumes/redis/
   
//复制原本的文件
    docker run \
    -p 6379:6379 \
    --name redis \
    -v /data/redis/redis.conf:/etc/redis/redis.conf  \
    -v /data/redis/data:/data \
    -d redis redis-server /etc/redis/redis.conf \
    --appendonly yes
    
   docker cp redis:/etc/redis/redis.conf /docker_volumes/redis/redis.conf
   docker cp redis:/data /docker_volumes/redis/data
   
//删除容器
   docker stop redis
   docker rm redis
   
//运行
    docker run \
    -p 6379:6379 \
    --name redis \
    -v /data/redis/redis.conf:/etc/redis/redis.conf  \
    -v /data/redis/data:/data \
    -d redis redis-server /etc/redis/redis.conf \
    --appendonly yes
    
```