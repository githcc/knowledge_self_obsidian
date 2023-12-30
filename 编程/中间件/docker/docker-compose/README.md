## 概念
1. 用于快速部署项目

## 语法
1. environment 时区
2. docker-compose stop/start/restart/down [service-name]
3. docker-compose ps
4. docker-compose exec service-name sh
5. docker-compose logs service-name

## 命令
`docker-compose` 是用于定义和运行多容器 Docker 应用程序的工具。以下是一些常见的 `docker-compose` 命令：

### 1. 启动容器
```bash
docker-compose up
```
启动应用程序的容器。如果需要在后台运行，可以加上 `-d` 参数。

### 2. 停止容器
```bash
docker-compose down
```
停止并移除正在运行的容器。

### 3. 构建并启动容器
```bash
docker-compose up --build
```
重新构建镜像并启动容器。

### 4. 查看容器日志
```bash
docker-compose logs
```
查看所有容器的日志信息。可以使用 `-f` 参数实时跟踪日志输出。

### 5. 查看正在运行的容器
```bash
docker-compose ps
```
显示 `docker-compose.yml` 文件中定义的正在运行的容器列表。

### 6. 执行命令
```bash
docker-compose exec <service_name> <command>
```
在指定的服务容器中执行命令。

### 7. 指定环境变量文件
```bash
docker-compose --env-file <file_path> up
```
使用指定的环境变量文件来启动容器。

### 8. 指定工作目录
```bash
docker-compose -f <file_path> up
```
指定使用其他名称或路径的 Compose 文件。

### 9. 指定服务启动数量
```bash
docker-compose up --scale <service_name>=<number>
```
指定某个服务的启动数量。

### 10. 停止特定服务
```bash
docker-compose stop <service_name>
```
停止指定的服务。

### 11. 重新启动特定服务
```bash
docker-compose restart <service_name>
```
重启指定的服务。

### 12. 清理容器、网络等资源
```bash
docker-compose down --volumes --rmi all
```
停止并移除容器，并清理关联的卷和镜像。

这些命令可以帮助你管理使用 `docker-compose` 配置的多容器应用程序。根据具体的场景和需求，你可能会使用到不同的参数和选项。

## 编写docker-compose.yml的语法
当编写 Docker Compose 的 `docker-compose.yml` 文件时，以下是常见的语法和结构：

### 1. 定义服务
在 `docker-compose.yml` 文件中，你可以定义多个服务，每个服务对应一个容器。服务的定义包括：

- **服务名称**：给服务起一个名称，例如 `web`, `db` 等。
- **镜像**：指定容器使用的镜像名称。
- **端口映射**：将容器内部端口映射到主机上的端口。
- **环境变量**：指定容器的环境变量。
- **挂载卷**：将容器内的路径挂载到主机的路径上。

示例：

```yaml
version: '3'
services:
  web:
    image: nginx:latest
    ports:
      - "8080:80"
    environment:
      ENV_VAR: value
    volumes:
      - /path/on/host:/path/in/container
  db:
    image: mysql:latest
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: example
```

### 2. 版本
指定 Docker Compose 文件的版本，不同版本支持不同的语法和功能。

```yaml
version: '3.8'
```

### 3. 网络设置
定义自定义网络以供服务之间通信。

```yaml
networks:
  mynetwork:
    driver: bridge
```

### 4. 部署配置
用于指定服务的部署配置，例如部署在哪些节点、副本数量等。

```yaml
services:
  web:
    deploy:
      replicas: 5
      placement:
        constraints: [node.role == manager]
```

### 5. 扩展性
Docker Compose 文件支持变量、引用等，可以使其更具可配置性和可重用性。

```yaml
services:
  web:
    image: "nginx:${NGINX_VERSION}"
```

### 6. 包括其他文件
可以使用 `docker-compose.yml` 文件中的 `extends` 和 `files` 字段引用其他文件的服务配置。

```yaml
services:
  web:
    extends:
      file: common-services.yml
      service: web
```

### 7. 卷和挂载
定义卷，将主机的目录挂载到容器内部。

```yaml
volumes:
  mydata:
    driver: local
    driver_opts:
      type: none
      device: /path/on/host
      o: bind
```

以上是 Docker Compose 文件中常见的语法和结构。你可以根据具体需求和场景来定义和配置服务。


## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)