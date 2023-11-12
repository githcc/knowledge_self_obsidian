## 原则
1. 软件的选择，尽量使用scoop
2. 软件使用第三方时记得备份软件包
3. 控制好软件安装的数量，尽量使用系统自带

## 备份
1. 备份软件，第三方软件的安装包，普通文件的名称
2. 备份账号，软件账号，系统账号
3. 备份资料，项目文件，笔记文件，库文件，桌面文件

## 安装系统
使用软碟通进行系统盘制取，除非是系统版本发生大变化否则使用重置

## 安装步骤
1. 在安装系统设置
    1. 选择国家时要选择新加坡，这样初始化的软件会不同
    2. 进入页面后
        1. 登录微软账号进行激活
        2. 删除没用到的软件
        3. 对系统进行补丁的更新
2. 最基础的软件
    1. 进入阿里云获取一些基本软件或笔记本的驱动（访问云服务器的alist）
        1. 键盘fn快捷键驱动,高保真音乐驱动(笔记本)
        2. 建立双链指向/软件包/win
    2. 安装scoop
        1. Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
        2. iwr -useb gitee.com/glsnames/scoop-installer/raw/master/bin/install.ps1 | iex
        3. scoop bucket add extras
        4. scoop bucket add ScoopInstaller https://github.com/ScoopInstaller/Extras
        5. scoop bucket add sqliuchang https://github.com/sqliuchang/scoop-bucket
        6. scoop bucket add hoilc https://github.com/hoilc/scoop-lemon
        7. scoop bucket add kkzzhizhou https://github.com/kkzzhizhou/scoop-zapps
        8. scoop bucket add AntonOks https://github.com/AntonOks/scoop-aoks
        9. scoop bucket add codecopy https://github.com/codecopy/ScoopBucket
        10. scoop bucket add akirco https://github.com/akirco/aki-apps
        11. scoop install 7zip git wechat
        12. scoop install nodejs Motrix finalshell
        13. scoop install Obsidian
        14. scoop install idea-ultimate
        15. scoop install aliyundrive
3. 安装编码环境
    1. 安装idea
        1. 使用自带jdk
        2. 使用自带maven
            1. 设置mirror
                1. 仓库地址 https://developer.aliyun.com/mvn/guide
                2. 镜像地址
                    1. https://maven.aliyun.com/repository/central
                    2. https://maven.aliyun.com/repository/public
            2. 设置本地优先
                1. 在设置中搜索 Runner ,在VM Option中设置参数-DarchetypeCatalog=internal
        3. 使用git(使用Scoop)
           1. 设置代理，idea内部与idea外部都要设置
                   git config --global http.proxy 'http://localhost:7890'
           2. 登录账号
4. 安装虚拟机
    1. 控制面板开启部分软件
        1. Hyper-v
        2. windows 虚拟机监控程序平台
        3. 适用于Linux的windows子系统
    2. 微软商店
        1. 适用于linux子系统
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