## 常见的证书申请地址
1. [zerossl](https://zerossl.com/) 主力
2. [阿里云](https://common-buy.aliyun.com/?spm=a2c4g.205510.0.0.6c2b64ccJXn2uQ&commodityCode=cas_dv_public_cn&request=%7B"product"%3A"free_product"%7D)
3. [lddgo](https://www.lddgo.net/encrypt/ssl)

## zerossl安装ssl证书步骤
1. 进入zerossl官网申请证书
2. 校验网站
3. 下载证书
4. 合并证书后
5. 安装证书
    ```
    return  301 https://$server_name$request_uri;
   
    server {
        # >>>重点
        listen               443 ssl;
        ssl_certificate /home/nginx/cert/certificate.crt;
        ssl_certificate_key /home/nginx/cert/private.key;
        #请按照以下协议配置
        ssl_protocols TLSv1.2 TLSv1.3; 
        #请按照以下套件配置，配置加密套件，写法遵循 openssl 标准。
        ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE; 
        ssl_prefer_server_ciphers on;
        
        server_name  localhost;
        access_log   /var/log/nginx/access.log;
        error_log    /var/log/nginx/error.log;
        location / {
           root   /usr/share/nginx/html;
           index  index.html index.htm;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
           root   /usr/share/nginx/html;
        }
    }
    ```

## 一些容易遗忘事项
1. 服务器的端口，容器的端口
2. 容器的虚拟目录设置

## 参考资料
1. 知乎：[33种免费获取SSL证书](https://zhuanlan.zhihu.com/p/174755007) [[离线/网页/知乎/ssl/README| 离线]]
2. 博客园：[支持IP绑定免费的SSL证书](https://www.cnblogs.com/aiyablog/articles/16703959.html) [[离线/网页/博客园/ssl/README| 离线]]