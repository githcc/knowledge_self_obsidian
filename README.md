# knowledge_self
用于个人对知识的学习，总结，搭建一个pkm（个人知识管理）

## 整这么一个项目的原因
1. 这个是为个人服务的，建立知识之间的联系
2. 工具的成熟，具备了一定的条件，如gpt的诞生，笔记软件的完善。后面gpt的个人化，还能拿来喂gpt
3. 信息增长的速度更加的爆炸，各种收藏夹，书签，笔记软件存在大量的信息
4. 提高自己的效率，减少大脑负担
5. 现在对于信息的管控很严，存在着大量丢失的内容，有些是合理（绝大数人认为应该删除，如：个人隐私的外泄），后续考虑将软件进行本地化
6. 打造一个动态笔记，小小推动一下去中心化思想（顾及更多的文件，标签+双链）

## 本项目打开方式
1. 建议使用Obsidian打开，使用支持md的其它软件，无法使用双链与预览图片/视频
2. 建议使用win系统，使用非win系统，无法使用项目中的bat脚本

## 核心
高频(经常查找)>有利于思考（构建关联）>详细完整（数据离线）
1. 随着时间的迁移内容的不断增多，会很难做到完整和轻量
2. 大片段且使用频次少的内容可以使用gpt/搜索，不放到项目里
3. 有价值但长时间不用也要进行删除，后续有用到再通过gpt/搜索补充回来
4. 平时用词短些，选材少些，低效多删，对于双链，标签的创建也要克制

## 交互（为[[想法/km项目|km项目]]准备）
如果别人对我的内容有疑问，可以临时新建一个项目，提交issue到我这里，我标注一下，看到标注的人可以前往对方新建的项目进行讨论，一定时间后，根据讨论结果对我的内容进行补充或者加一个链接到一个新的md，不会大篇幅的添加内容，这会脱离这个项目的本意，十分完善的内容可以在[[想法/km项目.md|km项目]]进行整合，然后移除当前的标注，对方可以就提出的疑问进行总结，合并入自己的pkm，关闭提问的项目

## 是否存放编程相关内容
答案是肯定的，这个项目就是要成为一个外脑
1. 主打的就是一个完整和轻量，所以不放入完全吸收的内容
2. 慢慢地形成自己的方法论，弥补记性差带来的低效

## commit
1. 根目录新增的目录，讲一下该目录的作用
2. 新增xx的xx
3. 存在较大的失误，需要进行备注，分析一下产生的原因，后续如何避免
4. commit的频率控制在3-7次/周，文件如果要修改了，浏览一下整个文件，减少后续修改次数
5. commit要像呼吸一下（一吸：提交新内容，这其中含有杂质，一呼：修改错别字，用词，完善双链，标签），一周左右更新整个项目一次，也可以处理掉一些TODO，还能加强对整个项目的感觉

## 子目录预览
运行[[run.bat|脚本]]生成目录结构，生成二层文件树，用于预览整个项目

知库 知识的仓库，包含一些不经常变动且来自于共识的内容，如标签库，模板和概念等
想法
...