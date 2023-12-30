## 安装
```
  npm install axios --save
```

```
  axios.get('https://api.example.com/data')
      .then(response => {
        this.responseData = response.data;
      })
      .catch(error => {
        console.error('Error fetching data', error);
      });
```

```
  axios.post('https://api.example.com/post-endpoint', this.postData)
      .then(response => {
        this.responseData = response.data;
        // 处理响应数据
      })
      .catch(error => {
        console.error('Error sending data', error);
        // 处理错误
      });

```
## 使用代理处理跨域问题
```
  devServer: {
    proxy: {
      '/api': {
        target: 'http://yourbackenddomain.com',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
```


