## 概念
CC攻击（Challenge Collapsar攻击）通常指的是对网络服务器或网站的“连接数”或“并发连接数”进行攻击的行为。CC代表“Challenge Collapsar”，这是攻击手法的一种形式。

CC攻击的目标是通过使目标系统同时处理大量的连接请求，使其资源耗尽，导致服务不可用或性能严重下降。攻击者通常利用大量的恶意程序、恶意脚本或恶意流量来模拟多个连接请求，超过目标系统的处理能力。

这种攻击有时也被称为“连接数攻击”或“并发连接攻击”，因为它的本质是通过制造大量虚假的连接请求来压倒目标系统的处理能力。这可能导致正常用户无法访问服务，因为服务器已经耗尽了处理连接的资源。

为了对抗CC攻击，网络管理员通常会采取一些防御策略，例如使用防火墙、入侵检测系统（IDS）、负载均衡器等来过滤和处理恶意流量，以确保正常用户能够正常访问服务。


## 参考资料
1. 腾讯云
   1. [linux nginx服务器安装verynginx防止CC攻击](https://cloud.tencent.com/developer/article/1050231)
   2. [nginx安装HttpGuard防止CC攻击](https://cloud.tencent.com/developer/article/1050232)
2. bilibili
   1. [博客遭D无法访问](https://www.bilibili.com/video/BV16v4y167Gk)