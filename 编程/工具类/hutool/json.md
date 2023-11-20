## 相关的操作
1. 对象转json
    ```
    User user = User.builder().id(1).name("张三").age(28).build();
    System.out.println(JSONUtil.toJsonStr(user));
    ```
2. json转对象
    ```
    String str = "{\"age\":28,\"id\":1,\"name\":\"张三\"}";
    System.out.println(JSONUtil.parse(str));
    ```