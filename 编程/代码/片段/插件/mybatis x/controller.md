```
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userServiceImpl;

    @RequestMapping("one")
    public Object one(){
        return userServiceImpl.list().get(0);
    }
}
```