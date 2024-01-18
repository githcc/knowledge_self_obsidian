## 媒体服务器软件对比
1. jellyfin 开源免费，推荐nyanmisaka版本，可以使用核显进行硬解
2. emby 刮削效果较好，有免费与付费版，这个作为主力
3. KODI 这个比较早期用过，感觉蛮复杂
4. plex 这个没用过

## 缺点
1. 咱无法获取最新的数据
   1. 可以选择安装微力同步

## 磁盘空间小于140G或元数据不足
1. 安装小雅
   /etc/xiaoya 目录下创建三个文件 mytoken.txt myopentoken.txt temp_transfer_folder_id.txt
    ```
    bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)"
    ```
2. 下载小雅的元数据放到资源目录下的temp目录
   配置目录放 docker_address.txt
   ```
   mkdir /media/temp
   cd /media/temp
   aria2c -x4 [资源路径]
   ```
3. 处理脚本
   ```
   mkdir /home/emby
   cd /home/emby
   wget http://docker.xiaoya.pro/emby_plus.unzip.sh
   wget https://hub.docker.com/v2/repositories/xiaoyaliu/glue/tags/latest
   ## 无法访问
   将hub.docker.com替换为googleapis.freechatgpt.cc
   ```
4. 安装emby
   ```
   bash -c "$(curl http://docker.xiaoya.pro/emby_plus.unzip.sh)" -s 资源目录 配置目录
   cd /home/emby
   sudo sh emby_plus.unzip.sh /media /etc/xiaoya
    ```

## 批量修改字符串
    ```
    find /media/xiaoya -type f -name '*.strm' -exec sed -i 's#http://xiaoya.host:5678#https://119.91.23.137#g' {} +

mv /media/xiaoya/PikPak /media
find /media/xiaoya -type f -name '*.strm' -exec sed -i 's#http://119.91.23.137#https://xiaoya.eallion.com#g' {} +
mv /media/PikPak /media/xiaoya
find /media/xiaoya -type f -name '*.strm' -exec sed -i 's#https://xiaoya.eallion.com#http://119.91.23.137#g' {} +

    ```
cp -r /etc/xiaoya_xiaohao/* /etc/xiaoya

## 磁盘空间大于140G且元数据充足
1. 安装emby
   ```
   bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh)" -s 资源目录 配置目录
   bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh)" -s /media /etc/xiaoya
   ```

## 注意
1. 要确保元数据正确
2. 要确保每一分区磁盘空间充足


## 使用小雅变化
1. 本地使用alist
   1. 能够挂载云盘，可以实现满速下载自己的网盘资源
   2. 也可以将别人分享的资源保存到自己的云盘然后进行满速下载
2. 云服务器部署alist，使用RaiDrive
   1. 了解到alist可以直接别人分享的资源，简化了下载别人资源的流程
   2. 使用raidrive，可以下载多个文件
   3. 使用云服务器，拓展了使用地点
3. 云服务器安装小雅
   1. 能够使用小雅的海量资源，免去了搜索资源的烦恼
   2. 缺点就是无法挂载资源
4. 云服务器安装alist-tvbox
   1. 解决了无法挂载资源的烦恼
5. 云服务器安装emby-小雅
   1. 添加了视频墙的功能，提高了浏览资源的感受
   2. 受限与我的云服务器只有40G，无法完全加载所有影视资源
6. 本地安装emby，使用frp对外暴漏端口
   1. 解决了无法完整安装emby的问题
   2. 又出现了一个问题就是，本地电脑不会长时间开着
   3. PikPak目录挂载在本地安装比较方便，云服务器搞代理维护起来比较费劲，有人总喜欢
7. 云服务器安装alist-tvbox，本地安装emby与alist-tvbox
   1. emby的非PikPak目录代理到云服务器的alist-tvbox
   2. PikPak目录代理到本地的alist-tvbox，只挂载PikPak分享盘，平时的不打开，启动太慢了
8. 云服务器安装alist-tvbox，配置代理，本地安装一个windows版本的emby,收藏自己喜欢的
   1. 直接搜索资源，含PikPak
   2. 直接挂载资源，含PikPak
   3. 本地启用emby
9. 最高配置时期
   1. 两个emby，一个本地windows（存放敏感数据，diy了点资源），一个本地虚拟机（小雅超集）
   2. 服务器两个alist-tvbox，通过nginx进行反向代理，实现负载均衡
10. 当前当前
    1. 只使用一个alist-tvbox
       1. 未使用emby的原因：emby无法实现让用户直接连接资源，服务器带宽成为瓶颈
       2. 仅用一个alist-tvbox的原因：自己一个人正常使用不会触发限流，服务器可以装些其它的
    2. 失去了图片墙的快乐，后续可以搞一下自定义nfo，整一个能直接访问资源的流媒体

## 参考内容
1. 知乎
   1. [小雅Xiaoya](https://zhuanlan.zhihu.com/p/673584505) [[知乎/小雅]]
2. bilibili
   1. [本地解压安装小雅Emby版](https://www.bilibili.com/video/BV1ii4y1v7E2)
   2. [小雅每日更新同步](https://www.bilibili.com/video/BV1Sw411G7cy)
3. 阿里云盘
   1. [含内容emby](https://www.aliyundrive.com/s/kFZYuw3DJwD)
4. 百度云盘
   1. [含内容微力同步](https://pan.baidu.com/s/1rgoMgMaRuxkWBr6am-t_Mg?pwd=w0yp)