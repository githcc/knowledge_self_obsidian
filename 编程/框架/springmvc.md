## 流程
1. 浏览器->dispatcherServlet->controller->model(1)->dispatcherServlet->view（2）->dispatcherServlet->浏览器
   1. 获取model，返回一个modelAndView
   2. 将model与模板进行结合