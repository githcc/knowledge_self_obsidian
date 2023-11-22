package com.example.boot.redis.base;

import com.example.boot.base.User;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisBaseController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("user/base")
    public User getUserById() {
        long id = 1L;
        // 先从Redis中获取用户信息
        User user = (User) redisTemplate.opsForValue().get("userBase:" + id);
        System.out.println(user);
        if (user == null) {
            // Redis中没有用户信息，从数据库中获取
            user = User.builder()
                    .id(id)
                    .name("cc")
                    .age(27)
                    .build();
            // 将用户信息缓存到Redis中
            redisTemplate.opsForValue().set("userBase:" + id, user, 30, TimeUnit.MINUTES);
        }
        return user;
    }
}

