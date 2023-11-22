```
public class BootApplication {
    @Test
    public void boot() throws IOException {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("/application.properties");
        // 创建 Properties 对象
        Properties properties = new Properties();
        // 将输入流加载到 Properties 对象中
        properties.load(inputStream);
        // 获取属性值
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        // 打印属性值
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }
}
```
