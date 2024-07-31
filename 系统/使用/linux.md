## 系统的对比
1. centos 包管理工具是yum，主要特点是安全，稳定，目前当做主力进行使用
2. ubuntu 包管理工具是apt-get，有较好的桌面环境，使用时长很短，相对来说比较陌生
3. deepin 国产，有较好的桌面环境，有应用市场，对比win还是有较大差距，特别是一些小众软件，可以使用wine进行缓解,wine不太很稳定，拿deepin代替win使用还是有点吃力，不过挺久没使用了不知道现在的情况如何

## 虚拟机查看不到ip
```
cd /etc/sysconfig/network-scripts
vi ifcfg-ens33
将ONBOOT改为yes
systemctl restart network
```

## 安装ifconfig
```
yum search ifconfig
yum -y install net-tools.x86_64
```

## 安装wget
```
yum -y install wget
```

## 安装git
```
yum -y install git
```

## 安装7zip
```
yum -y install epel-release
yum -y install p7zip p7zip-plugins
```
### 使用
```
7z x xx.7z
```

##  3种虚拟机网络与宿主机连接方式
1. NAT 外面网络无法访问虚拟机，虚拟机与宿主机互通
2. 桥接 虚拟机与宿主机同一网段，虚拟机与宿主机互通
3. 主机模式 虚拟机之间可以相互通信，但无法直接访问外部网络

## 调整磁盘空间
```
lvreduce -L -40G /dev/mapper/centos-home
mkfs.xfs /dev/mapper/centos-home -f
lvextend -L +40G /dev/mapper/centos-root
xfs_growfs /dev/mapper/centos-root
```

## 卸载与挂载磁盘
```
umount /home
mkfs.xfs /dev/mapper/centos-home -f
mount /home
mkfs.xfs /dev/mapper/centos-home -f
```

## proxy
```
export http_proxy=http://ip:port
export https_proxy=http://ip:port
```
## 网络
```
yum clean all

vi  /etc/yum.repos.d/CentOS-Base.repo   #把文件中的内容全部删除之后，将下面代码添加到文件

# CentOS-Base.repo
#
# The mirror system uses the connecting IP address of the client and the
# update status of each mirror to pick mirrors that are updated to and
# geographically close to the client.  You should use this for CentOS updates
# unless you are manually picking other mirrors.
#
# If the mirrorlist= does not work for you, as a fall back you can try the 
# remarked out baseurl= line instead.
#
#
 
[base]
name=CentOS-$releasever - Base - mirrors.aliyun.com
failovermethod=priority
baseurl=http://mirrors.aliyun.com/centos/$releasever/os/$basearch/
        http://mirrors.aliyuncs.com/centos/$releasever/os/$basearch/
        http://mirrors.cloud.aliyuncs.com/centos/$releasever/os/$basearch/
gpgcheck=1
gpgkey=http://mirrors.aliyun.com/centos/RPM-GPG-KEY-CentOS-7
 
#released updates 
[updates]
name=CentOS-$releasever - Updates - mirrors.aliyun.com
failovermethod=priority
baseurl=http://mirrors.aliyun.com/centos/$releasever/updates/$basearch/
        http://mirrors.aliyuncs.com/centos/$releasever/updates/$basearch/
        http://mirrors.cloud.aliyuncs.com/centos/$releasever/updates/$basearch/
gpgcheck=1
gpgkey=http://mirrors.aliyun.com/centos/RPM-GPG-KEY-CentOS-7
 
#additional packages that may be useful
[extras]
name=CentOS-$releasever - Extras - mirrors.aliyun.com
failovermethod=priority
baseurl=http://mirrors.aliyun.com/centos/$releasever/extras/$basearch/
        http://mirrors.aliyuncs.com/centos/$releasever/extras/$basearch/
        http://mirrors.cloud.aliyuncs.com/centos/$releasever/extras/$basearch/
gpgcheck=1
gpgkey=http://mirrors.aliyun.com/centos/RPM-GPG-KEY-CentOS-7
 
#additional packages that extend functionality of existing packages
[centosplus]
name=CentOS-$releasever - Plus - mirrors.aliyun.com
failovermethod=priority
baseurl=http://mirrors.aliyun.com/centos/$releasever/centosplus/$basearch/
        http://mirrors.aliyuncs.com/centos/$releasever/centosplus/$basearch/
        http://mirrors.cloud.aliyuncs.com/centos/$releasever/centosplus/$basearch/
gpgcheck=1
enabled=0
gpgkey=http://mirrors.aliyun.com/centos/RPM-GPG-KEY-CentOS-7
 
#contrib - packages by Centos Users
[contrib]
name=CentOS-$releasever - Contrib - mirrors.aliyun.com
failovermethod=priority
baseurl=http://mirrors.aliyun.com/centos/$releasever/contrib/$basearch/
        http://mirrors.aliyuncs.com/centos/$releasever/contrib/$basearch/
        http://mirrors.cloud.aliyuncs.com/centos/$releasever/contrib/$basearch/
gpgcheck=1
enabled=0
gpgkey=http://mirrors.aliyun.com/centos/RPM-GPG-KEY-CentOS-7

```

## 查看ip
```
hostname -I
```

## 开启虚拟内存
```
cd /
sudo dd if=/dev/zero of=/swapfile bs=1k count=4096000
mkswap /swapfile
chmod +0600 /swapfile
swapon /swapfile
```

## 部署java应用
1. 直接使用dockerCompose
2. 修改环境变量
    1. vim /etc/environment 修改系统环境变量
    2. vim /etc/profile 修改用户环境变量
3. 修改mysql配置
    1. vim /etc/mysql/mysql.conf.d/mysqld.cnf
    2. bind-address = 127.0.0.1 注释掉

## 编写定时脚本
   ```
   0 9 * * * /path/to/myscript.sh
   ```

## 不同系统差异
1. 续行
    1. cmd `^`
    2. linux `\`
2. 过滤
    1. cmd `| find "str"`
    2. linux `| grep str`

## sed命令
1. **替换文本：**
   ```
   sed 's/old_text/new_text/g' filename
   ```
   这将替换文本文件中的所有匹配项。

2. **删除行：**
   ```
   sed '/pattern/d' filename
   ```
   这将删除包含指定模式的行。

3. **显示行：**
   ```
   sed -n 'p' filename
   ```
   这将只显示包含指定模式的行。

## 关机
```
shutdown -h now
```

## 执行sql
版本1
   ```
   mysql -h 119.91.23.137 -u root -p
   ```

版本2
   ```bash
   #!/bin/bash
   
   # MySQL连接信息
   MYSQL_USER="your_username"
   MYSQL_PASSWORD="your_password"
   MYSQL_HOST="localhost"
   MYSQL_DATABASE="your_database"
   
   # SQL语句
   SQL_STATEMENT="SELECT * FROM your_table;"
   
   # 执行SQL语句
   mysql -u"$MYSQL_USER" -p"$MYSQL_PASSWORD" -h"$MYSQL_HOST" -D"$MYSQL_DATABASE" -e"$SQL_STATEMENT"
   ```

## linux命令重命名
   ```
   alias ll='ls -l'
   ```

## 其它
1. 当在下载的文件的时候，可以移动目录
2. 下载结束后成功移动

## 日常使用
1. 自己的话，大多数都是用docker，用到的时候就查查docker的使用（[Docker 安装](https://blog.csdn.net/BThinker/article/details/123358697)），用了这么久对命令还不是很熟练，有点过度依赖finalshell的命令，平时都不太需要直接输入命令，以至于对目录结构都生疏了
2. 公司的话，大多数还是软件直接安装，有专门的团队，根本没机会进行安装，也有些怕（异地人员，异地机房，专门的操作间）

## 参考资料
1. 知乎：[Docker 安装](https://blog.csdn.net/BThinker/article/details/123358697) [备份至github](https://github.com/githcc/webpage_self_markdown/blob/main/csdn/Docker%20%E5%AE%89%E8%A3%85/README.md)
2. Alist：[Alist手动安装#守护进程](https://alist.nn.ci/zh/guide/install/manual.html#%E5%AE%88%E6%8A%A4%E8%BF%9B%E7%A8%8B) 
3. bilibili: [虚拟机的三种连接方式](https://www.bilibili.com/video/BV1NU4y1E7n3)
4. csdn：[虚拟内存](https://blog.csdn.net/qq_29856169/article/details/115430525)