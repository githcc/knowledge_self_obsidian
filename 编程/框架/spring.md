## spring体系结构
1. **Spring Core Container（Spring核心容器）**：提供核心功能，包括依赖注入和Bean管理。这包括`BeanFactory`和`ApplicationContext`等。

2. **AOP模块**：支持面向切面编程，允许通过特定切入点将横切关注点（如日志记录、事务管理）与应用程序的主要业务逻辑分开。

3. **数据访问/集成模块**：提供与数据访问相关的功能，包括对JDBC、ORM（如Hibernate）、JMS、JPA等的集成支持。

4. **Web模块**：包括Spring MVC，用于构建Web应用程序的支持。它提供了一种基于MVC设计模式的框架，使得开发Web应用更加简单。

5. **测试模块**：支持对Spring应用程序进行单元测试和集成测试，使得测试变得更加简便。


## spring优势
1. **轻量级和非侵入性**：Spring是一个轻量级框架，不强制应用程序使用所有其功能。开发者可以根据需要选择使用Spring的特定模块，这种非侵入性使得集成Spring到现有项目中变得更加容易。

2. **依赖注入（DI）和控制反转（IoC）**：Spring通过依赖注入和控制反转的概念，降低了组件之间的耦合度。这意味着对象之间的依赖关系不是硬编码在代码中，而是由Spring容器动态地管理和注入，使得代码更易于理解、测试和维护。

3. **面向切面编程（AOP）**：Spring的AOP模块允许将横切关注点（如日志记录、事务管理）与应用程序的核心业务逻辑分开。这种模块化的方法简化了代码，并且提高了可维护性和可扩展性。

4. **丰富的集成**：Spring提供了对各种技术（如Hibernate、JPA、JDBC、JMS等）的集成支持，使得与这些技术的整合变得更加容易和灵活。

5. **简化开发**：Spring提供了大量的辅助工具和类库，简化了常见任务的开发过程。例如，Spring MVC简化了Web应用程序的开发，使得构建基于MVC设计模式的Web应用更加简单。

6. **测试支持**：Spring框架提供了用于单元测试和集成测试的支持和工具，使得测试变得更加容易，帮助开发者保持代码的稳定性和质量。

7. **广泛的社区和资源**：由于其流行度，Spring拥有庞大的社区支持和丰富的文档资源，开发者可以轻松地获取帮助、教程和解决方案。


## bean的生命周期
### 1. 配置阶段
- **定义Bean：** 在XML配置文件、Java配置类或者注解中，开发人员定义了Bean的配置信息，包括Bean的类名、作用域、依赖等。
- **加载配置：** Spring容器读取并解析配置信息，根据配置信息准备去实例化Bean。

### 2. 实例化阶段
- **实例化Bean：** Spring根据配置信息，使用相应的实例化策略（比如构造器注入、工厂方法等）创建Bean的实例。
- **处理依赖：** 如果Bean有依赖关系，Spring会解析这些依赖并进行注入。

### 3. 初始化阶段
- **Bean的生命周期回调方法：** 如果Bean实现了特定的接口（如InitializingBean接口），或者在配置中使用了相应的注解（如@PostConstruct），Spring会调用这些方法进行初始化工作。
- **Aware接口的使用：** 如果Bean实现了Aware接口（如BeanNameAware、ApplicationContextAware等），Spring会调用相关方法，使Bean获取到一些额外的信息，比如Bean的名称、ApplicationContext等。

### 4. 容器管理阶段
- **注册Bean：** 初始化完成后，Spring将Bean注册到应用上下文中，可以被其他Bean引用和使用。
- **使用Bean：** 应用程序可以通过应用上下文从Spring容器中获取和使用Bean。

### 5. 销毁阶段
- **Bean销毁：** 当应用程序关闭或者销毁时，Spring容器会调用Bean的销毁方法（比如实现了DisposableBean接口或者使用了@PreDestroy注解），进行一些清理工作和资源释放。

## bean标签
```
<bean factory-bean="factoryBeanId" factory-method="factoryMethodName"></bean>
<property name="propertyName" value="propertyValue" ref="beanId"/>
<context:property-placeholder location="classpath:filename.properties">
```

## bean注解
### 定义
```
@Component    @Controller    @Service    @Repository
```
### 作用域
```
@Scope
```
### 生命周期
```
@PostConstruct、@PreDestroy
```
### 加载第三方资源
```
@Bean
```
### 非引用类型属性注入
```
@Value
```
### 引用类型属性注入 #标题/TODO
```
@Autowired默认按类型装配 指定@Qualifier后可以指定自动装配的bean的id
@Resource设置注入的bean的id 配合type可以实现类型注入，没试过呢
```

### 加载properties文件，不支持*通配格式
```
@PropertySource
```

### 控制bean的加载时机，使其延迟加载
```
@Lazy
```

### 扫包
```
@ComponentScan
```

## 其它注解

### 
```
@Configuration、@ComponentScan、@Import
```

## AOP
1. 切面编程
2. 对oop（面向对象编程）的一种补充

## AOP的优势
1. 解耦，统一管理，如日志，安全
2. 代码复用
3. 提高可维护性

## AOP的概念
1. 切面（Aspect）
切面是横切关注点的模块化，它包含了一组通知和切点。

    1.1 切点（Pointcut）
    切点是在应用程序中定义的一个或多个点，用于指定切面逻辑执行的地方。它允许你定义在何处应用切面的逻辑。

    1.2 通知（Advice）
    通知定义了在切点处执行的具体逻辑。AOP定义了几种类型的通知：
    - **前置通知（Before Advice）：** 在切点方法执行之前执行。
    - **后置通知（After Advice）：** 在切点方法执行之后执行，无论方法是否成功完成。
    - **返回通知（After Returning Advice）：** 在切点方法成功执行后执行。
    - **异常通知（After Throwing Advice）：** 在切点方法抛出异常后执行。
    - **环绕通知（Around Advice）：** 在切点方法执行前后都执行，并且可以控制方法的执行过程。

2. 连接点（Join Point）
连接点是应用程序执行过程中可以插入切面的点。在AOP中，连接点通常是方法调用或特定的代码段，比如方法执行时、异常处理时等。

3. 引入（Introduction）
引入允许添加新方法或属性到现有的类中，而不修改类的代码。这使得在不改变类结构的情况下，可以向现有类添加新功能。

4. 目标对象（Target Object）
目标对象是真正执行业务逻辑的对象。在AOP中，切面会影响目标对象的行为，但不改变它本身的代码。

5. 织入（Weaving）
织入是将切面与目标对象或程序其他部分连接起来的过程。这可以在编译时、加载时或运行时完成，将切面逻辑应用到目标对象的过程中。

spring 1
ioc aop
ioc <bean class = "User"> xx.xml
1. 定义一个applicationContext
2. 读取applicationContext.xml
3. 成为一个bean工厂

spring 2
1. 定义一个applicationContext
2. 读取applicationContext.xml
3. 开启扫描 component-scan
4. 对应的类需要使用注解
@RequestMapping @Controller @Service @Repository

spring 3
@Configuration 取代xml配置方式
@ImportResource
@ComponentScan
@Import
1. 定义一个上下文对象
2. 读取配置类
3. 配置类
方案一：@Bean
方案二：@ComponentScan
4. annotation-driven 注解驱动，识别自定义注解
原理：实现了BeanPostProcessor，当spring加载的时候会调用一个Before方法

spring 4
@Conditional(放入一个Conditional的实现类) 条件装配

spring 5
1. 响应式编程支持
   1. 客户端实时感知 异步非阻塞
2. WebFlux [[框架/spring/WebFlux.md|WebFlux]]
   1. 接口需要使用 produces = MediaType.TEXT_EVENT_STREAM_VALUE
   2. 可以实现回调的效果

## 生命周期
在Spring框架中，Bean的生命周期可以分为以下阶段：

1. **实例化（Instantiation）：** 在容器启动时，Spring根据配置或注解创建Bean的实例。这可以通过构造函数实例化或者工厂方法实例化完成。

2. **属性设置（Properties Set）：** 在实例化后，Spring将会注入Bean的属性，这可以通过XML配置或者自动装配实现。

3. **初始化（Initialization）：** 在属性注入完成后，Spring提供了两种主要的初始化回调方法：`InitializingBean`接口的`afterPropertiesSet()`方法和`@PostConstruct`注解标记的方法。这些方法允许开发人员在Bean初始化时执行一些自定义的逻辑操作。

4. **使用（In Use）：** Bean被完全初始化后，它就可以被容器使用了。在这个阶段，Bean可以被其他Bean引用并执行相应的业务逻辑。

5. **销毁（Destruction）：** 当应用程序关闭或者容器销毁时，Spring提供了两种主要的销毁回调方法：`DisposableBean`接口的`destroy()`方法和`@PreDestroy`注解标记的方法。这些方法允许开发人员在Bean被销毁之前执行一些自定义的清理操作。

通过这些生命周期阶段，开发人员可以在Bean的不同阶段插入自定义的逻辑，以满足特定的需求，比如资源管理、初始化配置、清理资源等。

## 疑问
1. spring 使用TypeFilter，ImportSelector
2. 自己用springboot仿一个日志aop