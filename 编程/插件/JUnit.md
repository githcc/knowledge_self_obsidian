## 单元测试对比
1. JUnit 使用较简单，作为主力
2. Mockito 功能强大，需要配合JUnit一起使用

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


## 参考资料
1. google：[bard](https://bard.google.com/)