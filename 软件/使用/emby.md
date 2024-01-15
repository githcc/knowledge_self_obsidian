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
2. 下载小雅的元数据，将config.mp4放到资源目录下的temp目录
   配置目录放 docker_address.txt
   ```
   mkdir /media/temp
   cd /media/temp
   aria2c -x4 [资源路径]
   ```
3. 处理脚本
   ```
   mkdir /home/emby
   wget http://docker.xiaoya.pro/emby_plus.unzip.sh
   wget https://hub.docker.com/v2/repositories/xiaoyaliu/glue/tags/latest
   ```
4. 安装emby
   ```
   bash -c "$(curl http://docker.xiaoya.pro/emby_plus.unzip.sh)" -s 资源目录 配置目录
   cd /home/emby
   sudo sh emby_plus.unzip.sh /media /etc/xiaoya
    ```
5. 复制资源
   ```
   放入 all.mp4 config.mp4
   ```
6. 批量修改字符串
    ```
   ## 初始化
    find /media/xiaoya -type f -name '*.strm' -exec sed -i 's#DOCKER_ADDRESS#http://119.91.23.137:5344#g' {} +
    find /media/xiaoya -type f -name '*.strm' -exec sed -i 's#http://xiaoya.host:5678#http://119.91.23.137:5344#g' {} +
   
   ## 利用别人的节点
    find /media/xiaoya/电影 -type f -name '*.strm' -exec sed -i 's#http://xiaoya.host:5678#http://13.250.140.11:5678#g' {} +
    find /media/xiaoya/电视剧 -type f -name '*.strm' -exec sed -i 's#http://xiaoya.host:5678#http://47.115.222.164:5678#g' {} +
    find /media/xiaoya -type f -name '*.strm' -exec sed -i 's#http://xiaoya.host:5678#http://mydsm.jskj.eu.org:6789#g' {} +
    find /media/xiaoya/PikPak -type f -name '*.strm' -exec sed -i 's#http://mydsm.jskj.eu.org:6789#http://119.91.23.137:5344#g' {} +
   
   ## 将节点还原成自己的
    find /media/xiaoya/PikPak -type f -name '*.strm' -exec sed -i 's#http://mydsm.jskj.eu.org:6789#http://119.91.23.137:5344#g' {} +
    find /media/xiaoya/PikPak -type f -name '*.strm' -exec sed -i 's#http://47.115.222.164:5678#http://119.91.23.137:5344#g' {} +
    find /media/xiaoya/PikPak -type f -name '*.strm' -exec sed -i 's#http://13.250.140.11:5678#http://119.91.23.137:5344#g' {} +
    ```

## 磁盘空间大于140G且元数据充足
1. 安装emby
   ```
   bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh)" -s 资源目录 配置目录
   bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh)" -s /media /etc/xiaoya
   ```

## 注意
1. 要确保元数据正确
2. 要确保每一分区磁盘空间充足

## 更新元数据
```
docker stop emby
docker rm emby
rm -rf /media/config
rm -rf /etc/xiaoya

## 删除历史数据
cd /media
mv /media/xiaoya/PikPak ./
rm -rf /media/xiaoya/*
mv PikPak ./xiaoya/

mkdir -p /etc/xiaoya
放入4个配置文件
cd /media/temp
放入 all.mp4 config.mp4
cd /home/emby
sudo sh emby_plus.unzip.sh /media /etc/xiaoya
```

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