## 作用
1. 可以用于打包，分发，部署的工具
   打包：dockerfile, 把项目与环境进行打包
   分发：dockerhub，其他人可以非常方便的获取和安装
   部署：运行dockerfile
2. 统一了软件管理

## 优势
1. 轻量级的虚拟机
2. 删除了没用到的内容
   1. 稳定性高
   2. 性能好

## 镜像加速源
修改/etc/docker/daemon.json
{"registry-mirrors":["https://reg-mirror.qiniu.com/"]}

| 镜像加速器          | 镜像加速器地址                       |
| ------------------- | ------------------------------------ |
| Docker 中国官方镜像 | https://registry.docker-cn.com       |
| DaoCloud 镜像站     | http://f1361db2.m.daocloud.io        |
| Azure 中国镜像      | https://dockerhub.azk8s.cn           |
| 科大镜像站          | https://docker.mirrors.ustc.edu.cn   |
| 阿里云              | https://ud6340vz.mirror.aliyuncs.com |
| 七牛云              | https://reg-mirror.qiniu.com         |
| 网易云              | https://hub-mirror.c.163.com         |
| 腾讯云              | https://mirror.ccs.tencentyun.com    |

## 安装
   ```
   sudo yum update
   sudo yum install -y yum-utils device-mapper-persistent-data lvm2
   sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
   sudo yum install docker-ce
   sudo systemctl start docker
   sudo systemctl enable docker
   sudo docker --version
   ```

## 思路
1. 创建目录
2. run镜像
3. docker cp 容器内的文件到指定目录
4. 删除容器/镜像
5. 指定目录，重新run镜像

## 错误记录
1. docker: Error response from daemon: Ports are not available: exposing port TCP 0.0.0.0:3306 -> 0.0.0.0:0: listen tcp
   0.0.0.0:3306: bind: An attempt was made to access a socket in a way forbidden by its access permissions.
    1. 似乎是端口被占用了，

## 不同系统差异
1. 续行
    1. cmd ^
    2. linux \

## 进入容器
   ```
   docker exec -it <容器id> /bin/bash
   ```

## 语法
创建网络
docker network create test-net 
指定网络
-- network
网络取别名
--network-alias
如果存在同名容器会进行删除
--rm
挂载其它容器目录
--volumes-from
交互
-it
查看日志
logs
导出容器 #标题/TODO
docker export 1e560fca3906 > ubuntu.tar
导入容器 #标题/TODO
cat docker/ubuntu.tar | docker import - test/ubuntu:v1
将容器内部使用的网络端口随机映射到我们使用的主机上
-P

## 参考资料
1. 博客园
    1. [win10使用Docker Desktop启动mysql报错](https://www.cnblogs.com/eternality/p/17567703.html) [[离线/网页/博客园/docker报端口占用/README | 离线]]
2. bilibili
    1. [Docker 1小时快速上手教程](https://www.bilibili.com/video/BV11L411g7U1)