```
<!DOCTYPE html>
<html>
<head>
    <title>SSE Example</title>
</head>
<body>
<h1>Server-Sent Events Example</h1>
<div id="sseData"></div>

<script>
    // 创建 EventSource 对象，与服务器建立连接
    const eventSource = new EventSource('server.php');

    // 监听消息的到达
    eventSource.onmessage = function(event) {
        const newData = event.data;
        // 将收到的数据更新到页面上
        document.getElementById('sseData').innerHTML += `<p>${newData}</p>`;
    };

    // 处理连接出现问题的情况
    eventSource.onerror = function(error) {
        console.error('SSE encountered an error: ', error);
        eventSource.close();
    };
</script>
</body>
</html>
```