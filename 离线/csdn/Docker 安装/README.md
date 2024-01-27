> Docker -> 虚拟化容器技术。
> Docker基于镜像，可以秒级启动各种容器。每一种容器都是一个完整的运行环境，容器之间互相隔离。

#### 

1. [官网地址](https://www.docker.com/)
2. [公共仓库](https://hub.docker.com/)
3. [安装文档](https://docs.docker.com/get-docker/)

![img](b702ed588267488fb4ace3e0c4f3ac79.png)

#### 1、选择要安装的平台

> Docker要求CentOS系统的内核版本高于3.10

```bash
uname -r #通过 uname -r 命令查看你当前的内核版本
```

 ![img](913e10d5d83a4890b90fc8a76cfeb946.png)

 [安装文档地址](https://docs.docker.com/get-docker/)

![img](5621dadeb8944189bbbc39ddd42945d7.png)

####  2、选择要安装的操作系统

![img](aa56d5f284724228acb342f0c705ef9f.png)

####  3、首先卸载已安装的Docker

> 使用[Root权限](https://so.csdn.net/so/search?q=Root权限&spm=1001.2101.3001.7020)登录 Centos。确保yum包更新到最新。

```sql
sudo yum update
```

![img](1dcffb01f0e24bc18c8e10a4886c9bce.png)

![img](5b009375aeef4aa0be16954468e06d46.png)

> 如果你的操作系统没有安装过Docker , 就不需要执行卸载命令。

```csharp
 sudo yum remove docker \

                  docker-client \

                  docker-client-latest \

                  docker-common \

                  docker-latest \

                  docker-latest-logrotate \

                  docker-logrotate \

                  docker-engine
```

![img](11e87baf543741f5ad4ac87779f346dd.png)

####  4、建立仓库

```cobol
## 安装Docker所需要的一些工具包

sudo yum install -y yum-utils

 

## 建立Docker仓库 (映射仓库地址)

sudo yum-config-manager \

    --add-repo \

    https://download.docker.com/linux/centos/docker-ce.repo
```

![img](1e11aef5627e48a8b9ba6534fa6dcb6e.png)

![img](7d59ea725f2b43cf953f3c74a63dbff6.png)

####  5、安装Docker引擎

```lua
 sudo yum install docker-ce docker-ce-cli containerd.io
```

![img](8fce674d8cf74a49aa9522026fde16cf.png)

![img](ff3077cee8ed412aa36257797b956fe2.png)

![img](5ebf135615ba41d3b4653aed39de1db8.png)

#### 6、启动Docker

```sql
sudo systemctl start docker
```

#### 7、测试 Docker 是否安装正常

```cobol
sudo docker run hello-world
```

![img](954bb95f42c14b07a97c9881d36c7948.png)

![img](ad5bdad9560e42a2979baba06228dd96.png)

备注
离线化时间为：2023/11/15