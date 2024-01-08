# gpt-offline-self-springboot
个人使用的离线版gpt，模型需要自己另外下载

## 模型地址
1. [mistral-7b-openorca.Q4_0.gguf](https://gpt4all.io/models/gguf/mistral-7b-openorca.Q4_0.gguf)
2. [官网](https://gpt4all.io/index.html)

## 使用
1. 下载模型
2. 将修改模型路径

## TODO
1. 请求改为post，突破get报文限制 ok
2. 将响应改为流式，立即响应 ok
3. 支持多轮对话 ok
4. 处理内存泄露
5. 处理关闭连接
6. 使用gpu，加快响应速度

## 发布地址
[gpt-offline-self-springboot](https://github.com/githcc/gpt-offline-self-springboot)

## 参考项目
[gpt4all](https://github.com/nomic-ai/gpt4all)