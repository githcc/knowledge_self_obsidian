package com.example.demo.generator.mapper.userandcompany;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.generator.Base;
import com.example.demo.generator.vo.userandcompany.VO11;
import com.example.demo.generator.vo.userandcompany.VO21;
import com.example.demo.generator.vo.userandcompany.VO31;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MapperTest extends Base {

    @Autowired
    VO11Mapper vo11Mapper;

    @Autowired
    VO21Mapper vo21Mapper;

    @Autowired
    VO31Mapper vo31Mapper;
    @Test
    void listUserAndCompany11() {
        List<VO11> vo11s = vo11Mapper.listUserAndCompany();
    }

    @Test
    void listUserAndCompany21() {
        List<VO21> vo21s = vo21Mapper.listUserAndCompany();
    }

    @Test
    void listUserAndCompany31() {
        List<VO31> vo31s = vo31Mapper.listUserAndCompany();
    }

}