package com.example.boot.base;

import com.example.boot.annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    @MyAnnotation(name = "ID")
    private long id;
    @MyAnnotation(name = "姓名")
    private String name;
    @MyAnnotation(name = "年龄")
    private int age;
}
