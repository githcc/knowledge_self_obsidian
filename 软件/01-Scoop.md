## 软件安装方式对比
|                        | 第三方 | 第三方（绿色） | 官网   | 应用商店 | Scoop |
|------------------------|-----|---------|------|------|-------|
| 软件选择                   | 丰富  | 丰富      | 一般   | 一般   | 较差    |
| 软件来源                   | 不确定 | 不确定     | 安全   | 安全   | 安全    |
| 软件的额外功能                | 是   | 是       | 否    | 否    | 否     |
| 下载速度                   | 快   | 快       | 快    | 极快   | 一般    |
| 安装方式                   | 手动  | 手动      | 手动   | 自动   | 自动    |
| 是否捆绑软件                 | 大概率 | 否       | 较大概率 | 否    | 否     |
| 是否有残留                  | 大概率 | 否       | 较大概率 | 否    | 较大概率  |
| 对系统侵入（注册表，配置，AppData等） | 是   | 极少      | 是    | 是    | 极少    |

## 软件安装方式选择变化
第三方（无所谓）->官网（有了安全意识）->应用商店（统一管理）->官网+第三方（爱折腾）
当前：
1. 旧版本，破解来自第三方，如Navicat，IDM，Typroa
2. 一般的软件来自Scoop，如微信，FinalShell，IDEA Ultimate
3. Scoop安装失败的就找官方，如vmware，报错提示hash校验失败，重试过一次还是不行，不折腾了

## Scoop优点
1. 软件的绝大多数内容都存放于scoop目录下，控制面板都不知道软件的存在
2. 准备好脚本，可以快速的进行安装软件，特别是刚安装好系统的时候
3. 大多数情况可以进行一键安装，卸载，对系统侵入较少
4. 对软件的内容进行了区分，如默认放用户目录，安装包，软件内容，用户数据，软链接
5. 较为方便进行版本切换

## Scoop缺点
1. 对于高权限的软件可能会安装失败，不建议使用Scoop进行安装
2. 软件不全，可以添加bucket进行缓解
3. 一些开机自启动作需要自己来设置
4. 下载可能较慢，dddd

## 以前的烦恼，Scoop可以解决一部分
1. 桌面的鼠标右键菜单被随意修改，很多都是自己用不到的
2. 随意修改此电脑中的网络位置，主要是改得格格不入
3. 软件在左下角进行弹窗，各种烦人的时间，天气，广告等
4. 软件安装时遗漏点击取消捆绑软件，有些无法解除捆绑
5. 卸载软件时，各种留人操作
6. 小部分软件因为删除不干净无法重装，比如mysql，mysql的安装是有些烦

## Scoop安装
````
# 设置 PowerShell 执行策略
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
# 下载安装脚本
irm get.Scoop.sh -outfile 'install.ps1'
# 执行安装, --ScoopDir 参数指定 Scoop 安装路径
.\install.ps1 -ScoopDir 'C:\Scoop'
````

## bucket来源网站
1. https://rasa.github.io/Scoop-directory/search
2. https://Scoop.sh/

## 常见的bucket
1. main - Default bucket for the most common (mostly CLI) apps
2. extras - Apps that don’t fit the main bucket’s criteria
3. games - Open source/freeware games and game-related tools
4. nerd-fonts - Nerd Fonts
5. nirsoft - A subset of the 250 Nirsoft apps
6. java - Installers for Oracle Java, OpenJDK, Zulu, ojdkbuild, AdoptOpenJDK, 7. Amazon Corretto, BellSoft Liberica & SapMachine
7. jetbrains - Installers for all JetBrains utilities and IDEs
8. nonportable - Non-portable apps (may require UAC)
9. php - Installers for most versions of PHP
10. versions - Alternative versions of apps found in other buckets

## Scoop常用命令
* **install**：安装软件包。
    * 方法一：`Scoop install <app>`，其中 `<app>` 是软件包名称。
    * 方法二：`Scoop install <app>@<version>`，其中 `<app>` 是软件包名称 `<version>`是软件版本。
    * 方法二：`Scoop install <source>/<app>`，其中 `<source>`是存储库 `<app>` 是软件包名称。
* **uninstall**：卸载软件包。语法：`Scoop uninstall <app>`，其中 `<app>` 是软件包名称。
* **update**：更新软件包。
    * 方法一：`Scoop update <app>`，其中 `<app>` 是软件包名称。
    * 方法二：`Scoop update *`，其中 `*` 是指代所有软件包。
* **list**：列出已安装的软件包。语法：`Scoop list`。
* **search**：搜索软件包。语法：`Scoop search <keyword>`，其中 `<keyword>` 是软件包名称或关键字。
* **bucket**：管理软件包存储桶。语法：`Scoop bucket <command>`，其中 `<command>` 可以是以下命令：
    * `add`：添加软件包存储桶。语法：`Scoop bucket add <bucket>`
    * `list`：列出已添加的软件包存储桶。语法：`Scoop bucket list`
    * `rm`：删除软件包存储桶。语法：`Scoop bucket rm <bucket>`
    * `known`：查看在线的软件包存储桶。语法：`Scoop bucket known`
* **info**：查看软件包信息。语法：`Scoop info <app>`，其中 `<app>` 是软件包名称。
* **cache**：管理软件包缓存。语法：`Scoop cache <command>`，其中 `<command>` 可以是以下命令：
    * `show`：列出软件包缓存。语法：`Scoop cache show`
    * `clear`：清除软件包缓存。语法：`Scoop cache clear`
    * `rm`：删除软件包缓存。语法：`Scoop cache rm <app>`，其中 `<app>` 是软件包名称。

## 建议Scoop安装的软件包
1. 7zip 用于解压
2. git 用于使用bucket
3. aria2 用于加速下载

## 其它
1. 可以对persist目录中已卸载的软件进行手动删除
2. 卡顿时点击控制台，任意输入字符，windows自带控制台的通病
3. 安装失败可以尝试重新安装
4. 不太喜欢弄主题

## 未尝试的内容
1. 同一个软件需要多个版本，之前nodejs遇到过，jdk有着多个版本，然而<app>就不一样，后面有遇到再利用Scoop进行补充
2. 整个虚拟机重新安装一遍Scoop
3. 自己弄一个bucket（将破解或旧版本的软件进行一个汇总）


## 我的软件情况
不过我对bucket进行过删除
````
C:\Users\wyswy>Scoop list
Installed apps:

Name          Version              Source   Updated             Info
----          -------              ------   -------             ----
7zip          23.01                main     2023-11-10 06:02:24
aliyundrive   4.9.14               akirco   2023-11-10 08:00:28
aria2         1.36.0-1             akirco   2023-11-11 21:37:56
dark          3.11.2               main     2023-11-10 06:33:57
finalshell    4.2.4.2              codecopy 2023-11-10 06:55:45
git           2.42.0.2             main     2023-11-10 06:02:34
idea-ultimate 2023.2.5-232.10227.8 extras   2023-11-10 07:38:51
innounp       0.50                 main     2023-11-10 06:04:46
Motrix        1.8.19               extras   2023-11-10 06:35:43
nodejs        21.1.0               main     2023-11-10 06:33:56
Obsidian      1.4.16               extras   2023-11-10 06:35:48
python        3.12.0               main     2023-11-10 06:35:04
vcredist2015  14.0.24215.1         akirco   2023-11-10 07:13:55
vlc           3.0.20               extras   2023-11-11 10:53:52
wechat        3.9.7.29             extras   2023-11-10 06:31:25
xmind         23.09.11172          akirco   2023-11-10 07:55:11

C:\Users\wyswy>Scoop bucket list

Name            Source                                                                   Updated             Manifests
----            ------                                                                   -------             ---------
akirco          https://Scoop.201704.xyz/https://github.com/akirco/aki-apps              2023/11/11 17:12:59       321
extras          https://proxy.201704.xyz/https://github.com/ScoopInstaller/Extras        2023/11/11 20:29:12      1888
hoilc           https://proxy.201704.xyz/https://github.com/hoilc/Scoop-lemon            2023/11/11 20:26:24       889
main            https://proxy.201704.xyz/https://github.com/ScoopInstaller/Main          2023/11/11 16:24:49      1262
ScoopInstaller  https://proxy.201704.xyz/https://github.com/ScoopInstaller/Extras        2023/11/11 20:29:12      1888
ScoopInstaller2 https://Scoop.201704.xyz/https://github.com/ScoopInstaller/Versions      2023/11/11 20:42:16       429
winapps-share   https://Scoop.201704.xyz/https://github.com/WinApps-share/WinApps-bucket 2023/11/11 20:51:02        82
````

参考资料来自：
1. wiki：https://csdiy.wiki/%E5%BF%85%E5%AD%A6%E5%B7%A5%E5%85%B7/Scoop/
2. bilibili: https://www.bilibili.com/video/BV1dY411G7cT
3. google：https://bard.google.com/
4. csdn: https://blog.csdn.net/weixin_42250302/article/details/124733053
5. 博客园：https://www.cnblogs.com/sleepyocean/p/17017084.html