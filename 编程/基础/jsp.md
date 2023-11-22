## servlet
### servlet的使用
1. 实现servlet接口
2. 继承servlet的子类
3. 配置web.xml

### servlet的生命周期
1. `init()` 浏览器第一次访问就调用
2. `service()`
3. `destroy()`

### 其它 #标题/TODO
1. servlet 是线程不安全的，使用成员变量不要公用
2. servlet 的init 启动就执行？
3. servlet 是单例，load-on-startup

## filter
### filter的生命周期
1. `init()` 容器启动就立即调用
2. `doFilter()`
3. `destroy()`

### filter的作用
1. 身份验证
2. 日志记录
3. 字符编码转换
4. 资源访问控制等

### 其它
1. filterConfig可以设置初始化参数
2. filter的五种使用方式
   1. REQUEST 默认
   2. ERROR 错误
   3. FORWARD 重定向
   4. ASYNC 异步

## listener
### listener种类
监听器
ServletContextListener
HttpSessionListener
ServletRequestListener
方法有创建与销毁

ServletContextAttributeListener
HttpSessionAttributeListener
ServletRequestAttributeListener
attribute add/remove/replace

HttpSessionBindingListener
bound/unBound
HttpSessionActivationListener
willPassivate/DidActivate

###监听器生命周期
1. contextInitialized()
2. contextDestroyed()

### listener的使用
1. 实现对应接口
2. 编写对应代码
3. 我也不知道有啥用


## jsp九大内置对象
1. **request**：`javax.servlet.http.HttpServletRequest`的实例，用于获取客户端的请求信息。

2. **response**：`javax.servlet.http.HttpServletResponse`的实例，用于向客户端发送响应。

3. **session**：`javax.servlet.http.HttpSession`的实例，用于跟踪用户的会话信息。

4. **out**：`javax.servlet.jsp.JspWriter`的实例，用于向页面输出内容。

5. **application**：`javax.servlet.ServletContext`的实例，代表整个Web应用程序的上下文信息。

6. **config**：`javax.servlet.ServletConfig`的实例，代表当前JSP的配置信息。

7. **page**：当前JSP页面本身的一个实例。

8. **exception**：`java.lang.Exception`的实例，代表发生在JSP页面处理期间的异常信息（仅当页面发生异常时才可用）。

这些内置对象可以让开发者更方便地获取请求信息、操作会话、发送响应以及处理异常等。在JSP页面中，这些对象可以直接使用而无需额外的初始化或配置。

## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)