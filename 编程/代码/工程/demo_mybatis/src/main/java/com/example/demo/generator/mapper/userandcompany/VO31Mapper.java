package com.example.demo.generator.mapper.userandcompany;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.generator.vo.userandcompany.VO21;
import com.example.demo.generator.vo.userandcompany.VO31;

import java.util.List;

/**
* @author wyswy
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-23 02:52:27
* @Entity generator.domain.User
*/
public interface VO31Mapper extends BaseMapper<VO31> {
    List<VO31> listUserAndCompany();
}




