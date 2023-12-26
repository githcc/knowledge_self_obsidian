```
//创建目录
   mkdir -p /docker_volumes/mysql/
   mkdir -p /docker_volumes/mysql/conf.d/
   
//复制原本的文件
   docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d  -p 3306:3306 mysql:latest
   docker cp mysql:/var/lib/mysql /docker_volumes/mysql/mysql
   docker cp mysql:/etc/mysql/conf.d /docker_volumes/mysql/conf.d
   
//删除容器
   docker stop mysql
   docker rm mysql
   
//运行
   docker run \
   -p 3306:3306 \
   --name mysql \
   -e MYSQL_ROOT_PASSWORD=root \
   -v /docker_volumes/mysql/mysql:/var/lib/mysql \
   -v /docker_volumes/mysql/conf.d/:/etc/mysql/conf.d \
   -d mysql:latest
```