```
public class BootApplication {
    @Test
    public void boot() {
        Optional<String> op = Optional.of("abc");
        // 存在值就为true
        if (op.isPresent()){
            System.out.println(op.get());
        }else{
            System.out.println("123");
        }
    }
}
```
