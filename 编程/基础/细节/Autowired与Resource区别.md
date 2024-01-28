## Autowired与Resource区别
`@Autowired`和`@Resource`都是用于依赖注入（Dependency Injection）的注解，但在Java中有一些区别：

1. **来源**:
    - `@Autowired`是Spring框架提供的注解，用于自动装配Spring容器中的bean。
    - `@Resource`是JavaEE（现在称为Jakarta EE）提供的注解，它也可以用于依赖注入，但是不仅仅局限于Spring，也可以在其他JavaEE容器中使用。

2. **类型**:
    - `@Autowired`是按照类型（byType）进行注入的。它会尝试将指定类型的bean自动装配到需要的地方。
    - `@Resource`是按照名称（byName）进行注入的。它默认按照bean的名称进行匹配。

3. **配置属性**:
    - `@Autowired`可以通过`@Qualifier`结合使用，以便更精确地指定要注入的bean。
    - `@Resource`可以指定`name`、`type`属性来指定要注入的bean，`name`用于指定bean的名称，`type`用于指定bean的类型。

示例：

```java
// 使用@Autowired注解示例
public class SomeClass {
    private SomeDependency dependency;

    @Autowired
    public SomeClass(SomeDependency dependency) {
        this.dependency = dependency;
    }
    
    // ...
}

// 使用@Resource注解示例
public class AnotherClass {
    @Resource(name = "specificBean")
    private SomeDependency dependency;
    
    // ...
}
```

总的来说，`@Autowired`更加灵活，并且通常与Spring框架一起使用，而`@Resource`是JavaEE的一部分，在特定情况下可以在不同的JavaEE容器中使用。
