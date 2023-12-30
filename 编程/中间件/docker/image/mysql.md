```
//创建目录
   mkdir -p /docker_volumes/mysql/mysql
   mkdir -p /docker_volumes/mysql/log
   
//复制原本的文件
   docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d  -p 3306:3306 mysql:latest
   docker cp mysql:/etc/mysql/mysql /docker_volumes/mysql
   docker cp mysql:/var/log /docker_volumes/mysql
   
//删除容器
   docker stop mysql
   docker rm mysql
   
//运行
   docker run \
   -p 3306:3306 \
   --name mysql \
   --restart=always \
   -e MYSQL_ROOT_PASSWORD=root \
   -v /docker_volumes/mysql/mysql:/etc/mysql/mysql \
   -v /docker_volumes/mysql/log:/var/log \
   -d mysql:latest
```