```
<?php
header('Content-Type: text/event-stream');
header('Cache-Control: no-cache');

// 每隔一段时间发送一个消息
for ($i = 0; $i < 10; $i++) {
  echo "data: Message $i\n\n";
  // 强制数据刷新到客户端
  ob_flush();
  flush();
  // 等待一秒
  sleep(1);
}
?>
```