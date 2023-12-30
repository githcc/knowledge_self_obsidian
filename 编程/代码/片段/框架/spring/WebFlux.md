## 接口
```
    @GetMapping("t0")
    public Flux<String> t0(){
        List<String> data = Arrays.asList("Data1", "Data2", "Data3", "Data4", "Data5", "Data6");
        return Flux.fromIterable(data).delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("t1")
    public Mono<String> t1() {
        return Mono.just("Hello from WebFlux!");
    }
    
    // 流式回复
    @PostMapping(value = "/api/generateStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> generateStream(@RequestBody MessageVO[] messageVOS) {
        String prompt =  convert(messageVOS);
        log.info(prompt);
        LLModel.LIBRARY_SEARCH_PATH = getResourcesFolderPath();

        LLModel mptModel = new LLModel(Path.of(model));
        LLModel.GenerationConfig config = LLModel.config()
                .withNPredict(4096)
                .withRepeatLastN(64)
                .build();

        return mptModel.generateStream(prompt, config, true);
    }
```

## 回调
```
public Flux<String> generateStream(String prompt, GenerationConfig generationConfig, boolean streamToStdOut) {
        return Flux.create(fluxSink -> {

            ByteArrayOutputStream bufferingForStdOutStream = new ByteArrayOutputStream();
            ByteArrayOutputStream bufferingForWholeGeneration = new ByteArrayOutputStream();
            LLModelLibrary.ResponseCallback responseCallback = getResponseCallbackStream(streamToStdOut,bufferingForStdOutStream, bufferingForWholeGeneration ,fluxSink);
            library.llmodel_prompt(this.model,
                    prompt,
                     (int tokenID) -> {
                        if(LLModel.OUTPUT_DEBUG)
                            log.info("token " + tokenID);
                        return true; // continue processing
                    },
                    responseCallback,
                    (boolean isRecalculating) -> {
                        if(LLModel.OUTPUT_DEBUG)
                            log.info("recalculating");
                        return isRecalculating; // continue generating
                    },
                    generationConfig);
        });
    }
```