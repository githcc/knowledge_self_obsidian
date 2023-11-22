package com.example.demo.generator.vo.userandcompany;

import com.example.demo.generator.domain.Company;
import com.example.demo.generator.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class VO11{
    private User user;
    private Company company;
}
