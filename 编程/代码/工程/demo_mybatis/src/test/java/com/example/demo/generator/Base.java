package com.example.demo.generator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Base {

    long l1;
    @BeforeEach
    public void beforeTest(){
        l1 = System.currentTimeMillis();
    }

    @AfterEach
    public void afterTest(){
        System.out.println(System.currentTimeMillis() - l1);
    }
}
