## nginx常见配置
### 1. `server` 块
这是配置 Nginx 服务器的主要部分。它包含了服务器的监听端口、域名绑定和其他相关配置。
```nginx
server {
    listen 80;  # 监听端口
    server_name example.com;  # 域名

    location / {
        # 针对根路径的配置
    }

    location /path {
        # 针对特定路径的配置
    }
    
    # 可能包含其他配置指令
}
```

### 2. `location` 块
`location` 块用于匹配特定的 URL 路径，允许你针对这些路径进行不同的配置。
```nginx
location / {
    # 根路径的配置
}

location /images/ {
    # 图片目录的配置
}

location ~ \.php$ {
    # 匹配以 .php 结尾的 URL 的配置
}
```

### 3. `root` 和 `index`
`root` 指令定义了服务器上的网站根目录，`index` 指令定义了默认的索引文件。
```nginx
server {
    # ...
    root /var/www/html;  # 网站根目录
    index index.html index.htm;  # 默认索引文件
    # ...
}
```

### 4. 反向代理
Nginx 可以用作反向代理服务器。
```nginx
server {
    # ...
    location / {
        proxy_pass http://backend_server;  # 后端服务器地址
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        # 其他反向代理配置
    }
    # ...
}
```

### 5. SSL/TLS
配置 HTTPS 可以通过 SSL/TLS 证书来加密传输。
```nginx
server {
    # ...
    listen 443 ssl;
    ssl_certificate /path/to/ssl_certificate.crt;
    ssl_certificate_key /path/to/ssl_certificate_key.key;
    # 其他 SSL/TLS 配置
    # ...
}
```

## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)