## 开发一个idea插件
1. jdk11 gradle8.0.2
2. 初步了解idea插件开发流程
    1. 安装插件 devkit
    2. runIde
    3. buildPlugin
3. 细致了解一下如何开发
    1. 整一个对话框
    2. 开发文档，进行初略阅读
    3. find action
    4. wrapper 用项目目录指定的版本
    5. IC社区版 IU旗舰版
4. 编写一个diea插件demo，打包成一个zip
5. 调用一次gpt请求
6. 完善界面，出第一版

## components组件-触发时间
1. ApplicationComponent 整个IDEA只有一个实例
2. ProjectComponent Project级别
3. ModuleComponent Module级别

## 事件分类-触发内容
1. DialogWrapper 对话框
2. Jpanel 面板(相当于div)
   1. createCenterPanel
   2. createSouthPanel
3. JLabel 文本
4. swing ui

## 使用第三方jar-发起http请求
1. restTemplate

## 获取编辑器文本
1. Editor->model->selectedText

## 页面的布局-菜单放的位置
1. EditorPopupMenu 编辑器

## 浏览idea插件模板
1. Action Basics 添加菜单，已经点击菜单发生的事件
2. Comparing References Inspection 检测语法
3. Settings 添加一个设置面板

## 布局
1. FlowLayout(流式布局)
2. BorderLayout(边界布局)
3. GridLayout(网格布局)
4. CardLayout(卡片布局)
5. GridBagLayout(网格包布局)
6. BoxLayout(箱式布局)
7. SprigLayout(弹簧布局)

## 设计好插件的界面
1. 设置页面
   1. 设置代理地址和key
   2. 设置最大长度
   3. 自定义提示词
   4. 设置是否共享提示词，是否共享对话内容
   5. 提示词模式，允许一步到位
2. 对话页面
   1. 导出对话记录
3. 提示词广场
   1. 查看别人提示词
   2. 查看别人对话
   3. 允许点赞或踩
4. 打赏页面

## 插件介绍
1. 插件描述
2. 版本变化笔记
3. 包名
4. email url

## 参考资料
1. bilibili
   1. [IDEA插件开发](https://www.bilibili.com/video/BV1Zi4y1b7fw)