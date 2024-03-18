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
}
```

## 允许跨域
```
location / {  
    add_header Access-Control-Allow-Origin *;
    add_header Access-Control-Allow-Methods 'GET, POST, OPTIONS';
    add_header Access-Control-Allow-Headers 'DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization';

    if ($request_method = 'OPTIONS') {
        return 204;
    }
} 
```

## 负载均衡
Nginx 提供了多种负载均衡的方式，主要通过配置来实现。以下是其中几种常见的负载均衡方式：

### 1. Round Robin（轮询）

这是默认的负载均衡方式，将请求按顺序分配到每个服务器。配置示例如下：

```nginx
http {
    upstream backend {
        server server1.example.com;
        server server2.example.com;
        server server3.example.com;
    }

    server {
        location / {
            proxy_pass http://backend;
        }
    }
}
```

### 2. Least Connections（最少连接数）

将请求发送到当前连接数最少的服务器。配置示例如下：

```nginx
http {
    upstream backend {
        least_conn;
        server server1.example.com;
        server server2.example.com;
        server server3.example.com;
    }

    server {
        location / {
            proxy_pass http://backend;
        }
    }
}
```

### 3. IP Hash

基于客户端 IP 地址将请求发送到同一个后端服务器，有助于保持会话的一致性。配置示例如下：

```nginx
http {
    upstream backend {
        ip_hash;
        server server1.example.com;
        server server2.example.com;
        server server3.example.com;
    }

    server {
        location / {
            proxy_pass http://backend;
        }
    }
}
```

### 4. 加权负载均衡

分配不同权重给不同的服务器，以便更精细地控制流量分配。示例如下：

```nginx
http {
    upstream backend {
        server server1.example.com weight=3;
        server server2.example.com weight=7;
    }

    server {
        location / {
            proxy_pass http://backend;
        }
    }
}
```

在以上示例中，`server1` 会获得 3/10 的流量，而 `server2` 会获得 7/10 的流量。

### 注意事项：
- 负载均衡的配置通常在 Nginx 的配置文件中，位置可以是全局的，也可以是特定的 `server` 块中。
- 在配置更改后，记得重新加载 Nginx 以使更改生效：`nginx -s reload` 或 `service nginx reload`（根据系统不同）。

根据需求和业务场景，选择适合的负载均衡方式并根据实际情况进行配置。

## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)
2. csdn：[Nginx配置跨域请求](https://blog.csdn.net/agonie201218/article/details/112562252) [备份至github](https://github.com/githcc/webpage_self_markdown/blob/main/csdn/nginx%E5%85%81%E8%AE%B8%E8%B7%A8%E5%9F%9F/README.md)