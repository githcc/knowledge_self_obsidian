实现敏感词过滤的关键在于构建敏感词的 DFA 模型，并将待检测的文本逐字符在该模型中进行匹配。以下是一个简单的基于 Java 的示例，用于实现敏感词过滤：

```java
import java.util.*;

class DFAModel {
    private Set<String> sensitiveWords; // 敏感词集合
    private Map<Character, Map<String, Integer>> dfa; // DFA模型

    public DFAModel(Set<String> sensitiveWords) {
        this.sensitiveWords = sensitiveWords;
        buildDFA();
    }

    private void buildDFA() {
        dfa = new HashMap<>();
        for (String word : sensitiveWords) {
            Map<Character, Map<String, Integer>> currentState = dfa;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Map<String, Integer> nextState = currentState.computeIfAbsent(c, k -> new HashMap<>());
                if (!nextState.containsKey("id")) {
                    nextState.put("id", i == word.length() - 1 ? 1 : 0);
                }
                currentState = nextState.containsKey("next") ? dfa.get(nextState.get("next")) : nextState;
            }
        }
    }

    public boolean containsSensitiveWord(String text) {
        Map<Character, Map<String, Integer>> currentState = dfa;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!currentState.containsKey(c)) {
                currentState = dfa;
            } else {
                Map<String, Integer> nextState = currentState.get(c);
                if (nextState.containsKey("id") && nextState.get("id") == 1) {
                    return true; // 匹配到敏感词
                }
                currentState = nextState.containsKey("next") ? dfa.get(nextState.get("next")) : nextState;
            }
        }
        return false; // 未匹配到敏感词
    }
}

public class SensitiveWordFilterExample {
    public static void main(String[] args) {
        Set<String> sensitiveWords = new HashSet<>();
        sensitiveWords.add("敏感词1");
        sensitiveWords.add("敏感词2");
        // 添加更多敏感词到 sensitiveWords

        DFAModel dfaModel = new DFAModel(sensitiveWords);

        String textToCheck = "这是一个包含敏感词1的文本。"; // 待检测的文本

        if (dfaModel.containsSensitiveWord(textToCheck)) {
            System.out.println("文本包含敏感词");
            // 在这里可以进行相应的敏感词处理或过滤操作
        } else {
            System.out.println("文本没有敏感词");
        }
    }
}
```

以上示例是一个简单的敏感词过滤器，实现了基于 DFA 模型的敏感词过滤。在实际应用中，还可以根据需求进行优化和扩展，比如敏感词替换、标记敏感词位置等操作。同时，敏感词过滤也需要考虑性能和准确性，可能需要结合其他算法或技术来提高过滤效率和精度。

## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)