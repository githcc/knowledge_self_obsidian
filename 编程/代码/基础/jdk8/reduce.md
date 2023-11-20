```
public class BootApplication {
    @Test
    public void boot() {
        int[] nums = {1,3,4,5};
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
```