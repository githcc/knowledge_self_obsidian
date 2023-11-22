package com.example.demo.generator.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.generator.domain.User;
import com.example.demo.generator.service.UserService;
import com.example.demo.generator.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author wyswy
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-23 02:52:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public Page<User> getPage() {
        Page<User> userPage = new Page<>();
        userPage.setCurrent(10L);
        userPage.setSize(1000L);
        return userMapper.selectPage(userPage, null);
    }
}




