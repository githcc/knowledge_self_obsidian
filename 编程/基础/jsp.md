## servlet

1. **Servlet生命周期：** 理解Servlet的生命周期，包括初始化、服务处理请求和销毁阶段。了解`init()`、`service()`、`destroy()`等方法的作用及调用时机。

2. **HttpServletRequest 和 HttpServletResponse：** 熟悉HttpServletRequest对象和HttpServletResponse对象的方法和属性，用于处理来自客户端的请求和生成响应。

3. **Servlet容器和部署：** 了解Servlet容器（比如Tomcat、Jetty）的概念和工作原理，掌握如何在容器中部署和配置Servlet应用。

4. **URL映射和参数处理：** 理解URL映射的原理，掌握如何从URL中获取参数，处理请求并生成动态内容。

5. **会话管理和Cookie：** 熟悉会话管理的概念，了解如何使用Cookie或Session对象来管理用户会话状态。

6. **异常处理和错误页面：** 掌握如何捕获异常并正确处理，了解如何配置错误页面以提供友好的错误信息给用户。

7. **过滤器和监听器：** 了解过滤器（Filter）和监听器（Listener）的作用，掌握如何使用它们对请求和响应进行过滤和监听。

8. **线程安全和并发处理：** 理解Servlet的线程模型，了解如何编写线程安全的Servlet以处理并发请求。

9. **Servlet API：** 熟悉Servlet API中提供的各种类、接口和方法，如Servlet、ServletRequest、ServletResponse等，掌握其用法和功能。

10. **Web应用程序的开发：** 理解Servlet在Web应用程序开发中的角色，能够结合其他技术（如JSP、数据库访问等）构建完整的Web应用。

掌握以上概念和技能能够帮助Java程序员有效地开发和管理Servlet应用，构建稳健、高效的Web应用程序。


## filter

1. **Filter的作用和原理：** 理解Filter的作用，它可以拦截Web应用程序中的请求和响应，并在执行Servlet之前或之后进行处理。掌握Filter链的概念，即多个Filter按照顺序依次执行。

2. **Filter的生命周期：** 熟悉Filter的生命周期方法，包括`init()`、`doFilter()`、`destroy()`，了解它们在Filter生命周期中的作用和调用时机。

3. **Filter的配置和部署：** 掌握如何在Web应用程序的部署描述符（web.xml）中配置Filter，以及如何通过注解（使用Servlet 3.0+）进行配置。了解Filter的映射和执行顺序的设置。

4. **HttpServletRequest 和 HttpServletResponse 的使用：** 熟悉HttpServletRequest和HttpServletResponse对象的方法和属性，Filter可以通过这些对象来操作请求和响应。

5. **过滤器链（Filter Chain）的处理：** 理解如何在Filter中使用Filter Chain来控制请求和响应的流程。了解如何在Filter中放行请求，继续执行后续的Filter或Servlet。

6. **过滤器的应用场景：** 了解Filter的常见应用场景，比如身份验证、日志记录、字符编码转换、资源访问控制等。

7. **异常处理和错误处理：** 掌握如何在Filter中捕获异常并进行适当处理，以及如何重定向到错误页面或返回特定的错误响应。

8. **与Servlet的结合使用：** 了解如何将Filter与Servlet结合使用，实现对请求和响应的预处理和后处理，增强Web应用程序的功能和灵活性。

掌握这些方面可以使Java程序员更好地利用Filter来处理Web应用程序中的请求和响应，实现更好的控制和管理。


## listener

1. **Listener的类型：** Java程序员需要了解Servlet规范中定义的不同类型的Listener，包括ServletContextListener、ServletRequestListener、HttpSessionListener等。

2. **Listener的作用：** 了解Listener的作用，它可以监听Web应用程序中的各种事件，如ServletContext的创建和销毁、ServletRequest的创建和销毁、HttpSession的创建和销毁等。

3. **Listener的生命周期：** 理解Listener的生命周期方法，包括`contextInitialized()`、`contextDestroyed()`等，以及它们在Listener生命周期中的作用和调用时机。

4. **监听的事件和处理方式：** 熟悉不同类型Listener监听的事件，比如ServletContextListener监听Web应用程序的启动和关闭事件，ServletRequestListener监听ServletRequest的创建和销毁等。了解如何在Listener中编写相应的处理逻辑。

5. **Listener的配置和部署：** 掌握如何在Web应用程序的部署描述符（web.xml）中配置Listener，也可以通过注解（使用Servlet 3.0+）进行配置。

6. **与Servlet和其他组件的结合使用：** 了解如何将Listener与Servlet、Filter等组件结合使用，实现对事件的监听和处理，比如在ServletContext初始化时加载资源、在HttpSession创建时进行一些操作等。

7. **应用场景和实际用途：** 了解Listener的常见应用场景，比如在应用程序启动时进行初始化、处理全局配置、管理资源等。

掌握Listener可以帮助Java程序员更好地实现对Web应用程序中事件的监听和处理，实现更灵活、高效的应用程序开发。


## jsp九大内置对象
1. **request**：`javax.servlet.http.HttpServletRequest`的实例，用于获取客户端的请求信息。

2. **response**：`javax.servlet.http.HttpServletResponse`的实例，用于向客户端发送响应。

3. **session**：`javax.servlet.http.HttpSession`的实例，用于跟踪用户的会话信息。

4. **out**：`javax.servlet.jsp.JspWriter`的实例，用于向页面输出内容。

5. **application**：`javax.servlet.ServletContext`的实例，代表整个Web应用程序的上下文信息。

6. **config**：`javax.servlet.ServletConfig`的实例，代表当前JSP的配置信息。

7. **page**：当前JSP页面本身的一个实例。

8. **pageContext**：`javax.servlet.jsp.PageContext`的实例，提供对页面的其他8个隐含对象的访问。

9. **exception**：`java.lang.Exception`的实例，代表发生在JSP页面处理期间的异常信息（仅当页面发生异常时才可用）。

这些内置对象可以让开发者更方便地获取请求信息、操作会话、发送响应以及处理异常等。在JSP页面中，这些对象可以直接使用而无需额外的初始化或配置。

## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)