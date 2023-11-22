package com.example.demo.generator.controller;

import com.example.demo.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userServiceImpl;

    @RequestMapping("one")
    public Object one(){
        return userServiceImpl.getById(1);
    }
}
