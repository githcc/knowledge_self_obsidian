## 报错
### 浏览器
```
Mixed Content: The page at 'https://githcc.github.io/navigation_html/#' was loaded over HTTPS, but requested an insecure XMLHttpRequest endpoint 'http://119.91.23.137:4040/u'. This request has been blocked; the content must be served over HTTPS.
```

## 排查情况
1. 使用nginx进行中转，对外https，对内http，无效，猜测是因为springboot3的缘故
   1. 是猜错了
   2. 实际上是服务器的7070端口有问题，端口映射时最好不要相同，nginx发生端口冲突，仍然可以正常启动