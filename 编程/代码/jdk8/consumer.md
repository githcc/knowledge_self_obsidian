```
public class BootApplication {

    @Test
    public void boot() {
        con((item) -> {
            for (Integer i = 0; i < item; i++) {
                System.out.println(i);
            }
        },5);
    }

    public void con(Consumer<Integer> consumer, int i) {
        consumer.accept(i);
    }
}
```
