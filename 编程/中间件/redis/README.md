## redis的使用
在SpringBoot项目中使用Redis，只需要以下几个步骤：

1. 添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

```

2. 配置Redis

在`application.properties`文件中配置Redis的连接信息，例如：

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
spring.data.redis.password=password
```

3. 使用Redis

在代码中使用`RedisTemplate`接口来操作Redis，例如：

```java
@Autowired
private RedisTemplate<String, Object> redisTemplate;

public void test() {
    // 存储数据
    redisTemplate.opsForValue().set("key", "value");

    // 获取数据
    Object value = redisTemplate.opsForValue().get("key");

    // 删除数据
    redisTemplate.delete("key");
}
```

**示例代码**

以下是一个使用Redis缓存用户信息的示例：

```java
@Controller
public class UserController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        // 先从Redis中获取用户信息
        User user = (User) redisTemplate.opsForValue().get("user:" + id);
        if (user == null) {
            // Redis中没有用户信息，从数据库中获取
            user = userService.getUserById(id);

            // 将用户信息缓存到Redis中
            redisTemplate.opsForValue().set("user:" + id, user, 30, TimeUnit.MINUTES);
        }

        return user;
    }
}
```

在该示例中，我们先从Redis中获取用户信息，如果Redis中没有用户信息，则从数据库中获取。获取到用户信息后，我们将其缓存到Redis中，设置过期时间为30分钟。

**其他注意事项**

* 在使用Redis时，需要注意数据的序列化和反序列化。SpringBoot提供了多种序列化器，例如：Jackson2JsonRedisSerializer、JdkSerializationRedisSerializer、StringRedisSerializer等。
* 在使用Redis时，需要注意数据的持久化。Redis默认是不支持数据持久化的，如果需要数据持久化，可以配置Redis的持久化策略。

**总结**

SpringBoot提供了对Redis的自动配置，使用Redis非常简单。只需要在配置文件中配置Redis的连接信息，就可以使用RedisTemplate接口来操作Redis。

## redis的变化
可以通过以下方式看出来 Spring Boot 1.x 版本默认使用的是 Jedis，而在 Spring Boot 2.x 版本默认使用的就是 Lettuce：

* **查看依赖项**

在 Spring Boot 1.x 版本中，默认会添加 `spring-boot-starter-redis` 依赖项，该依赖项中包含了 Jedis 客户端。在 Spring Boot 2.x 版本中，默认会添加 `spring-boot-starter-data-redis` 依赖项，该依赖项中包含了 Lettuce 客户端。

* **查看配置文件**

在 Spring Boot 1.x 版本中，默认的 Redis 配置文件如下：

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

在 Spring Boot 2.x 版本中，默认的 Redis 配置文件如下：

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
spring.data.redis.lettuce.pool.max-active=8
spring.data.redis.lettuce.pool.max-idle=8
spring.data.redis.lettuce.pool.min-idle=0
```

可以看到，Spring Boot 2.x 版本的配置文件中增加了 `spring.data.redis.lettuce.pool` 属性，该属性用于配置 Lettuce 连接池。

* **查看源码**

Spring Boot 1.x 版本的自动配置类是 `RedisAutoConfiguration`，该类中使用的是 Jedis 客户端。Spring Boot 2.x 版本的自动配置类是 `LettuceConnectionConfiguration`，该类中使用的是 Lettuce 客户端。

因此，如果您的 Spring Boot 项目中添加了 `spring-boot-starter-redis` 依赖项，并且配置文件中没有指定 Redis 客户端，那么该项目将默认使用 Jedis 客户端。如果您的 Spring Boot 项目中添加了 `spring-boot-starter-data-redis` 依赖项，那么该项目将默认使用 Lettuce 客户端。

## 语法
进入容器
redis-cli
get value

## 参考资料
1. google：[gemini](https://gemini.google.com/app)