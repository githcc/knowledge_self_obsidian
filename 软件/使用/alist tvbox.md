## 亮点
1. 挂载别人的分享云盘
   1. 使用网盘搜索内容，增加了搜索渠道
   2. 不需要把别人内容进行转存即可高速下载
   3. 目前支持
      1. 阿里云盘
      2. pikpak分享 新加坡的一款网盘，内容限制较松
      3. 夸克网盘
2. tvbox新版本
   1. 支持低码率视频播放，避免电视无法流畅播放部分4k资源
3. 对于需要原画播放，使用播放器打开网页资源或使用RaiDrive的方式
4. 使用RaiDrive访问
   1. 挂载不会导致限流
   2. RaiDrive只会单线程访问/下载

## 安装命令
   /etc/xiaoya 目录下创建三个文件 mytoken.txt myopentoken.txt temp_transfer_folder_id.txt
   ``` linux
   sudo bash -c "$(curl -fsSL https://d.har01d.cn/update_xiaoya.sh)"
   ```
   ``` docker
   docker run -d -v /etc/xiaoya:/etc/xiaoya -p 4567:4567 -p 5344:80 -e ALIST_PORT=5344 --restart=always --name=xiaoya-tvbox \
    -e  "HTTP_PROXY=http://x.x.x.x:7890" \
    -e  "HTTPS_PROXY=http://x.x.x.x:7890" \
    -e  "NO_PROXY=localhost,127.0.0.1,.example.com" \
   haroldli/xiaoya-tvbox:latest
   ```