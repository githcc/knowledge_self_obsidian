package com.example.demo.generator.vo.userandcompany;

import com.example.demo.generator.domain.Company;
import com.example.demo.generator.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class VO21 extends User {
    private List<Company> company;
}
