## 流程
1. 浏览器->dispatcherServlet->controller->model(1)->dispatcherServlet->view（2）->dispatcherServlet->浏览器
   1. 获取model，返回一个modelAndView
   2. 将model与模板进行结合

## springmvc对比三层架构
1. 三层架构
   1. 视图层 View
   2. 服务层 Service
   3. 持久层 DAO
2. Springmvc
   1. Springmvc相当于三层架构的前两层
   2. mvc
      1. Model 模型
         1. 数据承载 Bean
         2. 业务处理 Service DAO
      2. View 视图
      3. Controller 控制器

