## 安装步骤
1. 控制面板开启部分软件
    1. Hyper-v
    2. windows 虚拟机监控程序平台
    3. 适用于Linux的windows子系统
2. 微软商店
    1. ubuntu
3. 使用root
    1. jd@pc-hz20122309:~$ sudo passwd
       [sudo] password for jd:输入当前用户的密码
       Enter new UNIX password:设置root用户的密码
       Retype new UNIX password:再次输入设置root用户的密码
       passwd: password updated successfully
4. 开启finalshell访问
   apt-get update
   sudo apt-get remove --purge openssh-server   ## 先删ssh
   sudo apt-get install openssh-server          ## 在安装ssh
   sudo rm /etc/ssh/ssh_config                  ## 删配置文件，让ssh服务自己想办法链接
   sudo service ssh --full-restart
5. 使用代理，也可以使用clash的TUN mode
    1. 直接填192.168.x.x即可,注意检查防火墙

## 使用docker
### wsl1
1. 对docker进行设置
   General/开启 Expose daemon on tcp://localhost:2375 without TLS
2. 配置阿里云的gpg
    ```
    curl -fsSL https://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | sudo apt-key add -
    ```
3. 配置阿里云的镜像
    ```
    sudo add-apt-repository "deb [arch=amd64] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable"
    ```
4. 安装客户端
    ```
    apt install docker.io
    ```
5. 安装完成后配置docker_host连接向docker for windows
    ```
    export DOCKER_HOST=tcp://localhost:2375
    ```
### wsl2
1. 对docker进行设置
   Resources/WSL Integration/开启ubuntu