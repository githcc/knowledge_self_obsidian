## 简介
1. twitter的一种响应式框架

## 使用方式
1. npm/gem
2. link引入

## 网格系统
1. xs sm md lg
    ```
    <div class="container">
      <div class="row">
        <div class="col-lg-6">内容占据一半宽度</div>
        <div class="col-lg-6">内容占据一半宽度</div>
      </div>
    </div>
    ```
2. offset
    ```
    <div class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">内容占据一半宽度，向右偏移3列</div>
      </div>
    </div>
    ```

## 其它组件
1. 表单
2. 表格
3. 导航
4. 字体图标
5. 面包屑
6. 进度条
7. 列表
8. 轮播图
9. 模态框

## bootstrap有什么组件（chatgpt）
    ```
    Bootstrap 提供了大量的组件，包括但不限于：
    
    导航栏（Navbars）：用于创建响应式的导航栏，包括下拉菜单和响应式行为。
    
    按钮（Buttons）：用于创建不同样式和尺寸的按钮，包括按钮组和按钮工具栏。
    
    表单（Forms）：包含各种表单元素和布局样式，可以帮助用户轻松创建表单。
    
    模态框（Modals）：用于创建模态框，可以在页面上显示额外的交互内容。
    
    标签页（Tabs）：用于创建标签页结构，可以切换不同的内容面板。
    
    警告框（Alerts）：用于创建不同样式和类型的警告框，用于显示提示消息或警告信息。
    
    标签（Badges）：用于显示不同样式和尺寸的徽章，通常用于显示数量或状态信息。
    
    进度条（Progress）：用于显示进度条，可以显示任务完成的进度。
    
    图标（Icons）：包含了一系列图标，可用于增强页面的可视化效果。
    
    除此之外，Bootstrap 还提供了很多其他组件，如卡片（Cards）、轮播图（Carousels）等，这些组件都可以帮助用户快速构建出美观、响应式的界面。
    ```

## 媒体查询，并非bootstrap带来的
    ```
    .head_nav2 {
        display: none;
    }
    @media screen and (min-width: 800px) {
        .head_nav2 {
            display: block;
        }
    }
    ```

## 参考资料
1. 官网:
   1. [bootstrap](https://getbootstrap.com/)
2. bilibili:
   1. [Bootstrap5框架】常用组件](https://www.bilibili.com/video/BV1fD4y1h7UG)