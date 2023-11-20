1. springboot 扫包
   1. 启动类上加 @ComponentScan("com.example.myproject")
2. springboot 返回报文中，当字段值为null不返回该字段
   1. 全局 配置文件上加 spring.jackson.default-property-inclusion=non_null
   2. 局部 在实体类上加 @JsonInclude(JsonInclude.Include.NON_NULL)
3. 