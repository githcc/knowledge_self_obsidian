## json工具类的对比
1. fastjson 阿里的一个程序员搞的，速度快，不过出过两次大事故，公司项目用的比较多
2. jackson spring自带
3. gson 谷歌出品

## 相关的操作
1. 对象转json
    ```
    User user = User.builder().id(1).name("张三").age(28).build();
    System.out.println(JSON.toJSONString(user));
    ```
2. json转对象
    ```
    String str = "{\"age\":28,\"id\":1,\"name\":\"张三\"}";
    System.out.println(JSON.parseObject(str,User.class));
    ```