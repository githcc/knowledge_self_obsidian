## 安装说明

1. 适用于 NAS、iStoreOS、macOS、PC 等集成 Docker 的硬件。
2. 本文以群晖 DSM7.2 演示。
3. 尽量安装完整地流程，不遗漏步骤，一处细节可能都会引起错误。
4. 在纯净的网络操作。
5. 部分操作我会附上一些UP主的视频教程。
6. Plex 不支持 .strm 文件，所以可以搜刮但是不能播放。
7. 手动安装操作比较复杂，新手建议用一键脚本，出问题了再逐一处理。高手随意。
8. 部分问题我会在评论区处理或者更新文章，大家可踊跃发言。

## 必要的程序

1. 群晖安装「文本编辑器」套件。群晖：套件中心 > 所有套件>文本编辑器。
2. SSH 客户端软件。例如：Putty、Git、Mac的终端 等。
3. WinSCP可查看群晖root目录文件，配合ssh使用。
4. NAS 打开 SSH。群晖： 控制面板 > 终端机和 SNMP > 启动 SSH 功能 > 应用 。
5. 阿里网盘客户端，下载元数据使用。

## 大致流程

![img](https://pic3.zhimg.com/80/v2-3120348427f794bb7dcdfd02d3df2bbe_720w.webp)

------

## 一、部署 xiaoya

[2023年NAS挂载小雅Alist,瞬间拥有千T资源,告别片荒_哔哩哔哩_bilibiliwww.bilibili.com/video/BV1pN4y1U7kk/?spm_id_from=333.999.0.0![img](https://pic1.zhimg.com/v2-4307ee499d53fcaa665d6051641a393c_ipico.jpg)](https://www.bilibili.com/video/BV1pN4y1U7kk/?spm_id_from=333.999.0.0)

### 1、新建 xiaoya 文件夹

在群晖 docker 下新建 xiaoya 文件夹 （添加everyone读写权限）

> /volume1/docker/xiaoya

### 2、获取 阿里云盘 token 3个文件

| 文件名                      | 获取数据地址                                          | 备注                             |
| --------------------------- | ----------------------------------------------------- | -------------------------------- |
| mytoken.txt                 | https://alist.nn.ci/zh/guide/drivers/aliyundrive.html |                                  |
| myopentoken.txt             | https://alist.nn.ci/tool/aliyundrive/request          |                                  |
| temp_transfer_folder_id.txt | https://www.aliyundrive.com/drive                     | 网盘文件夹不可删除，只需获取一次 |

temp_transfer_folder_id 登陆阿里云盘 > 在资源盘下新建文件夹（xiaoya）

点击进入后复制阿里云盘转存目录folder id填入 **temp_transfer_folder_id.txt**

![img](https://pic1.zhimg.com/80/v2-ee1b7807a67c584ae0de1a6a906f760c_720w.webp)

### 3、上传 Token 文件

将获取的密钥填入新建文本 mytoken.txt、myopentoken.txt、temp_transfer_folder_id.txt，上传至 群晖 docker/xiaoya 文件夹中。

SSH 获取 root 权限

```text
login as：群晖用户名
ssh 群晖IP
输入密码，密码不显示
sudo -i
再次输入密码，密码不显示
```

![img](https://pic2.zhimg.com/80/v2-7f955bdf9b9a1081a365fa41f1da06b9_720w.webp)

### 4.1 、一键安装

> 如果只需要安装tvbox-xiaoya的直接跳到 步骤五

纯净版小雅：

```bash
docker run -d --restart=always --name="xiaoya"-p 5678:80-p 2345:2345-p 2346:2346-v /volume1/docker/xiaoya:/data xiaoyaliu/alist:latest
```

用于日后更新

```bash
bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)"
```

### **5**、登入小雅

查看容器是否创建。

![img](https://pic2.zhimg.com/80/v2-0c37c9f7d7321e55bfcd05abf9a3e995_720w.webp)

浏览器打开 http://群晖ip:5678/。

![img](https://pic2.zhimg.com/80/v2-f0b5906ada10412c240d817a239d3191_720w.webp)

加载中，有页面算完成一半

等5分钟左右 刷新浏览器 验证是否挂载成功。

![img](https://pic3.zhimg.com/80/v2-f806f2e6177594199b243da4a4c4528a_720w.webp)

完成挂载

### **6、检测配置是否正常。**

xiaoya > 元数据 > 随意打开一个.mp4文件查看是否能够播放。

> 无法播放，请回到 步骤2 重新配置 阿里网盘Token 并 重启xiaoya 容器。

![img](https://pic1.zhimg.com/80/v2-ff8ef095384c72e907b6e9beee46f94c_720w.webp)

播放正常

### **7、实时清理阿里云盘缓存和日常更新。**

> 每天会自动清除缓存在自己阿里云下小雅缓存

1、安装 xiaoyaleep ，输入SSH命令

```bash
bash -c "$(curl -s https://xiaoyahelper.zngle.cf/aliyun_clear.sh | tail -n +2)" -s 3
```

![img](https://pic2.zhimg.com/80/v2-7b432c778137994595e1b88034ff38f1_720w.webp)

2、更新小雅内容

请日常 重启 xiaoya 即可。

------

## 二、获取元数据

> 注意事项：
> 1、获取元数据前再次确认 [httP://小雅链接](http://xn--yet89o208b8qb/) ，**元数据** 列表 里的 .mp4 文件可以正常播放。
> 2、元数据内容大概有60G，和解压内容60G+,官方建议确保有160G空间。
> 3、获取元数据根据配置下载和解压速度时间较长（约1-5小时）
> 4、有阿里云盘会员可以加速下载。

### 1、Xiaoya 添加 EMBY、Jellyfin 配置文件

添加 docker_address.txt、emby_sever.txt文件，上传到群晖 docker/xiaoya 中。

| 文件名             | 填写内容                                       | 备注                                                         |
| ------------------ | ---------------------------------------------- | ------------------------------------------------------------ |
| docker_address.txt | [http://192.168](http://192.0.0.168/).*.*:5678 | xiaoya地址                                                   |
| emby_sever.txt     | [http://192.168](http://192.0.0.168/).*.*:8096 | emby地址。 安装 emby 过程有时会被替换成 [http://127.0](http://127.0.0.0/).*:2345 导致2345端口无法进入。 |

![img](https://pic1.zhimg.com/80/v2-c3a120387651cc17dc865e67429a7fdc_720w.webp)

### **2、获取 Xiaoya 元数据**

2.1 在 /docker/xiaoya/ 新建 media 文件夹。

![img](https://pic1.zhimg.com/80/v2-64672043d1f73b6825dc420f9b6dff4c_720w.webp)

新建media文件夹

2.2 media 文件夹 添加 everyone 读写权限。
右键2属性 > 3权限 > 3高级选项 > 3使继承权限显式化 > 4Everyone > 3编辑 > 5权限全部打钩 > 6完成

![img](https://pic1.zhimg.com/80/v2-9ef2d1a76790de18f81e02b8f848f044_720w.webp)

### #元数据直链问题：

> 确保小雅媒体库目录下的 .strm 文件链接是指向小雅的链接而不是 DOCKER_ADDRESS。

1、打开任意的strm文件。

```text
/volume1/docker/xiaoya/media/xiaoya/综艺/韩国综艺/魔鬼的计划/S01E04_【tvzongheba】E04.strm
```

![img](https://pic3.zhimg.com/80/v2-138279d555aa4ce524f2cef829be460a_720w.webp)

错误的显示

### 修改媒体库链接指向小雅。

ssh输入命令

```text
#配置命令：
find /小雅元数据所在目录 -type f -name '*.strm' -exec sed -i 's#DOCKER_ADDRESS#http://小雅IP地址:小雅端口#g' {} +
#示例（我的群晖）：
find /volume1/docker/xiaoya/media/xiaoya -type f -name '*.strm' -exec sed -i 's#DOCKER_ADDRESS#http://192.168.50.229:5678#g' {} +
```

### 3.1 **方法：一键获取完整小雅 元数据 + EMBY。**

> **四种方法任选其一即可。**

**直接跳到步骤：**【三、部署 EMBY】

### 3.2 **方法：一键获取完整小雅 元数据 + Jellyfin。**

**直接跳到步骤：**【四、部署 Jellyfin】

\-------------------------------------------------------------

### **3.3 方法：单独获取 部分小雅 元数据**。

1、只获取小雅超集的元数据，用自己的emby，用下面的一键安装命令：

```bash
bash -c "$(curl http://docker.xiaoya.pro/update_metainfo.sh)" -s /媒体库目录   /小雅配置文件所在目录
```

> 复制之前要把“/媒体库目录”替换成自己存放小雅元数据的正确路径

示例（按我创建的元数据）：

```bash
bash -c "$(curl http://docker.xiaoya.pro/update_metainfo.sh)" -s /volume1/docker/xiaoya/media   /volume1/docker/xiaoya
```

### 3.4 手动获取小雅元数（自定义下载）

单独要下载的 小雅主页/元数据 .mp4 的元数据。比如主要的电影和电视剧。完整需要全部下载。

> 好处就是同时下载，同时上传可以节省大量的时间。

![img](https://pic3.zhimg.com/80/v2-16db0b375f71f47b35c7962d1597199e_720w.webp)

![img](https://pic4.zhimg.com/80/v2-b860273a286e68b830505ab81615b667_720w.webp)

> 观看一次文件，阿里云客户端就可以直接下载。速度应该会更快。我这里是差不多。

上传至 媒体库目录/xiaoya，我这里是 /volume1/docker/xiaoya/media/temp

### 4 小雅媒体库目录文件说明

| 文件名 | 说明                       |
| ------ | -------------------------- |
| xiaoya | 存放影片数据的目录。约60G  |
| temp   | 存放 .mp4 数据压缩包的目录 |
| config | docker 的 emby 的配置目录  |

> 高手可以灵活操作

3.4.1 运行 步骤三-五 的一键安装命令

### 5、同步小雅媒体库。

目前微力同步功能还不完善，所以暂时不更新了。参考b站的视频即可。

[首发：小雅每日更新同步来了！还能定时同步哦！_哔哩哔哩_bilibiliwww.bilibili.com/video/BV1Sw411G7cy/?spm_id_from=333.337.search-card.all.click&vd_source=7dfec521e52ebfca5e2f7efcbf7ada4a![img](https://pic4.zhimg.com/v2-f76e0b3cbbfddd23edba719302cd0d07_ipico.jpg)](https://www.bilibili.com/video/BV1Sw411G7cy/?spm_id_from=333.337.search-card.all.click&vd_source=7dfec521e52ebfca5e2f7efcbf7ada4a)

------

## 三、部署 EMBY

[2023最新小雅Emby全家桶一键安装,解决封面和搜索,玩转千T资源_哔哩哔哩_bilibiliwww.bilibili.com/video/BV1RN4y1U7aK/?spm_id_from=333.999.0.0![img](https://pic2.zhimg.com/v2-88004da441403979f4cb9cdbb04a0381_ipico.jpg)](https://www.bilibili.com/video/BV1RN4y1U7aK/?spm_id_from=333.999.0.0)

### **硬件加速**

> 查询自己的硬件是否支持硬件加速

进入 容器 SSH

```text
docker exec -it emby /bin/sh
ls /dev/dri
card0 renderD128  #表示已支持硬件加速
```

![img](https://pic2.zhimg.com/80/v2-f99d9d5c37918e89946c79abbfb59de5_720w.webp)



### 1、一键安装 元数据+EMBY

**使用EMBY官方容器命令（无法调用核显硬解）**

```bash
bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh)" -s /volume1/docker/xiaoya/media /volume1/docker/xiaoya
```

**小雅元数据 + 开心版第三方Emby（可以调用核显硬解）**

```bash
bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh | sed 's#emby/embyserver#amilys/embyserver#')" -s /媒体库目录 /配置文件目录
```

> **调用核显需要高级权限，在群晖container manager找到emby容器,停用后打开“使用高级权限”选项。**
> **查看步骤3**

示例（我的配置）：

```bash
bash -c "$(curl http://docker.xiaoya.pro/emby_plus.sh | sed 's#emby/embyserver#amilys/embyserver#')" -s /volume1/docker/xiaoya/media /volume1/docker/xiaoya
```

### **2、单独安装 Docker 版 EMBY**

> 适用于已近配置好元数据的用户

2.1 docker目录下创建 emby 文件夹。

![img](https://pic4.zhimg.com/80/v2-60046c75bcd3685e203175925931c83b_720w.webp)

2.2 执行一键命令 适用于 x86_64、amd64 架构的 SSH命令

```go
docker pull emby/embyserver:4.8.0.56
docker run -d --name emby -v /volume1/docker/emby:/config -v /volume1/docker/xiaoya/media/xiaoya:/media --net=host --user 0:0 --restart always emby/embyserver:4.8.0.56
```

### 3、开启权限

> 按照 步骤四、2 设置

### 4、进入 EMBY

登陆emby：http://群晖IP:2345

> 用户名：xiaoya
> 密码：1234



> 使用 官方 emby 推荐使用 2345端口号，用**客户端**进行硬解
> 使用 第三方emby 2345、8096 端口

## 四、部署 Jellyfin

[姐夫也爱小雅：群晖Jellyfin一键安装小雅超集2023全网首发_哔哩哔哩_bilibiliwww.bilibili.com/video/BV1Rb4y1L7Vq/?spm_id_from=333.999.0.0&vd_source=7dfec521e52ebfca5e2f7efcbf7ada4a![img](https://pic2.zhimg.com/v2-726c7b985401d539771cd308cd292445_ipico.jpg)](https://www.bilibili.com/video/BV1Rb4y1L7Vq/?spm_id_from=333.999.0.0&vd_source=7dfec521e52ebfca5e2f7efcbf7ada4a)

### 1、推荐安装 nyanmisaka/jellyfin

打开群晖/unraid命令行窗口，输入以下命令拉取镜像：

```go
docker pull nyanmisaka/jellyfin
docker run -d --name jellyfin -v /volume1/docker/Jellyfin:/config -v /volume1/docker/xiaoya/media/xiaoya:/media --net=host --user 0:0 --restart always nyanmisaka/jellyfin:latest
```

### 2、容器配置。

2.1 打开 Container Manager > 容器 > jellyfin > 停止

硬解需要：设置 > 容器，功能打开 使用高级权限执行容器。

环境查看是否PUID = 0、PGID = 0

![img](https://pic3.zhimg.com/80/v2-11efc689ba776a7d93ad53161478b77e_720w.webp)

### 3、导入小雅emby 相同媒体库

> 也可跳过，直接手动添加

3.1 下载 媒体库文件：链接: https://pan.baidu.com/s/1zQSfu5eUggKQGU_ra_6LtA?pwd=root

3.2 导入 Jellyfin 媒体库解压

![img](https://pic1.zhimg.com/80/v2-509dedbc0bb6bdb10f5934c905dd7b70_720w.webp)

3.3 刷新媒体库。移动至 步骤 四、8

### 4、开启容器，设置首次加载。

等一会，如果没搜索的服务器请等5分钟，就能进入欢迎界面。

![img](https://pic1.zhimg.com/80/v2-57aa0c1ffb3cc754de8238cf17566a40_720w.webp)

设置语言

![img](https://pic3.zhimg.com/80/v2-b47108933a7615236562233e4e90974e_720w.webp)

设置用户名

![img](https://pic2.zhimg.com/80/v2-7a69b1e9d893a832bc2cab52f1c696b9_720w.webp)

跳过

![img](https://pic3.zhimg.com/80/v2-e0ef1660045b414ef0a62a1a5f02ac6a_720w.webp)

![img](https://pic4.zhimg.com/80/v2-e70b1717cced6a71623290920e45d8bf_720w.webp)

![img](https://pic1.zhimg.com/80/v2-eb64478ee47784bbc108b3b1b993c834_720w.webp)

### 5、进入首页

![img](https://pic4.zhimg.com/80/v2-6b5fbb728a68600f15240931f541c7f3_720w.webp)

![img](https://pic4.zhimg.com/80/v2-4f43e35e34b3a74756a549a6c5ad99d7_720w.webp)

![img](https://pic3.zhimg.com/80/v2-efea6652c8699e9b5587fa74e57f880a_720w.webp)

### 6、「添加媒体库」配置

![img](https://pic4.zhimg.com/80/v2-04eeab4b9f26dfe567691c9c2ea9af4b_720w.webp)

![img](https://pic3.zhimg.com/80/v2-8a529891960c66d9c931b0a4b65740c6_720w.webp)

![img](https://pic1.zhimg.com/80/v2-83f91af016d3b9ffffd9ebaf18196c00_720w.webp)

![img](https://pic2.zhimg.com/80/v2-0a4189f2bf897013be4460086d715611_720w.webp)

### 7、硬件加速设置

![img](https://pic1.zhimg.com/80/v2-510e9f84fef8882337461ed9922b62b4_720w.webp)

![img](https://pic1.zhimg.com/80/v2-54a1a8b7aa3db91123ab6078c57e5da8_720w.webp)

![img](https://pic1.zhimg.com/80/v2-053afd018b4fca3e3ed0add47b6cac60_720w.webp)

### 8、导入的 emby媒体库

8.1 第一次可点击 扫描所有媒体库

![img](https://pic2.zhimg.com/80/v2-b5dba944ff781d0e6cea21f47e5b8b8d_720w.webp)

8.2 之后的逐一刷新

![img](https://pic2.zhimg.com/80/v2-0cb84616af286bdfde3427eb123fac11_720w.webp)

## 五、部署 TvBox

[支持tvbox苹果tvOS播放器Vidplay上手-alist tvbox小雅集成版教程-修改版_哔哩哔哩_bilibiliwww.bilibili.com/video/BV1oC4y1S7qS/?spm_id_from=333.337.search-card.all.click&vd_source=7dfec521e52ebfca5e2f7efcbf7ada4a![img](https://pic1.zhimg.com/v2-ed94de939a11c46ef1d80b8926bda6cc_ipico.jpg)](https://www.bilibili.com/video/BV1oC4y1S7qS/?spm_id_from=333.337.search-card.all.click&vd_source=7dfec521e52ebfca5e2f7efcbf7ada4a)

### 1、创建文件夹

完成目录「一、1 」到「一、3」的过程。

> 之前已配置好目录和安装过小雅的可以跳过。

### 2.1、一键部署命令

```bash
#一键部署(附带小雅)
sudo bash -c "$(curl -fsSL https://d.har01d.cn/update_xiaoya.sh)"
#一键部署，已经安装过小雅的用这个
sudo bash -c "$(curl -fsSL https://d.har01d.cn/update_xiaoya.sh)" -s /volume2/docker/xiaoya
```

### 2.2、群晖界面部署

拉取镜像

![img](https://pic3.zhimg.com/80/v2-d01fff44766a59e6026ddc47d0791e7a_720w.webp)

运行镜像

![img](https://pic2.zhimg.com/80/v2-ddbeae4b8342225b71ecc905a25aba51_720w.webp)

配置端口和存储位置

![img](https://pic1.zhimg.com/80/v2-febb3306fd11f181d3622967f438809c_720w.webp)

![img](https://pic2.zhimg.com/80/v2-14be64a85a3f7fc307cd3dc274cc8909_720w.webp)

完成配置

### 3、配置tvbox

```text
登入 http://群晖IP:4567
初始账户
用户名：admin
密码：admin
```

### 4、安装过小雅前往主页配置

将丫仙女改为xiaoya，URL指向xiaoya链接，集成版略过。

![img](https://pic3.zhimg.com/80/v2-39533d8f1ec427eaff2fdb155951c89e_720w.webp)

### 4、手动配置阿里网盘

![img](https://pic3.zhimg.com/80/v2-4a000bc2125798f1375f1c14c3eb72ce_720w.webp)

```text
Viplay配置地址
http://群晖IP:4567/vod1

tvbox配置地址
http://群晖IP:4567/sub/0
```

## 相关参考/问题

### 官方

[小雅的分类 Alist](https://alist.xiaoya.pro/)

官方文档：https://xiaoyaliu.notion.site/xiaoya-docker-69404af849504fa5bcf9f2dd5ecaa75f

**一键xiaoya安装和更新容器，标准模式，打开端口 5678**

```bash
bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)"
```

**一键**xiaoya**安装**和**更新容器，**host模式（推荐，软路由和NAS上更少网络故障，打开端口 6789）

```bash
bash -c "$(curl http://docker.xiaoya.pro/update_new.sh)" -s host
```

### 客户端适配说明

| App              | iOS、iPadOS、tvOS、MacOS               | PC      | Android TV    | Android   | WEB端       |
| ---------------- | -------------------------------------- | ------- | ------------- | --------- | ----------- |
| TvBox（推荐）    |                                        | √虚拟机 | √             | √         |             |
| VidPlay（TvBox） | √（推荐）                              |         |               |           |             |
| Jellyfin         | √                                      | √       | √             | √         | √（不推荐） |
| EMBY             | √（付费）                              | √       | √（第三方PJ） | √（官方） | √（不推荐） |
| Infuse           | √（扫库比较慢，但推荐配合vidplay使用） |         |               |           |             |
| DivHub           | √                                      |         |               |           |             |

### 2345端口打不开

> 按以下步骤排障：（不要跳跃，老老实实一步一步走）

1. 确保xiaoya 升级到了 1031 版本，同时如果是自己手动配置的容器，那么记得要加上2345、2346这2个端口映射。
2. 先确保 xiaoya 正常运行，去 xiaoya 网页的 /元数据 目录点击一个MP4文件，看看是否正常，这个是所有后续的前提。
3. 确保 docker_address.txt 配置正确，指向xiaoya的地址
4. 如果自己已经安装了emby，请停止运行，修改端口，避免和8096冲突，自己的emby可以修改为8097，不然会因为端口冲突导致安装失败
5. 执行一键安装全家桶命令
6. 安装好后，重启xiaoya一次
7. 通过 xiaoya的2345端口去连接，尽量用客户端或者三方播放器，不要用网页，因为浏览器解码能力弱，容易出现“不兼容的流”之类错误

### 群晖的套件安装的问题

使用群晖套件中心安装的Emby Series 和 Jellyfin 媒体服务器，配置文件会安装在默认目录。操作会比较复杂。
用 WinSCP 或 ls命令 中查看安装的套件路径 /volume1/@appstore 。
配置文件夹需开启 777 权限。