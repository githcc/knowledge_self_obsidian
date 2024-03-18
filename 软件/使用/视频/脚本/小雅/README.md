## 一些准备工作
1. docker 安装
2. wget 安装
3. 调整磁盘空间

## 小雅
http://alist.xiaoya.pro/ [备份至github](https://github.com/githcc/webpage_self_markdown/blob/main/%E5%8D%9A%E4%B8%BB/%E5%B0%8F%E9%9B%85/README.md)

一键安装和更新容器，标准模式，打开端口 5678
bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)"

一键安装和更新容器，host模式（推荐，软路由和NAS上更少网络故障，打开端口 5678）
bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)" -s host

webdav 账号密码
用户: guest 密码: guest_Api789

## 小雅tv
https://github.com/power721/alist-tvbox

sudo bash -c "$(curl -fsSL https://d.har01d.cn/update_xiaoya.sh)"

docker run -d -p 4567:4567 -p 5344:80 -e ALIST_PORT=5344 -v /etc/xiaoya:/data --restart=always --name=xiaoya-tvbox haroldli/xiaoya-tvbox:latest

## 小雅emby
https://fuliapp.top/216.html

基础小雅
bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)"

自动清理
bash -c "$(curl -s https://xiaoyahelper.zngle.cf/aliyun_clear.sh | tail -n +2)" -s 3

emby主体
bash -c "$(curl http://docker.xiaoya.pro/emby.sh)" -s /媒体库目录
