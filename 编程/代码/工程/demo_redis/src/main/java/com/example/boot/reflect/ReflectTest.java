package com.example.boot.reflect;

import com.example.boot.base.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    // 修改属性
    @Test
    public void testField() throws Exception {
        User user = new User(1,"张三",28);
        // 获取 Class 对象
        Class<?> clazz = Class.forName("com.example.boot.base.User");
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        // 修改name属性的值
        nameField.set(user, "李四");
        System.out.println(user);
    }

    // 修改方法
    @Test
    public void testMethod() throws Exception {
        User user = new User(1,"张三",28);
        // 获取 Class 对象
        Class<?> clazz = Class.forName("com.example.boot.base.User");
        // 获取setName方法
        Method setNameMethod = clazz.getMethod("setName", String.class);

        // 设置setName方法的Accessible属性为true
        setNameMethod.setAccessible(true);

        // 调用setName方法，将user对象的name属性设置为"李四"
        setNameMethod.invoke(user, "李四");

        // 输出修改后的user对象的name属性
        System.out.println(user.getName());
    }

    // 新建对象
    @Test
    public void testNewInstance() throws Exception {
        // 获取 Class 对象
        Class<?> clazz = Class.forName("com.example.boot.base.User");

        // 创建对象
        User user = (User) clazz.newInstance();

        // 输出对象
        System.out.println(user);
    }
}