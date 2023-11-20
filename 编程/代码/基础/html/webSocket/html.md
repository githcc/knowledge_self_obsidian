```
<!DOCTYPE html>
<html>
<head>
  <title>WebSocket Example</title>
</head>
<body>
  <h1>WebSocket Example</h1>
  <div id="messages"></div>
  <form id="messageForm">
    <input type="text" id="messageInput" placeholder="Type a message...">
    <button type="submit">Send</button>
  </form>

  <script>
    const messagesElement = document.getElementById('messages');
    const messageForm = document.getElementById('messageForm');
    const messageInput = document.getElementById('messageInput');

    // 创建 WebSocket 连接
    const socket = new WebSocket('ws://localhost:8080'); // 替换成你的 WebSocket 服务器地址

    // 连接建立时执行
    socket.onopen = function(event) {
      console.log('WebSocket connection established.');
    };

    // 监听消息的到达
    socket.onmessage = function(event) {
      const newMessage = event.data;
      // 将收到的消息更新到页面上
      messagesElement.innerHTML += `<p>${newMessage}</p>`;
    };

    // 处理连接关闭的情况
    socket.onclose = function(event) {
      console.log('WebSocket connection closed.');
    };

    // 处理表单提交事件
    messageForm.addEventListener('submit', function(event) {
      event.preventDefault();
      const message = messageInput.value;
      // 发送消息到服务器
      socket.send(message);
      // 清空输入框
      messageInput.value = '';
    });
  </script>
</body>
</html>

```