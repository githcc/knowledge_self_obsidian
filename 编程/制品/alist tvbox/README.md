## 说明
1. 访问 4567 端口，admin/admin
2. Alist-tvbox默认访客账号：guest guest_Api789
3. 阿里云盘资源下面要放一个目录
4. 安装Alist-tvbox的时候，阿里云盘的资源库需要把xiaoya-tvbox-temp给清理了
5. Alist-tvbox 中的小雅设置代理
   ```
   location /🈴我的阿里分享 {
      proxy_pass http://<内网ip>:5344/🈴我的阿里分享;
   }
   location /assets {
      proxy_pass http://<内网ip>:5344/assets;
   }
   location /api {
      proxy_pass http://<内网ip>:5344/api;
   }
   location /static {
      proxy_pass http://<内网ip>:5344/static;
   }
   location /images {
      proxy_pass http://<内网ip>:5344/images;
   }
   location /d {
      proxy_pass http://<内网ip>:5344/d;
   }
   ```

## 参考资料
1. Alist-tvbox：[alist-tvbox](https://github.com/power721/alist-tvbox/blob/master/doc/README_zh.md)