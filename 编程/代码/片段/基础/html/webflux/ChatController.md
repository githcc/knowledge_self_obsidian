```
@RestController
public class ChatController {

    @RequestMapping(value ="chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public  Flux<String> chat(){
        WebClient webClient = WebClient.create("https://api.openai-proxy.com/v1/chat");

        // 构建请求体的JSON字符串
        String requestBody = "{\n" +
                "  \"model\": \"gpt-3.5-turbo-1106\",\n" +
                "  \"stream\": true,\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"role\": \"user\",\n" +
                "      \"content\": \"写一篇爱情作文300字\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Bearer Token
        String bearerToken = "sk-xx";

        // 发起异步POST请求，并获得一个Flux表示响应体
        return webClient.post()
                .uri("/completions")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken)
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToFlux(String.class);
    }
}
```