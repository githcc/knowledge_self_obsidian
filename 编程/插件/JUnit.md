## 单元测试对比
1. JUnit 使用较简单，作为主力
2. Mockito 功能强大，需要配合JUnit一起使用

## 好处
1. 可以极速地进行回归测试
   1. 减少重复工作
   2. 减少bug

## 测试-功能测试
1. 输入验证测试：验证接口对输入数据的验证是否正确，例如是否满足数据类型、长度、范围等要求。
2. 响应结果测试：验证接口的响应结果是否正确，例如是否满足预期的数据类型、格式、内容等要求。
3. 异常情况测试：验证接口在异常情况下的行为，例如输入数据不符合要求、系统发生错误等情况。
4. 边界值测试：验证接口在边界值情况下的行为，例如输入数据的最大值、最小值、零值等情况。

### 具体情况
1. 是否可以调用
2. 数据结构是否正常
3. 边界测试
   1. 特殊值
      1. 空
      2. null
      3. ""
   2. 边界
      1. 正常
      2. 最大
      3. 最小
      4. 边界外 +/-1

## 测试-非功能测试
1. 性能测试：验证软件在各种负载条件下是否能够满足性能要求，例如响应时间、吞吐量、并发量等。
2. 可靠性测试：验证软件在正常使用和异常情况下的稳定性，例如软件的故障率、恢复时间等。
3. 可用性测试：验证软件在各种环境下是否能够满足用户的使用需求，例如易用性、易学习性、易维护性等。
4. 安全性测试：验证软件是否能够抵御各种安全威胁，例如恶意软件攻击、数据泄露等。

### 具体情况
1. 资源使用情况
2. 接口tps
3. 响应时间
4. 主备切换时间
5. 会话机制
6. 健康检查
7. 配置合规性检查
8. 批处理
   1. 是否有前置条件
   2. 是否支持重复执行
9. 日志文件
   1. 命名
   2. 存放位置
   3. 存放时长
   4. 切割情况
   5. 敏感信息
   6. 管理台操作记录
   7. 修改配置是否实时
10. 业务数据备份/清理

## JUnit 注解
JUnit 注解可以用于配置测试方法、控制测试运行顺序、指定测试数据等。以下是一些常用的 JUnit 注解：

* **@Test：** 用于标注测试方法。

```
@Test
public void testAssertEquals() {
    assertEquals(1, 1);
}
```

* **@Before：** 用于标注在测试方法之前执行的方法。

```
@Before
public void setUp() {
    // 初始化测试环境
}
```

* **@After：** 用于标注在测试方法之后执行的方法。

```
@After
public void tearDown() {
    // 清理测试环境
}

@Test
public void testAssertEquals() {
    // 进行测试
}
```

* **@BeforeClass：** 用于标注在所有测试方法之前执行的方法。

```
@BeforeClass
public static void setUpClass() {
    // 初始化所有测试环境
}
```

* **@AfterClass：** 用于标注在所有测试方法之后执行的方法。

```
@AfterClass
public static void tearDownClass() {
    // 清理所有测试环境
}
```

* **@Ignore：** 用于标注要忽略的测试方法。

```
@Ignore
public void testIgnore() {
    // 这是一个要忽略的测试方法
}
```

* **@Test(expected = 异常类.class)：** 用于标注要断言抛出指定异常的测试方法。

```
@Test(expected = NullPointerException.class)
public void testAssertThrows() {
    String s = null;
    s.length();
}
```

* **@RepeatedTest(n)：** 用于重复执行测试方法 n 次。

```
@RepeatedTest(5)
public void testAssertEquals() {
    assertEquals(1, 1);
}
```

* **@ParameterizedTest：** 用于将测试数据与测试方法进行参数化。

```
@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
public void testAssertEquals(int value) {
    assertEquals(value, value);
}
```

* **@TestFactory：** 用于生成测试方法。


@TestFactory
public Stream<DynamicTest> testAssertEquals() {
return Stream.of(1, 2, 3).map(value -> DynamicTest.dynamicTest("testAssertEquals(" + value + ")", () -> {
assertEquals(value, value);
}));
}


* **@Timeout(millis)：** 用于指定测试方法的超时时间。

```
@Timeout(1000)
public void testAssertEquals() {
    // 这是一个要等待 1 秒的测试方法
}
```

## 断言种类
JUnit 提供了丰富的断言方法来验证测试结果。以下是一些常用的断言方法：

* **assertEquals()：** 验证两个值是否相等。

```
assertEquals(1, 1);
```

* **assertFalse()：** 验证条件是否为假。

```
assertFalse(1 == 2);
```

* **assertTrue()：** 验证条件是否为真。

```
assertTrue(1 != 2);
```

* **assertNotNull()：** 验证对象是否不为空。

```
assertNotNull(new Object());
```

* **assertNull()：** 验证对象是否为空。

```
assertNull(null);
```

* **assertSame()：** 验证两个引用是否指向同一个对象。

```
assertSame(new Object(), new Object());
```

* **assertNotSame()：** 验证两个引用是否不指向同一个对象。

```
assertNotSame(new Object(), new Object());
```

* **assertArrayEquals()：** 验证两个数组是否相等。

```
assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
```

* **assertThrows()：** 验证方法是否抛出指定的异常。

```
assertThrows(NullPointerException.class, () -> {
    String s = null;
    s.length();
});
```



## springboot使用JUnit
    ```
    @SpringBootTest
    class UserServiceImplTest {
        @Autowired
        UserService userServiceImpl;
    
        @Test
        void listUserPage() {
            User user = userServiceImpl.getPage().getRecords().get(0);
            System.out.println(user);
        }
    }
    ```



## 参考资料
1. google：[gemini](https://gemini.google.com/app)