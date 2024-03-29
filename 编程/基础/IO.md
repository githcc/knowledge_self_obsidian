## BIO
| 类名 | 类型 | 操作基本单位 | 是否使用缓冲区 | 使用场景 |
|---|---|---|---|---|
| InputStream | 字节输入流 | 字节 | 否 | 读取任何格式的文件数据 |
| FileInputStream | 文件字节输入流 | 字节 | 否 | 读取文件数据 |
| BufferedInputStream | 缓冲字节输入流 | 字节 | 是 | 提高读取文件数据的效率 |
| Reader | 字符输入流 | Unicode码元 | 是 | 读取文本文件数据 |
| FileReader | 文件字符输入流 | Unicode码元 | 是 | 读取文本文件数据 |
| BufferedReader | 缓冲字符输入流 | Unicode码元 | 是 | 提高读取文本文件数据的效率 |
| OutputStream | 字节输出流 | 字节 | 否 | 写入任何格式的文件数据 |
| FileOutputStream | 文件字节输出流 | 字节 | 否 | 写入文件数据 |
| BufferedOutputStream | 缓冲字节输出流 | 字节 | 是 | 提高写入文件数据的效率 |
| Writer | 字符输出流 | Unicode码元 | 是 | 写入文本文件数据 |
| FileWriter | 文件字符输出流 | Unicode码元 | 是 | 写入文本文件数据 |
| BufferedWriter | 缓冲字符输出流 | Unicode码元 | 是 | 提高写入文本文件数据的效率 |

**说明**

* 操作基本单位：字节流操作的基本单元为字节，字符流操作的基本单元为Unicode码元。
* 是否使用缓冲区：字节流默认不使用缓冲区，字符流使用缓冲区。
* 使用场景：字节流可以读取任何格式的文件数据，字符流可以读取文本文件数据。

**补充说明**

* 除了上述类之外，Java IO 类库还提供了一些其他的流类，例如：
    * 序列化流：用于将对象序列化为字节流或从字节流中反序列化对象。
    * 转换流：用于将一种格式的数据转换为另一种格式的数据。
    * 网络流：用于进行网络通信。

* 在实际使用中，可以根据具体的需求选择合适的流类。

## BIO的使用 #标题/TODO
1. [[字节流拷贝|字节流拷贝]]
2. [[字符流拷贝|字符流拷贝]]

## BIO，NIO，AIO 三者间的区别
bio：传统的Java I/O操作，同步且阻塞IO。
nio：JDK1.4开始支持，同步阻塞或同步非阻塞IO，tomcat7
aio(nio.2)：JDK7开始支持，异步非阻塞IO，tomcat9

## NIO
1. 解决c10k，c10m问题
2. 非阻塞是采用了多路复用机制，实现同步非阻塞
3. 注册selector，监听其中的事件
4. 当触发事件后，执行后操作
5. 监听机制的实现依赖操作系统，具体的方法是epoll_create,epoll_wait,epoll_ctl
   1. 不同系统下nio的实现是不一样的,包括Sunos linux 和windows
6. 当并发数不高时与bio性能差异不大
7. NIO并没有完全屏蔽平台差异
8. 更高级的IO函数，Zero Copy

## AIO
与NIO不同，当进行读写操作时，只须直接调用API的read或write方法即可。这两种方法均为异步的，
对于读操作而言，当有流可读取时，操作系统会将可读的流传入read方法的缓冲区，并通知应用程序；
对于写操作而言，当操作系统将write方法传递的流写入完毕时，操作系统主动通知应用程序。

## 这种写法自动关流
```
try (FileOutputStream fileOut = new FileOutputStream("map.bin");
    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
    objectOut.writeObject(map);
} catch (IOException e) {
}
```

## 文本的兼容性不好，比如双引号的输出就不是很一致
1. 使用二进制进行写入

## 参考资料
1. google：[gemini](https://gemini.google.com/app)