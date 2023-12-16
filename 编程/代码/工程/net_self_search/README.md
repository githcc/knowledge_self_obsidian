# net_self_search
用于个人使用http请求搜索引擎

## 搜索
1. 使用http请求搜索引擎，处理报文后用于gpt联网功能
   1. baidu 调用失败
   2. google 需要代理，
   3. Yandex 可以正常调用, 如果不行可以调一下cookie接口

## 运行
   ```
   docker build -t my-java-app .
   docker run -p8080:8080 -d my-java-app
   ```