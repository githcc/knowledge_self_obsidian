package com.example.demo.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.generator.service.CompanyService;
import com.example.demo.generator.domain.Company;
import com.example.demo.generator.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

/**
* @author wyswy
* @description 针对表【company】的数据库操作Service实现
* @createDate 2023-11-23 02:52:27
*/
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company>
    implements CompanyService {

}




