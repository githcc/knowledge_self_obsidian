## 系统的对比
1. centos 包管理工具是yum，主要特点是安全，稳定，目前当做主力进行使用
2. ubuntu 包管理工具是apt-get，有较好的桌面环境，使用时长很短，相对来说比较陌生
3. deepin 国产，有较好的桌面环境，有应用市场，对比win还是有较大差距，特别是一些小众软件，可以使用wine进行缓解,wine不太很稳定，拿deepin代替win使用还是有点吃力，不过挺久没使用了不知道现在的情况如何

## Alist添加开机自启   这段代码可以用于其它软件的开机自启 #查阅/命令
使用任意方式编辑 `/usr/lib/systemd/system/alist.service` 并添加如下内容，其中 path_alist 为 AList 所在的路径

```ini
[Unit]
Description=alist
After=network.target
 
[Service]
Type=simple
WorkingDirectory=path_alist
ExecStart=path_alist/alist server
Restart=on-failure
 
[Install]
WantedBy=multi-user.target
```

然后，执行 `systemctl daemon-reload` 重载配置，现在你可以使用这些命令来管理程序：

- 启动: `systemctl start alist`
- 关闭: `systemctl stop alist`
- 配置开机自启: `systemctl enable alist`
- 取消开机自启: `systemctl disable alist`
- 状态: `systemctl status alist`
- 重启: `systemctl restart alist`

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

## 安装7zip
```
yum -y install p7zip
```

## 3种虚拟机连接方式
1. NAT 外面网络无法访问虚拟机，虚拟机与宿主机互通
2. 桥接 虚拟机与宿主机同一网段，虚拟机无法访问宿主机，宿主机可以访问虚拟机

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
export http_proxy=http://x.x.x.x:7890
export https_proxy=http://x.x.x.x:7890
```

## 日常使用
1. 自己的话，大多数都是用docker，用到的时候就查查docker的使用（[Docker 安装](https://blog.csdn.net/BThinker/article/details/123358697)），用了这么久对命令还不是很熟练，有点过度依赖finalshell的命令，平时都不太需要直接输入命令，以至于对目录结构都生疏了
2. 公司的话，大多数还是软件直接安装，有专门的团队，根本没机会进行安装，也有些怕（异地人员，异地机房，专门的操作间）

## 参考资料
1. 知乎：[Docker 安装](https://blog.csdn.net/BThinker/article/details/123358697) [[离线/网页/csdn/Docker 安装/README| 离线]]
2. Alist：[Alist手动安装#守护进程](https://alist.nn.ci/zh/guide/install/manual.html#%E5%AE%88%E6%8A%A4%E8%BF%9B%E7%A8%8B) 
3. bilibili: [虚拟机的三种连接方式](https://www.bilibili.com/video/BV1NU4y1E7n3)