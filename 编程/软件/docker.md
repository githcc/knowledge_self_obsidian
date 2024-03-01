## 作用
1. 打包：dockerfile, 把项目与环境进行打包
2. 分发：dockerhub，其他人可以非常方便的获取和安装
3. 部署：运行docker-compose

## 优势
1. 轻量级的虚拟机
2. 删除了没用到的内容
   1. 稳定性高
   2. 性能好

## 镜像加速源
```
修改/etc/docker/daemon.json
{"registry-mirrors":["https://reg-mirror.qiniu.com/"]}
sudo systemctl restart docker
```

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
   sudo yum -y update
   sudo yum install -y yum-utils device-mapper-persistent-data lvm2
   sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
   sudo yum install -y docker-ce
   sudo systemctl start docker
   sudo systemctl enable docker
   sudo docker --version
   ```

## 思路
1. 创建目录
2. run镜像
3. docker cp 容器内的文件到指定目录
4. 删除容器
5. 指定目录，重新run镜像

## 网络
```
创建网络
docker network create test-net 

指定网络
-- network

网络取别名
--network-alias
```

## 容器
```
挂载其它容器目录
--volumes-from

导出容器
docker export 1e560fca3906 > ubuntu.tar

导入容器
cat docker/ubuntu.tar | docker import - test/ubuntu:v1

将容器内部使用的网络端口随机映射到我们使用的主机上
-P

每次docker启动都会启动容器
--restart=

查看容器ip
docker inspect <容器id>
```

## 镜像
```
加载镜像
docker load -i xx.tar
```

## 清理
```
删除没用到容器
docker container prune

没用到镜像
docker image prune

没用到的虚拟目录
docker volume prune

删除未使用的容器、镜像、卷和网络
docker system prune
```

## 其它
```
显示Docker系统资源的使用情况摘要
docker system df

重启守护进程
sudo systemctl restart docker

关闭docker开机自启
docker update --restart=no <容器id>

使用代理
-e  "HTTP_PROXY=http://x.x.x.x:7890" 
-e  "HTTPS_PROXY=http://x.x.x.x:7890" 
-e  "NO_PROXY=localhost,127.0.0.1,.example.com" 
```

## 参考资料
1. 博客园
    1. [win10使用Docker Desktop启动mysql报错](https://www.cnblogs.com/eternality/p/17567703.html) [备份至github](https://github.com/githcc/webpage-self-markdown/blob/main/%E5%8D%9A%E5%AE%A2%E5%9B%AD/docker%E6%8A%A5%E7%AB%AF%E5%8F%A3%E5%8D%A0%E7%94%A8/README.md)
2. bilibili
    1. [Docker 1小时快速上手教程](https://www.bilibili.com/video/BV11L411g7U1)
3. 菜鸟教程：[docker安装](https://www.runoob.com/docker/centos-docker-install.html)