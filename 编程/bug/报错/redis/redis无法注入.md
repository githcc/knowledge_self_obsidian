```
***************************
APPLICATION FAILED TO START
***************************

Description:

Field redisTemplate in com.example.boot.controller.UserController required a bean of type 'org.springframework.data.redis.core.RedisTemplate' that could not be found.

The injection point has the following annotations:
	- @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean of type 'org.springframework.data.redis.core.RedisTemplate' in your configuration.

```
使用redis无法注入，将Autowired改Resource解决