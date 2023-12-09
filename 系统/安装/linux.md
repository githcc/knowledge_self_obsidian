## 原则
1. 软件的选择，尽量使用docker
2. 镜像的选择，尽量使用未被修改过的
3. 软件使用第三方时记得备份软件包
4. 控制好软件安装的数量

## 备份

1. 备份软件，第三方软件的安装包，普通文件的名称
2. 自己网站的数据

## 安装步骤

1. 系统选择
    1. centos的docker版本
    2. 腾讯云的有docker版
2. 安装docker(centos)
   ```
   sudo yum update
   sudo yum install -y yum-utils device-mapper-persistent-data lvm2
   sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
   sudo yum install docker-ce
   sudo systemctl start docker
   sudo systemctl enable docker
   sudo docker --version
   ```
3. 安装Alist
   配置信息放微信收藏夹
   ```
    docker run -d --restart=always -v /etc/Alist:/opt/Alist/data -p 5244:5244 -e PUID=0 -e PGID=0 -e UMASK=022 --name="alist" xhofe/alist:latest
   ```
4. 安装Alist-tvbox
    ````
    sudo bash -c "$(curl -fsSL https://d.har01d.cn/update_xiaoya.sh)"
    ````
   访客账号：guest guest_Api789
5. 安装nginx
   ```
    //创建目录
       mkdir -p /home/nginx/conf
       mkdir -p /home/nginx/log
       mkdir -p /home/nginx/html
    //复制原本的文件
       docker run --name nginx -p 80:80 -d nginx
       docker cp nginx:/etc/nginx/nginx.conf /home/nginx/conf/nginx.conf
       docker cp nginx:/etc/nginx/conf.d /home/nginx/conf/conf.d
       docker cp nginx:/usr/share/nginx/html /home/nginx/
    //删除容器
       docker stop nginx
       docker rm nginx
    //运行nginx
       docker run \
       -p 80:80 \
       --name nginx \
       -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
       -v /home/nginx/conf/conf.d:/etc/nginx/conf.d \
       -v /home/nginx/log:/var/log/nginx \
       -v /home/nginx/html:/usr/share/nginx/html \
       -d nginx:latest
   ```
6. 安装第三方软件包 [[软件/包/linux/README|离线]]

## 参考资料
1. Alist：[AList文档](https://alist.nn.ci/zh/)
2. Alist-tvbox：[alist-tvbox](https://github.com/power721/alist-tvbox/blob/master/doc/README_zh.md)