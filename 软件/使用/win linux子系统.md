## 安装步骤
1. 控制面板开启部分软件
    1. Hyper-v
    2. windows 虚拟机监控程序平台
    3. 适用于Linux的windows子系统
2. 微软商店
    1. windows subsystem for linux
    2. ubuntu
3. 开启finalshell访问
   sudo apt-get remove --purge openssh-server   ## 先删ssh
   sudo apt-get install openssh-server          ## 在安装ssh
   sudo rm /etc/ssh/ssh_config                  ## 删配置文件，让ssh服务自己想办法链接
   sudo service ssh --full-restart
4. 使用代理
    1. cat /etc/resolv.conf
    2. 可以设置进全局文件 /etc/profile
    3. export http_proxy="http://172.30.0.1:7890"
5. 使用root
    1. jd@pc-hz20122309:~$ sudo passwd
       [sudo] password for jd:输入当前用户的密码
       Enter new UNIX password:设置root用户的密码
       Retype new UNIX password:再次输入设置root用户的密码
       passwd: password updated successfully