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
## 参考资料
1. csdn
   1. [下断点续传工具](https://blog.csdn.net/weixin_34080903/article/details/85504081)