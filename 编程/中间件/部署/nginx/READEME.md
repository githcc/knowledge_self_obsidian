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
   
//运行
   docker run \
   -p 80:80 \
   -p 443:443 \
   -p 8080:8080 \
   -p 6060:6060 \
   -p 5050:5050 \
   --name nginx \
   --restart=always \
   -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
   -v /home/nginx/conf/conf.d:/etc/nginx/conf.d \
   -v /home/nginx/log:/var/log/nginx \
   -v /home/nginx/html:/usr/share/nginx/html \
   -v /home/nginx/cert:/home/nginx/cert \
   -d nginx:latest
```