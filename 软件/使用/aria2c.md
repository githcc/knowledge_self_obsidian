## linux下载工具对比
1. wget 系统自带
2. aria2c 支持多线程下载


## 使用命令
1. 安装
    ```
    sudo yum -y install aria2
    ```
2. 下载，参数应该是4个线程
    ```
    aria2c -x4 [下载链接]
    ```
3. 断点续传，再次调用下载命令即可
4. 下载torrent，未尝试
    ```
    aria2c -o gutsy.torrent [torrent下载链接] 
    ```

aria2c -x4 http://119.91.23.137:5244/d/1/%E8%BD%AF%E4%BB%B6%E5%88%86%E4%BA%AB/%E5%B0%8F%E9%9B%85/%E5%B0%8F%E9%9B%85emby%E7%BB%84%E5%90%88/%E6%9C%AC%E5%9C%B0%E5%AE%89%E8%A3%85/temp/config.mp4?sign=nWCbqh_KjRDBLb-3bFKsdI7g5QLHzMnN66XpxBfdwKY=:0
aria2c -x4 http://119.91.23.137:5244/d/1/%E8%BD%AF%E4%BB%B6%E5%88%86%E4%BA%AB/%E5%B0%8F%E9%9B%85/%E5%B0%8F%E9%9B%85emby%E7%BB%84%E5%90%88/%E6%9C%AC%E5%9C%B0%E5%AE%89%E8%A3%85/temp/%E7%94%B5%E5%BD%B1.2023.mp4?sign=nIMjycD5XzQqtpDXq5W1JedLy2LMtTx28Ut1SuW6vKI=:0

## 参考资料
1. csdn
   1. [下断点续传工具](https://blog.csdn.net/weixin_34080903/article/details/85504081)