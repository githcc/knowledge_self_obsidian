## 情况
1. http转https报错：reactor.netty.http.client.PrematureCloseException: Connection prematurely closed BEFORE response

## 排查情况
1. 使用poe，修改nginx的配置，无效
2. 将版本改为1.18后正常，也需要修改配置`nginx.conf`中`http`
```
proxy_buffers           32 4k;
proxy_http_version      1.1;
proxy_send_timeout      60;
proxy_read_timeout      60;
proxy_connect_timeout   60;
proxy_set_header    Connection    '';
```