```
public class BootApplication {
    @Test
    public void boot() {
        Optional<String> op = Optional.of("abc");
        String s = op.get();//有值返回，没值报错
    }
}
```
