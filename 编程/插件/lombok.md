## 坑
1. 不能命名为xXXX这类的命名，这样命名生成其中的方法命名不符合预期，会导致赋值错误
2. 之前使用postman复现了，最近使用idea自带的请求方式无法复现
3. 现在不想装postman，太重了，lombok可能是自己处理了bug

## 常见注解
| 注解     | 方法                                     | 注意事项                                                    |
| -------- | ---------------------------------------- | ----------------------------------------------------------- |
| @Data    | set，get，equal，hashCode，toString      |                                                             |
| @equals  |                                          | callSuper 是否调用父类的equals方法。默认为false，表示不调用 |
| @slf4j   | 生成一个log变量可以用于打印日志          | 无法单独使用，在springboot项目可以使用                      |
|          | LoggerFactory.getLogger(this.getClass()) |                                                             |
| @Builder | builder()                                |                                                             |

## 参考资料
1. bilibili:[我为什么不喜欢lombok](https://www.bilibili.com/video/BV1nh4y1K7mf)