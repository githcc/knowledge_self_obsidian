```
public class BootApplication {

    @Test
    public void boot() {
        sup(() -> {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += i;
            }
            return sum;
        });
    }

    public void sup(Supplier<Integer> supplier) {
        Integer i = supplier.get();
        System.out.println(i);
    }
}
```