## 大致情况
1. 电脑
   1. 输入：浏览器
   2. 输出：github
2. 手机
   1. 输入：浏览器，微信，tg
   2. 输出：微信收藏

## 竞争力
1. 效率 单位时间可以干更多的活，可以懒但不可以菜
2. 兴趣 好奇心才会孜孜不倦的深入学习
3. 主动 到一些关键节点，需要主动掌握话语权

## 电脑
1. 主要进行办公，学习，娱乐
2. [[系统/安装/win.md#安装步骤|进行电脑的系统安装]]
3. 能使用网页的尽量使用网页，其次使用Scoop进行安装
4. 工作结束后将内容合并入当前项目，一定要区分公司资料与知识，尽量进行转述
```
C:\Users\wyswy>scoop list
Installed apps:

Name            Version                Source Updated             Info
----            -------                ------ -------             ----
7zip            23.01                  main   2024-05-01 14:03:02
alist           3.33.0                 main   2024-05-01 14:36:26
aria2           1.37.0-1               spc    2024-05-02 03:40:48
dark            3.14                   main   2024-05-01 14:25:43
evcapture       5.0.7                  spc    2024-05-02 03:30:18
ffmpeg          7.0                    main   2024-05-05 04:02:13
finalshell      4.3.10                 githcc 2024-05-01 14:08:05
git             2.45.0                 main   2024-05-01 14:03:52
idea-ultimate   2024.1.1-241.15989.150 spc    2024-05-02 15:57:09
motrix          1.8.19                 spc    2024-05-01 15:58:56
nodejs18        18.20.2                spc    2024-05-02 09:03:04
notepadplusplus 8.6                    githcc 2024-05-01 14:08:24
Obsidian        1.5.12                 spc    2024-05-01 14:35:02
python311       3.11.9                 spc    2024-05-13 17:55:50
RaiDrive        2019.12.22             githcc 2024-05-01 14:28:57
redis           7.2.4                  main   2024-05-01 14:36:33
scoop-search    1.4.1                  spc    2024-05-02 03:40:51
Snipaste        1.16.2                 spc    2024-05-01 15:51:16
umi-ocr         2.1.1                  spc    2024-05-01 14:37:12
vcredist2022    14.38.33135.0          spc    2024-05-01 14:23:15
wechat          3.9.10.19              spc    2024-05-01 14:34:36
xmind           12.0.3                 githcc 2024-05-01 14:25:36
```

## 手机
1. 主要用于记录生活的事情，沟通
2. [[系统/安装/android.md#安装步骤|进行手机的系统安装]] 
3. 把信息输出到微信收藏，少玩手机多发呆

## 服务器
1. 主要用于搭建Alist，小雅
2. 整一个网站 [主页](http://119.91.23.137/) 
```
[root@VM-8-14-centos ~]# docker ps
CONTAINER ID   IMAGE                    COMMAND                   CREATED        STATUS        PORTS                                                                                                                                                                                                                                                                                                                                        NAMES
cd610e398bc3   snowdreamtech/frps       "/bin/sh -c '/usr/bi…"   2 hours ago    Up 2 hours                                                                                                                                                                                                                                                                                                                                                 frps
12c92d22a5cf   nginx:latest             "/docker-entrypoint.…"   6 days ago     Up 34 hours   0.0.0.0:80->80/tcp, :::80->80/tcp, 0.0.0.0:443->443/tcp, :::443->443/tcp, 0.0.0.0:4040->4040/tcp, :::4040->4040/tcp, 0.0.0.0:5050->5050/tcp, :::5050->5050/tcp, 0.0.0.0:6060->6060/tcp, :::6060->6060/tcp, 0.0.0.0:7070->7070/tcp, :::7070->7070/tcp, 0.0.0.0:8080->8080/tcp, :::8080->8080/tcp, 0.0.0.0:9090->9090/tcp, :::9090->9090/tcp   nginx
fd4e695567a2   jdk17_server             "/__cacert_entrypoin…"   6 days ago     Up 6 days     0.0.0.0:19090->8080/tcp, :::19090->8080/tcp                                                                                                                                                                                                                                                                                                  jdk17_server
b81ff4dc6e55   lobehub/lobe-chat        "docker-entrypoint.s…"   3 weeks ago    Up 3 weeks    0.0.0.0:3210->3210/tcp, :::3210->3210/tcp                                                                                                                                                                                                                                                                                                    lobe-chat
b87d2a973a39   xiaoyaliu/alist:latest   "/entrypoint.sh /opt…"   4 weeks ago    Up 4 weeks    0.0.0.0:5678->80/tcp, :::5678->80/tcp                                                                                                                                                                                                                                                                                                        xiaoya_dahao
5e149fb938db   mysql                    "docker-entrypoint.s…"   2 months ago   Up 3 weeks    0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp                                                                                                                                                                                                                                                                                         mysql8-db-1
822137e74302   redis                    "docker-entrypoint.s…"   3 months ago   Up 5 weeks    0.0.0.0:6379->6379/tcp, :::6379->6379/tcp                                                                                                                                                                                                                                                                                                    redis  
```
