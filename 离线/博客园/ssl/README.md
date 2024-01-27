# [支持IP绑定免费的SSL证书申请及部署 ](https://www.cnblogs.com/aiyablog/articles/16703959.html)

# 1. 申请

在**ZeroSSl**https://app.zerossl.com/certificate/new 上，只需要简单注册进行ip申请即可，根据页面引导选择90天的免费SSl证书进行申请。

- 优点：免费，简单，快捷，支持ip绑定
- 缺点：只有90天期限，过期需要手动进行续期

# 2. 重点步骤提示

服务器验证使用`HTTP 文件上传`，只需要在服务器建起一个web服务，让`http: //yourHost/.well-known/pki-validation/随机名称.txt`能够正常访问到所下载的文件（随机名称.txt）内容即可。推荐使用flask建立服务。

flask代码参考：

```python
from flask import Flask

app = Flask(__name__)

@app.route('/.well-known/pki-validation/随机名称.txt', methods=['GET'])
def certificate_verify():
    with open('/.well-known/pki-validation/随机名称.txt', 'r') as f:
        data = f.read()

    return data


if __name__ == '__main__':
    app.run('0.0.0.0', port=7999, debug=True)
```

nginx代码参考：

```nginx
location /.well-known/pki-validation {
    proxy_pass http://localhost:7999;
}
```

![image](2437011-20220918191121378-300258450.png)

![image](2437011-20220918191131575-1192596654.png)

根据你的服务器类型选择证书下载，这里以nginx为演示：

![image](2437011-20220918191145108-1256544890.png)

# 3. 证书安装（以nginx为例，其他可参考官网）

- **上传证书文件**

  首先，您需要将上面的证书文件（certificate.crt、ca_bundle.crt 和 private.key）上传到`/etc/ssl`目录中。

- **合并 .crt 文件**

  NGINX 要求合并所有 .crt 文件以允许安装 SSL，否则ZeroSSl检查安装也不会通过。您需要运行以下命令来合并您的 certificate.crt 和 ca_bundle.crt 文件。

  ```shell
  $ cat /etc/ssl/certificate.crt /etc/ssl/ca_bundle.crt >> /etc/ssl/certificate.chained.crt
  ```

- **编辑虚拟主机文件**

  接下来，您需要找到您的NGINX配置文件nginx.conf，添加一些代码以将其指向您的新 SSL 证书。

  #### 请注意

  如果您需要通过 HTTPS（安全）和 HTTP（非安全）访问您的站点，则每种连接类型都需要一个单独的server模块。

  将重点行添加 到您的nginx.conf配置文件中：

  ```nginx
  server {
  	# >>>重点
  	listen               443 ssl;
  	ssl_certificate      /etc/ssl/certificate.chained.crt.crt; 
  	ssl_certificate_key  /etc/ssl/private.key;
  	#请按照以下协议配置
  	ssl_protocols TLSv1.2 TLSv1.3; 
  	#请按照以下套件配置，配置加密套件，写法遵循 openssl 标准。
  	ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE; 
  	ssl_prefer_server_ciphers on;
  	# <<<
      
  	server_name  your.domain.com;
  	access_log   /var/log/nginx/nginx.vhost.access.log;
  	error_log    /var/log/nginx/nginx.vhost.error.log;
  	location / {
  		root     /home/www/public_html/your.domain.com/public/;
  		index    index.html;
  	}
  }
  ```

  或者通过sed命令直接替换：

  ```shell
  # 直接运行下述命令，注意你的nginx.conf的路径，这里是/usr/local/nginx/conf/nginx.conf
  
  sed -i ':a;N;s|listen\s\+80;|listen               443 ssl;\n        ssl_certificate      /etc/ssl/certificate.chained.crt;\n        ssl_certificate_key  /etc/ssl/private.key;\n|;$!ba' /usr/local/nginx/conf/nginx.conf
  ```

  `nginx.conf`路径查询：

  - 直接查找：`which nginx` 或 `whereis nginx`
  - 通过包安装信息查找：
    - 查询rpm包名：`rpm -qa|grep nginx`
    - 查询rpm包安装路径：`rpm -ql 包名`

- **安装ngx_http_ssl_module模块（如已安装过可跳过）**

  **1. 能找到原先nginx安装包的情况：**

  找到nginx安装包，将`http_ssl_module`编译进去

  ```shell
  cd /your/nginx/package_dir 
  
  ./configure --prefix=/usr/local/nginx --with-http_stub_status_module --with-http_ssl_module && make
  ```

  备份并替换原来的nginx执行文件

  ```shell
  cp /usr/local/nginx/sbin/nginx /usr/local/nginx/sbin/nginx_bak && cp ./objs/nginx /usr/local/nginx/sbin/
  ```

  提示覆盖输入y覆盖

  **2. 找不到原安装包情况：**

  备份配置文件并覆盖安装包含http_ssl_module模块的新nginx：

  ```shell
  killall nginx && mv /usr/local/nginx/conf/nginx.conf ~ && cd /usr/local/src && wget https://nginx.org/download/nginx-1.22.0.tar.gz && tar -xvhf nginx-1.22.0.tar.gz && cd nginx-1.22.0 && ./configure --prefix=/usr/local/nginx --with-http_stub_status_module --with-http_ssl_module && make && make install && mv ~/nginx.conf /usr/local/nginx/conf/ && nginx
  ```

  提示覆盖输入y覆盖，此示例nginx安装路径为/usr/local/nginx

- **配置https服务（以django为例）**

  nginx配置：

  ```nginx
  server {
      listen       80; 
      server_name  your_domain.com www.your_domain.com;
      return       301 https://$server_name$request_uri; # 永久重定向
  }
  ```

  django配置：

  ```ini
  # https配置
  # SECURITY安全设置 - 支持http时建议开启
  SECURE_PROXY_SSL_HEADER = ("HTTP_X_FORWARDED_PROTO", "https")
  # SECURE_SSL_REDIRECT = True  # 将所有非SSL请求永久重定向到SSL，建议nginx启用，以方便本地调试
  SESSION_COOKIE_SECURE = True  # 仅通过https传输cookie
  CSRF_COOKIE_SECURE = True  # 仅通过https传输cookie
  SECURE_HSTS_INCLUDE_SUBDOMAINS = True  # 严格要求使用https协议传输
  SECURE_HSTS_PRELOAD = True  # HSTS预加载
  SECURE_HSTS_SECONDS = 60
  SECURE_CONTENT_TYPE_NOSNIFF = True  # 防止浏览器猜测资产的内容类型
  ```

- **重启服务器**

  最后，您需要重新启动 NGINX 服务器以使您的更改生效。您可以运行以下命令来重新启动您的 NGINX 服务器：

  ```shell
  nginx -s reload
  ```

- **检查安装**

  您已完成安装 SSL 证书所需的所有步骤。要检查您的证书是否已正确安装，只需使用内置的 ZeroSSL`检查安装`工具或尝试使用 HTTPS 访问您的域，例如 **[https://domain.com](https://domain.com/)**。