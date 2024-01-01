## 版本变迁
swagger2->swagger3->Springdoc OpenAPI

## 使用
swagger是API文档生成插件，要在Spring Boot中使用swagger，你可以按照以下步骤进行：

1. **添加依赖：** 在你的Spring Boot项目的`pom.xml`文件中添加依赖：

    ```
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.3.0</version>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-api</artifactId>
            <version>2.3.0</version>
        </dependency>
    ```

   请确保将`YOUR_SPRINGDOC_VERSION`替换为你所需的Springdoc版本号。

2. **创建API：** 创建你的Spring Web MVC控制器并添加相关的API注解。例如：

    ```java
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class HelloController {
    
        @GetMapping("/hello")
        public String hello() {
            return "Hello, Springdoc OpenAPI!";
        }
    }
    ```

3. **访问API文档：** 默认情况下，你可以通过访问`http://localhost:8080/swagger-ui.html`来查看生成的API文档，假设你的应用程序在本地的8080端口运行。如果端口不同，请相应地修改URL。

`springdoc-openapi-starter-webmvc-api`模块会自动扫描你的Spring Web MVC应用程序，根据控制器和相关的注解（如`@RestController`、`@GetMapping`等）生成API文档。

你可以根据需要对Springdoc OpenAPI进行配置，并使用其他注解来扩展文档信息，比如`@ApiOperation`、`@ApiResponse`等。这些注解可以帮助你更好地描述API的信息，包括接口描述、参数描述和响应描述等。


## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)
