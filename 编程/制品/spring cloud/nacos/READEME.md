## 安装
官方版本
```
git clone https://github.com/nacos-group/nacos-docker.git
cd nacos-docker
docker compose -f example/standalone-mysql-8.yaml up -d
```

黑马版本
```
docker run -d \
--name nacos \
--env-file ./nacos/custom.env \
-p 8848:8848 \
-p 9848:9848 \
-p 9849:9849 \
--restart=always \
nacos/nacos-server:v2.1.0-slim
```


## 其它
官方版本需要将Dockerfile的内容进行修改
将https://raw.githubusercontent.com/alibaba/nacos/develop/distribution/conf/mysql-schema.sql上传到自己的服务器，修改其路径

## 参考资料
1. bilibili：[SpringCloud微服务技术栈实战教程](https://www.bilibili.com/video/BV1kH4y1S7wz?p=14)
2. nacos：[nacos docker](https://nacos.io/zh-cn/docs/quick-start-docker.html)
