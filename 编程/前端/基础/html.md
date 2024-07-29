## 其它
1. html的实体 &# xx;
2. 禁用js
    ```
    Object.defineProperty(navigator, 'webdriver', { get: () => false });
    ```
## h5的变化
1. 用于绘画的 canvas
2. 用于媒介回放的 video 和 audio
3. 对本地离线存储的更好的支持 localStorage 和 sessionStorage
4. 新的特殊内容元素，比如 article、footer、header、nav、section
5. 新的表单控件，比如 calendar、date、time、email、url、search

## 疑问
1. 设置图片加载模式

## h5
HTML5 是 HTML 的第五个主要版本，带来了许多新功能、API 和语法改进，以支持现代 Web 应用的开发。其变化和新增功能包括：

1. **语义化标签（Semantic Tags）：** 引入了一系列新的语义化标签（如`<header>`、`<footer>`、`<section>`、`<article>`等），更清晰地定义了文档的结构。

2. **多媒体支持（Multimedia Support）：** 提供了内置支持音频和视频的标签 `<audio>` 和 `<video>`，无需第三方插件即可在网页中嵌入音视频内容。

3. **Canvas 和 SVG：** 引入了 `<canvas>` 元素，使得通过 JavaScript 可以进行动态渲染图形，同时也提供了更强大的 SVG 支持，方便创建矢量图形。

4. **表单增强（Form Enhancements）：** 提供了新的表单元素和属性，例如日期选择器 `<input type="date">`、验证属性（如`required`、`pattern`等），以及更多输入类型。

5. **Web 存储（Web Storage）：** 提供了本地存储能力，包括 `localStorage` 和 `sessionStorage`，用于在客户端存储数据而无需使用 cookies。

6. **Web Workers 和消息传递（Web Workers & Messaging）：** 引入了 Web Workers，允许在后台运行脚本以提高性能，并通过消息传递与主线程通信。

7. **地理定位（Geolocation）：** 提供了用于获取用户位置信息的 API，可以通过 JavaScript 访问用户设备的地理位置。

8. **拖放 API（Drag and Drop API）：** 引入了原生的拖放 API，使得在网页中实现拖拽和放置变得更加容易。

9. **WebRTC（Web Real-Time Communication）：** 提供了实时通信的 API，支持浏览器之间直接进行音视频通话和数据传输。

10. **响应式 Web 设计的支持：** HTML5 为响应式网页设计提供了更多的支持，使得网页可以更好地适应不同设备和屏幕尺寸。

HTML5 的引入为 Web 开发带来了更多的功能和灵活性，使得开发者可以更轻松地创建丰富交互性、多媒体内容丰富的现代网页应用。