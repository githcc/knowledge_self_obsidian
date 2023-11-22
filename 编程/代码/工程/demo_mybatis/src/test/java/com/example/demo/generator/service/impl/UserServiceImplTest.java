package com.example.demo.generator.service.impl;

import com.example.demo.generator.domain.User;
import com.example.demo.generator.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userServiceImpl;

    @Test
    void listUserPage() {
        User user = userServiceImpl.getPage().getRecords().get(0);
        System.out.println(user);
    }
}