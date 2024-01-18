```
//创建目录
   mkdir -p /home/mysql/mysql
   mkdir -p /home/mysql/log
   
//复制原本的文件
   docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d  -p 3306:3306 mysql:latest
   docker cp mysql:/etc/mysql/mysql /home/mysql
   docker cp mysql:/var/log /home/mysql
   
//删除容器
   docker stop mysql
   docker rm mysql
   
//运行
   docker run \
   -p 3306:3306 \
   --name mysql \
   --restart=always \
   -e MYSQL_ROOT_PASSWORD=root \
   -v /home/mysql/mysql:/etc/mysql/mysql \
   -v /home/mysql/log:/var/log \
   -d mysql:latest
```