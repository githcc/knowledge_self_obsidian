## 原则
1. 软件的选择，系统自带>Scoop>官网>微软商店
2. 文件的存放，按自带的库进行存储

## 备份
1. 备份软件 第三方软件的安装包，普通文件的名称
2. 备份账号 软件账号，系统账号
3. 备份资料 项目文件，笔记文件，库文件，桌面文件，配置文件，密钥

## 系统的选择
1. 选择系统重置，无法重置或需要进行大版本升级进行步骤2
2. [win10Down](https://www.microsoft.com/zh-cn/software-download/windows10)，[win11Down](https://www.microsoft.com/zh-cn/software-download/windows11)，然后安装，之前都是找[msdn](https://msdn.itellyou.cn/)，还没试过微软的

## 安装步骤
1. 在安装系统设置
   1. 登录微软账号进行激活
   2. 删除没用到的软件
   3. 对系统进行补丁的更新
2. 最基础的软件
   1. [访问github](https://github.com/githcc/knowledge_self_obsidian/blob/main/%E7%B3%BB%E7%BB%9F/%E5%AE%89%E8%A3%85/win.md)
   2. 进入阿里云获取一些基本软件或笔记本的驱动（访问云服务器的alist）
      1. 键盘fn快捷键驱动,高保真音乐驱动(笔记本)
      2. 安装第三方软件包 [[软件/包/win/README|离线]]
   3. 安装scoop，不要使用管理员权限
      ```
      Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
      irm get.Scoop.sh -outfile 'install.ps1'
      .\install.ps1
      ```
   4. 通过scoop安装软件，不要移除main bucket
      ```
      scoop install 7zip git
      scoop bucket add githcc https://github.com/githcc/bucket_scoop
      scoop bucket add scoop-proxy-cn https://github.com/lzwme/scoop-proxy-cn
      scoop bucket add Extras
      scoop install finalshell
      scoop install vcredist2022
      scoop install notepadplusplus
      scoop install wps
      scoop install xmind
      scoop install jianying
      scoop install Axure
      scoop install Snipaste
      scoop install RaiDrive
      scoop install nodejs
      scoop install wechat
      scoop install Obsidian
      scoop install beyondcompare
      scoop install jmeter-pm
      scoop install alist
      scoop install redis
      scoop install motrix
      scoop install umi-ocr
      scoop install evcapture
      ```
3. 安装编码环境
   1. 安装idea
      1. 安装idea库的jdk，万年不变jdk8
      2. 使用自带maven
         1. 设置mirror
            1. 仓库地址 https://developer.aliyun.com/mvn/guide
         2. 设置本地优先
            1. 在设置中搜索 Runner ,在VM Option中设置参数-DarchetypeCatalog=internal
         3. 设置properties的编码
            1. 在设置中搜索 Editor ,在File Encodings中设置UTF-8
      3. 使用git(使用Scoop)
         1. 设置代理，idea内部与idea外部都要设置
               git config --global http.proxy 'http://localhost:7890'
         2. 登录账号
4. wps的去掉弹窗
   `wpscloudlaunch.exe`,`wpscloudsvr.exe`改为文本，并且改为只读
5. 破解版软件 [package-self-7z](https://github.com/githcc/package-self-7z)
   1. Typora
   2. navicat16
6. [[使用/win.md|关闭更新，关闭windows defender]]