## 语法
MAINTAINER 作者

## 打包镜像
docker build -t test:v1 .
-t 指定镜像名称及版本号

## 疑问
1. RUN 与 CMD区别
   1. cmd只能有一个
   2. 一般情况 RUN 用于镜像中，而 CMD 则指定了容器启动时要执行的默认命令
2. 两种挂载磁盘的方式有什么区别
   1. bind mount 支持挂载多个容器，使用绝对路径
   2. volume 高效，linux文件系统更适合存储