package com.example.demo.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.generator.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wyswy
* @description 针对表【user】的数据库操作Service
* @createDate 2023-11-23 02:52:27
*/
public interface UserService extends IService<User> {
    Page<User> getPage();
}
