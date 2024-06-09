## BIO
Stream File
Buffered
Reader Write
input output
转换流(InputStreamReader/OutputStreamWriter)
print
Object

## BIO的使用 #标题/TODO
1. [[字节流拷贝|字节流拷贝]]
2. [[字符流拷贝|字符流拷贝]]

## NIO，AIO 两者间的区别
NIO (Non-blocking I/O) 和 AIO (Asynchronous I/O) 都是 Java 中处理 I/O 操作的异步机制,但它们在实现方式和使用场景上有一些区别:

1. **实现机制**:
    - NIO 使用了基于事件驱动的 I/O 模型,通过 Selector 监听 I/O 事件,当事件发生时触发回调,这种方式称为"同步非阻塞"。
    - AIO 则基于操作系统提供的异步 I/O 操作,使用 CompletionHandler 接收异步操作的结果,这种方式称为"异步非阻塞"。

2. **适用场景**:
    - NIO 适用于需要同时处理多个 I/O 操作的场景,比如网络服务器、文件 I/O 等。它能够高效地管理大量的 I/O 连接。
    - AIO 更适合于执行少量 I/O 操作的场景,比如文件读写等。它能够充分利用操作系统的异步 I/O 功能,减少线程切换开销。

3. **编程复杂度**:
    - NIO 相比于传统的阻塞 I/O 操作,需要开发者编写更加复杂的代码来处理非阻塞 I/O 和事件驱动的逻辑。
    - AIO 的编程复杂度相对较低,开发者只需要实现 CompletionHandler 接口即可。

总的来说,NIO 更适合于处理高并发的 I/O 操作,而 AIO 则适合于执行少量 I/O 操作的场景。在选择使用 NIO 还是 AIO 时,需要结合具体的应用场景和性能需求进行权衡。

## 这种写法自动关流
```
try (FileOutputStream fileOut = new FileOutputStream("map.bin");
    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
    objectOut.writeObject(map);
} catch (IOException e) {
}
```

## 参考资料
1. google：[gemini](https://gemini.google.com/app)