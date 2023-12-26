## 内容
Centos7+Nginx+Mysql8+JDK8

## 运行
1. docker build -t server .
2. docker run --name server1 -d -p 80:80 --privileged=true server /usr/sbin/init
