## 坑
1. 不能命名为xXXX这类的命名，这样命名生成其中的方法命名不符合预期，会导致赋值错误
2. 之前使用postman复现了，最近使用idea自带的请求方式无法复现
3. 现在不想装postman，太重了，要时常记录

## 常见注解

| 注解                  | 方法                                       | 注意事项                     |
|---------------------|------------------------------------------|--------------------------|
| @Data               | set，get，equal，hashCode，toString          |                          |
| @Getter             | get                                      |                          |
| @Setter             | set                                      |                          |
| @ToString           | toString                                 |                          |
| @AllArgsConstructor | 全参构造                                     |                          |
| @NoArgsConstructor  | 无参构造                                     |                          |
| @Accessors          | set方法开启链式调用                              | chain为true开启             |
| @slf4j              | 生成一个log变量可以用于打印日志                        | 无法单独使用，在springboot项目可以使用 |
|                     | LoggerFactory.getLogger(this.getClass()) |                          |

## 参考资料
1. bilibili:[我为什么不喜欢lombok](https://www.bilibili.com/video/BV1nh4y1K7mf)