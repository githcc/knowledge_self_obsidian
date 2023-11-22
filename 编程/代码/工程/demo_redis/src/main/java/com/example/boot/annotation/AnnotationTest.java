package com.example.boot.annotation;

import com.example.boot.base.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationTest {

    // 测试自定义注解
    @Test
    public void testAnnotataion() throws ClassNotFoundException {
        User[] users = {
                new User(1, "张三", 28),
                new User(2, "李四", 30),
                new User(3, "王五", 42)
        };
        Field[] declaredFields = User.class.getDeclaredFields();
        Arrays.stream(declaredFields).filter(field -> field.isAnnotationPresent(MyAnnotation.class))
                .map(field -> field.getAnnotation(MyAnnotation.class).name())
                .forEach(item->{
                    System.out.printf("%8s", item);
                });
        System.out.println();

        Arrays.stream(users).forEach(
                item->{
                    System.out.printf("%8s", item.getId());
                    System.out.printf("%8s", item.getName());
                    System.out.printf("%8s", item.getAge());
                    System.out.println();
                }
        );


    }
}
