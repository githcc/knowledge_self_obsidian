```
<!DOCTYPE html>
<html>
<head>
    <title>Fetch MP4 Video</title>
</head>
<body style="text-align: center">
        <div id="videoContainer"></div>

    <script>
        const url = 'E01.mp4'; // 替换为你要请求的 MP4 资源的 URL
        const headers = {
            'Authorization': 'Bearer <token>', // 自定义的授权头部
            'Custom-Header': 'Custom-Value' // 其他自定义头部
        };

        fetch(url, {
            method: 'GET',
            headers: headers
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.blob(); // 将响应体作为 Blob 对象返回
        })
        .then(blob => {
            const video = document.createElement('video');
            const videoURL = URL.createObjectURL(blob);
            video.src = videoURL;
            video.controls = true; // 添加视频控制器
            document.getElementById('videoContainer').appendChild(video);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    </script>
</body>
</html>

```