```
@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void one() {
        Page<User> userPage = new Page<>();
        userPage.setCountId("1");
        userPage.setSize(10L);
        Page<User> result = userMapper.selectPage(userPage, null);
        System.out.println(result.getRecords().get(0));
        System.out.println(result);
    }
}
```