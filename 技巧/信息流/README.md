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

Name            Version      Source     Updated             Info
----            -------      ------     -------             ----
7zip            23.01        main       2024-01-19 20:03:07
aria2           1.37.0-1     main       2024-01-19 20:03:16
dark            3.11.2       main       2024-01-22 15:09:53
finalshell      4.3.10       githcc     2024-01-19 20:18:05
git             2.43.0       main       2024-01-19 20:04:13
jianying        4.7.2.10739  githcc     2024-01-19 20:26:30
Motrix          1.8.19       githcc     2024-01-19 20:29:58
nodejs          21.6.0       main       2024-01-19 20:32:31
notepadplusplus 8.6          githcc     2024-01-19 20:20:22
Obsidian        1.5.3        Extras     2024-01-19 20:35:16
pip             23.3.2       tmp        2024-01-22 15:10:39
python          3.12.1       main       2024-01-22 15:10:07
RaiDrive        2019.12.22   kkzzhizhou 2024-01-22 15:01:06
sudo            0.2020.01.26 main       2024-01-19 20:04:16
wechat          3.9.8.25     Extras     2024-01-19 20:32:56
wps             12.1.0.15990 githcc     2024-01-19 20:23:26
xmind           12.0.3       githcc     2024-01-19 20:25:27
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
CONTAINER ID   IMAGE                    COMMAND                   CREATED       STATUS       PORTS                                                                                                                 NAMES
df439425ea36   xiaoyaliu/alist:latest   "/entrypoint.sh /opt…"   7 days ago    Up 4 days    0.0.0.0:5679->80/tcp, :::5679->80/tcp                                                                                 xiaoya_xiaohao
affc96fa823c   jdk8_u                   "java -jar demo.jar"      11 days ago   Up 11 days   0.0.0.0:7070->7070/tcp, :::7070->7070/tcp                                                                             jdk8_u
a10008e0ac40   ea552a450591             "/entrypoint.sh /opt…"   11 days ago   Up 4 days    0.0.0.0:5678->80/tcp, :::5678->80/tcp                                                                                 xiaoya_dahao
822137e74302   redis                    "docker-entrypoint.s…"   11 days ago   Up 11 days   0.0.0.0:6379->6379/tcp, :::6379->6379/tcp                                                                             redis
1c18eaa92159   lobehub/lobe-chat        "docker-entrypoint.s…"   2 weeks ago   Up 2 weeks   0.0.0.0:3210->3210/tcp, :::3210->3210/tcp                                                                             lobe-chat
b965bf27ef72   nginx:latest             "/docker-entrypoint.…"   2 weeks ago   Up 7 days    0.0.0.0:80->80/tcp, :::80->80/tcp, 0.0.0.0:443->443/tcp, :::443->443/tcp, 0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   nginx
945ac40694a8   mysql:5.7.22             "docker-entrypoint.s…"   2 weeks ago   Up 2 days    0.0.0.0:3306->3306/tcp, :::3306->3306/tcp                                                                             mysql
76418fd6c6ce   snowdreamtech/frps       "/bin/sh -c '/usr/bi…"   2 weeks ago   Up 2 weeks  
```
