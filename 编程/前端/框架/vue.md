## 优势
1. 一个渐进式框架，使用了虚拟dom，双向数据绑定，mvvm
   1. 合理使用的话，性能好，处理的处理都放在后端
   2. 自己写过一个页面，平时没啥感觉，拿到低配电脑上使用，卡爆了
2. 中文资料丰富，国内使用人比较多

## 安装
1. npm install -g cnpm --registry=https://registry.npm.taobao.org
2. cnpm install vue --save
3. cnpm install -g @vue/cli

## 创建项目
1. vue create vue-demo

## [指令](指令.md)
1. v-model  `v-model.lazy`关闭实时 `v-model.trim` 去空白符 
2. v-if v-else-if
3. v-show
4. v-for 使用时最好带上 `:key`
5. `v-on` `@`
6. `v-blind` `:`
7. v-html


## [父子组件交互](父子组件交互.md)
1. 父传子 使用props，当使用数组/对象要使用函数(vue2)
2. 子传父 使用$emit（选项式）


## 组件生命周期
组件生命周期有8个， 4个准备阶段（beforeXX）
1. 创建 create
2. 渲染 mounted，主要用于网络请求
3. 更新 updated
4. 卸载 unmounted

## 常见组件
1. [axios](axios.md)
   1. 跨域问题
2. [router](router.md)
    1. 路由传参
3. vuex
    1. [state](state.md) 读取共享数据 mapState
    2. [getters](getters.md) 共享数据预处理 mapGetters
    3. [mutations](mutations.md) 同步方法共享 mapMutations
    4. [action](action.md) 异步方法共享 mapAction

## vue3新特性
1. 性能强，无用的模块可以不打包
2. 可以使用组合式，setup，ref,reactive
3. 生命周期函数可以写多个
4. 更好的父传子交互  [provideAndInject](provideAndInject.md)
5. 对ts支持更好
6. 不限制template只有一个div

## 路由的两种模式
### 1. Hash 模式

Hash 模式使用 URL 中的 hash（#）来模拟一个完整的 URL，路由器会监听 URL 中的 hash 变化，并以此来进行路由匹配。

**特点：**
- URL 中带有 `#` 符号，例如：`http://example.com/#/about`
- 支持在不同浏览器之间进行路由导航，因为 hash 不会被发送到服务器端
- 可以避免一些服务端渲染的问题
- 在老一些的浏览器中是最稳定兼容的方式

### 2. History 模式

History 模式使用浏览器的 History API 来实现前端路由，它会使用真实的 URL 路径来进行导航，而不需要像 Hash 模式那样使用 `#` 符号。

**特点：**
- URL 更加美观，不带有 `#` 符号，例如：`http://example.com/about`
- 使用 HTML5 History API，可以使用 `history.pushState` 和 `history.replaceState` 来管理历史记录
- 需要后端服务器支持，以便正确处理路由，避免刷新页面时出现404错误
- 在一些较老的浏览器版本中，可能存在兼容性问题

## 相关资源
1. [官网](https://cn.vuejs.org/guide/introduction.html)
2. (第三方组件)[https://github.com/vuejs/awesome-vue]
3. (element plus)[https://element-plus.org/zh-CN/#/zh-CN]

## 其它
1. 安装nodejs也会安装npm
2. event对象，可以修改很多东西 如：event.target.innerHTML
3. js的数据类型有哪些 String Number Boolean Array Object Function

## 参考资料
1. bilibili：[2天学会Vue3](https://www.bilibili.com/video/BV1Cx4y1K7tk)
2. openai：[chatgpt](https://chat.openai.com/)