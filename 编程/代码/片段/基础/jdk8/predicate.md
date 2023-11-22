```
public class BootApplication {

    @Test
    public void boot() {
        System.out.println(predicate((item) -> item.length() > 3, "123"));
    }

    public Boolean predicate(Predicate<String> predicate, String str) {
        return predicate.test(str);
    }
}
```