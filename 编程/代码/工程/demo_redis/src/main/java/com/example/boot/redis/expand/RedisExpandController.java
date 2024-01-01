package com.example.boot.redis.expand;

import com.example.boot.base.User;
import jakarta.annotation.Resource;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController("expand/user")
public class RedisExpandController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 使用分布式锁

    private final String PRE = "CACHE:USER";
    private final String LOCK_HOT_CACHE_PRE = "LOCK_HOT_CACHE:USER";
    @Resource
    private Redisson redisson;

    // 减少缓存统一失效概率，引发服务缓存击穿，不是很理解
    private int getTimeout(){
        int CACHE_TIMEOUT = 30 * 60;
        return CACHE_TIMEOUT +new Random().nextInt(60);
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public User create(User user) {
        // 插入数据库
        // user = DAO.create(user);
        // 更新缓存
        redisTemplate.opsForValue().set(PRE + user.getId(), user, getTimeout(), TimeUnit.SECONDS);
        return user;
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public User getUserById(User user) {
        RReadWriteLock readWriteLock = redisson.getReadWriteLock(LOCK_HOT_CACHE_PRE + user.getId());
        RLock rLock = readWriteLock.writeLock();
        rLock.lock();
        try{
            // 修改数据库
            // user = DAO.update(user);
            // 更新缓存
            redisTemplate.opsForValue().set(PRE + user.getId(), user, getTimeout(), TimeUnit.SECONDS);
        }finally {
            rLock.unlock();
        }
        return user;
    }

    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id) {
        User user = (User) redisTemplate.opsForValue().get(PRE + id);
        if (user != null) {
            // 对缓存时间进行延期
            redisTemplate.opsForValue().set(PRE + id, user, getTimeout(), TimeUnit.SECONDS);
            return user;
        }
        // DCL
        RReadWriteLock readWriteLock = redisson.getReadWriteLock(LOCK_HOT_CACHE_PRE + id);
        RLock rLock = readWriteLock.readLock();
        rLock.lock();
        try {
            user = (User) redisTemplate.opsForValue().get(PRE + id);
            if (user != null) {
                return user;
            }

            // 从数据库中获取
            // 情况一：可以获取到数据
            user = User.builder()
                    .id(id)
                    .name("cc")
                    .age(27)
                    .build();

            // 将用户信息缓存到Redis中
            redisTemplate.opsForValue().set(PRE + id, user, getTimeout(), TimeUnit.SECONDS);

            // 情况二：查不到数据，也要设置缓存，后续减少类似请求仍然到数据库，引发缓存穿透问题
            redisTemplate.opsForValue().set(PRE + id, "{}", getTimeout(), TimeUnit.SECONDS);
            return user;
        } finally {
            rLock.unlock();
        }
    }
}

