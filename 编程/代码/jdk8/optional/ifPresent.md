```
public class BootApplication {  
    @Test  
    public void boot() {  
        // 在值不为空的情况下进行逻辑判断  
        Optional<Boolean> isAdult = Optional.ofNullable(null);  
        isAdult.ifPresent(s -> System.out.println(s ? "成年" : "未成年"));  
    }  
}
