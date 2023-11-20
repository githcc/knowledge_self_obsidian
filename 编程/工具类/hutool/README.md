## 选择
1. 打包给别人用到就不使用hutool
2. 看公司的接受程度
3. 其余情况可以使用hutool

## Hutool与已有工具对应关系
1. hutool-aop Spring
2. hutool-cache Guava的Cache模块
3. hutool-core Apache-Commons-lang
4. hutool-cron Quartz，Cron4j
5. hutool-crypto BouncyCastle
6. hutool-http OKHttp，HttpClient
7. hutool-log Slf4j
8. hutool-json FastJson，Jackson
9. hutool-poi EasyPOI
   ...

## 几个设计原则
1. 多数static
2. 少传参数，有默认参数
3. 不引入依赖
4. 不侵入

## 参考资料
1. hutool: (hutool)[https://doc.hutool.cn/pages/index/]