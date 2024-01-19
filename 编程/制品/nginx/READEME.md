```
//创建目录
   mkdir -p /home/nginx/conf
   mkdir -p /home/nginx/log
   mkdir -p /home/nginx/html
   mkdir -p /home/nginx/cert
   
//复制原本的文件
   docker run --name nginx -p 80:80 -d nginx
   docker cp nginx:/etc/nginx/nginx.conf /home/nginx/conf/nginx.conf
   docker cp nginx:/etc/nginx/conf.d /home/nginx/conf/conf.d
   docker cp nginx:/usr/share/nginx/html /home/nginx/
   
//删除容器
   docker stop nginx
   docker rm nginx
```