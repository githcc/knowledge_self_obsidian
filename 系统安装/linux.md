## 原则
1. 软件的选择，尽量使用docker
2. 软件使用第三方时记得备份软件包
3. 控制好软件安装的数量

## 备份
1. 备份软件，第三方软件的安装包，普通文件的名称
2. 阿里云盘的配置信息
3. 自己网站的数据
4. FinalShell的命令信息，密钥

## 安装步骤
1. 系统选择
    1. centos的docker版本(腾讯云)，不使用docker版要自己安装一个docker，等使用阿里云时，补充一下docker的安装
2. 安装Alist
    1. https://Alist.nn.ci/zh/
    2. docker run -d --restart=always -v /etc/Alist:/opt/Alist/data -p 5244:5244 -e PUID=0 -e PGID=0 -e UMASK=022
       --name="Alist" xhofe/Alist:latest
3. 登录Alist
    1. docker logs -f 容器id --查看密码
    2. 挂载阿里云盘
4. 安装nginx
    1. 创建目录
       mkdir -p /home/nginx/conf
       mkdir -p /home/nginx/log
       mkdir -p /home/nginx/html
    2. 复制原本的文件
       docker run --name nginx -p 80:80 -d nginx
       docker cp nginx:/etc/nginx/nginx.conf /home/nginx/conf/nginx.conf
       docker cp nginx:/etc/nginx/conf.d /home/nginx/conf/conf.d
       docker cp nginx:/usr/share/nginx/html /home/nginx/
    3. 运行nginx
       docker run \
       -p 80:80 \
       --name nginx \
       -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
       -v /home/nginx/conf/conf.d:/etc/nginx/conf.d \
       -v /home/nginx/log:/var/log/nginx \
       -v /home/nginx/html:/usr/share/nginx/html \
       -d nginx:latest
    4. 安装Alist-tvbox
       1. https://github.com/power721/alist-tvbox/blob/master/doc/README_zh.md
       2. sudo bash -c "$(curl -fsSL https://d.har01d.cn/update_xiaoya.sh)"
5. 安装第三方软件包
   建立双链指向/软件包/linux