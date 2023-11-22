```
<!DOCTYPE html>
<html>
<head>
  <title>AJAX Example</title>
</head>
<body>

<button onclick="makeRequest()">Make Request</button>

<script>
function makeRequest() {
  // 创建XMLHttpRequest对象
  var xhr = new XMLHttpRequest();

  // 配置请求，指定请求方法和URL
  xhr.open('GET', 'https://api.example.com/data', true);

  // 处理响应
  xhr.onload = function() {
    if (xhr.status >= 200 && xhr.status < 400) {
      // 请求成功，处理响应数据
      var data = JSON.parse(xhr.responseText);
      console.log(data);
    } else {
      // 请求失败
      console.error('Request failed');
    }
  };

  // 处理网络错误
  xhr.onerror = function() {
    console.error('Network error');
  };

  // 发送请求
  xhr.send();
}
</script>

</body>
</html>

```