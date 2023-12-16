package com.cc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.cc.utils.HttpUtil.engineCookie;

@RestController
@RequestMapping("cookie")
public class CookieController {
    @GetMapping("put")
    public Object put(@RequestParam("engine")String engine, @RequestParam("cookie")String cookie) {
        engineCookie.put(engine,cookie);
        return "ok";
    }
}
