# [【好软推荐】Scoop - Windows快速软件安装指南](https://www.cnblogs.com/sleepyocean/p/17017084.html)

在平常生活中如果要安装像git、java、node这些环境的时都需要先去官网下载安装程序，点击安装，之后还需要配置，不仅过程麻烦，而且工具多了之后整理起来也相当不容易，配置也很杂，整个电脑就像被污染了一样。而scoop可以很好地解决这一问题，安装scoop后，只需要在命令行输入简单的一串命令即可安装你想要的软件。

比如我想安装git，只需要输入

```bash
复制代码
1
BASH$ scoop install git
```

然后就可以直接使用git命令了，是不是很简单。

如果我想卸载git，只需输入

```bash
复制代码
1
BASH$ scoop uninstall git
```

然后git就干干净净的从你的电脑中消失啦_

## Scoop 介绍

Scoop是Windows的命令行安装程序，是一个强大的包管理工具。

官方网址： [Scoop.sh](https://scoop.sh/)

官方Github仓库： [Scoop - GitHub](https://github.com/lukesampson/scoop)

## Scoop 安装

有梯子的话，尽可能按照官方的配置来。没有的话，参考“配置国内源”的操作

### 环境需求

1. Windows 7 SP1 + / Windows Server 2008+
2. PowerShell 5（或更高版本，包括PowerShell Core）和.NET Framework 4.5（或更高版本）
3. 必须为您的用户帐户启用PowerShell，例如 Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser

### 安装

在PowerShell中运行以下命令，将scoop安装到其默认位置

```shell
复制代码123456789101112131415161718SHELL# 配置安装环境
> Set-ExecutionPolicy RemoteSigned -scope CurrentUser
> $env:SCOOP='D:\Scoop'
> [Environment]::SetEnvironmentVariable('SCOOP',$env:SCOOP,'User')

# 设置scoop global环境变量
> $env:SCOOP_GLOBAL='D:\ScoopGlobalApps'
> [Environment]::SetEnvironmentVariable('SCOOP_GLOBAL',$env:SCOOP_GLOBAL,'User')

# 安装命令 （建议：使用全局magic上网运行最佳。先打开magic上网工具，然后重启shell，执行y安装命令）
> Invoke-Expression (New-Object System.Net.WebClient).DownloadString('https://get.scoop.sh')
# 或
> iwr -useb get.scoop.sh | iex
# GitHub访问不畅时，上面两条命令都会不成功。当然我们还有备选方案：配置hosts（配上访问raw.githubusercontent.com最快的ip到hosts中），然后再试试下面的命令
> iex (new-object net.webclient).downloadstring('https://raw.githubusercontent.com/lukesampson/scoop/master/bin/install.ps1')  

# 安装完成后，输入下面命令验证是否成功（常见的命令可以通过此方法来查看）
> scoop help
```

关于如何加速访问Github：https://github.com/521xueweihan/GitHub520

Windows的hosts路径： `C:\Windows\System32\drivers\etc\hosts`

### 配置官方源

panda建议开启**全局VPN模式**

```shell
复制代码1234567SHELLscoop bucket add main

scoop bucket add extras

scoop bucket add java

...
```

更多 Buckets 参见：[buckets](https://scoop.sh/#/buckets)

### 配置国内源

由于GitHub在国内访问速度不理想，所以提供国内镜像作为备选方案

```shell
复制代码12345678SHELL# 配置git环境
> scoop install git

# 安装aria2，加速下载
> scoop install aria2

# 配置是否使用aria2下载，false为禁用，true为启用
> scoop config aria2-enabled true
```

国内镜像加速方案

```bash
复制代码
1
BASHscoop bucket add main https://codechina.csdn.net/mirrors/ScoopInstaller/Main.git
复制代码
1
BASHscoop bucket add extras https://codechina.csdn.net/mirrors/lukesampson/scoop-extras.git
复制代码
1
BASHscoop bucket add nonportable https://codechina.csdn.net/mirrors/TheRandomLabs/scoop-nonportable
复制代码
1
BASHscoop bucket add nirsoft https://codechina.csdn.net/mirrors/kodybrown/scoop-nirsoft.git
复制代码
1
BASHscoop bucket add nerd-fonts https://codechina.csdn.net/mirrors/matthewjberger/scoop-nerd-fonts.git
复制代码
1
BASHscoop bucket add java https://codechina.csdn.net/mirrors/ScoopInstaller/Java.git
复制代码
1
BASHscoop bucket add versions https://codechina.csdn.net/mirrors/ScoopInstaller/Versions.git
复制代码
1
BASHscoop bucket add games https://codechina.csdn.net/mirrors/Calinou/scoop-games.git
复制代码
1
BASHscoop bucket add dorado https://gitee.com/chawyehsu/dorado
```

配置国内镜像源后，更新下scoop

```bash
复制代码
1
BASHscoop update
```

更多镜像参考：[mirrors - CODE CHINA](https://codechina.csdn.net/mirrors?utf8=✓&filter=scoop&only_projects=true)

## Scoop 命令

```powershell
复制代码123456789101112131415161718POWERSHELL# 查看全部指令
> scoop
# 查看对应指令的帮助文档
> scoop cache --help
# 清理全部缓存
> scoop cache rm *

# 查看已添加的bucket
> scoop bucket list

# 查看所有已知的bucket
> scoop bucket known

# 添加一个bucket
> scoop bucket add java

# 安装指定版本的软件，以freedownloadmanager为例安装6.18.0版本
> scoop install freedownloadmanager@6.18.0
```

**常见的bucket**

1. **main** - Default bucket for the most common (mostly CLI) apps
2. **extras** - Apps that don’t fit the main bucket’s criteria
3. **games** - Open source/freeware games and game-related tools
4. **nerd-fonts** - Nerd Fonts
5. **nirsoft** - A subset of the 250 Nirsoft apps
6. **java** - Installers for Oracle Java, OpenJDK, Zulu, ojdkbuild, AdoptOpenJDK, 7. Amazon Corretto, BellSoft Liberica & SapMachine
7. **jetbrains** - Installers for all JetBrains utilities and IDEs
8. **nonportable** - Non-portable apps (may require UAC)
9. **php** - Installers for most versions of PHP
10. **versions** - Alternative versions of apps found in other buckets

## Scoop 卸载

```shell
复制代码
1
SHELL> scoop uninstall scoop
```

就这么简单😄

## 常见问题解决方案

1. 出现` 使用“1”个参数调用“DownloadString”时发生异常:“请求被中止: 未能创建 SSL/TLS 安全通道。”`错误

**A:** 原因是因为使用HttpWebRequest请求https链接时，无法访问的问题，设置ServicePointManager.SecurityProtocol安全协议。执行一下以下命令即可解决：

```powershell
复制代码
1
POWERSHELL> [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12;
```

其他参考文档：[scoop最新安装教程2021_路人夹饼的博客-CSDN博客](https://blog.csdn.net/weixin_41992772/article/details/116095119)

## 附录

### 1）scoop安装的7zip如何添加到右键菜单？

使用管理员身份运行7zipGUI，在菜单选项中即可添加。

备注
离线化时间为：2023/11/13