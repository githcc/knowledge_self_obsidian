```
public class BootApplication {

    @Test
    public void boot() {
        System.out.println(con((item) -> String.valueOf(++item), 5));
    }

    public String con(Function<Integer,String> function, int i) {
        return function.apply(i);
    }
}
```
