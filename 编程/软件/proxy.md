## 使用cloudflare代理
1. 使用[cloudflare](https://dash.cloudflare.com/login)的worker
   ```
   export default {
    fetch(request) {
       const requestUrl = new URL(request.url)
       requestUrl.host = "target.com"
       request = new Request(requestUrl, request)
       // 设置请求头
       request.headers.set('header', 'value')
       return fetch(request)
     }
   }
   ```
2. 配置cloudflare的Custom Domains
3. 通过访问自己配置的Domains
4. 一般情况不需要开会员，开会员在请求量可以增加，但速度相差不大，每日10w请求一般够用
5. 可以在worker内添加加密逻辑，未尝试

## 使用jsDelivr代理
1. 将内容放到github
2. 在github发布release
3. 通过jsDelivr引用资源，https://cdn.jsdelivr.net/gh/你的用户名/你的仓库名@发布的版本号/文件路径
4. github有时被墙，这就体现了jsDelivr的优势，但jsDelivr有时也会被墙

## OpenAI API 代理
1. [OpenAI API 代理](https://www.openai-proxy.com/)
2. 之前请求报文被限制为1M，音频转文字接口可能会调用失败，其它场景还是不错的

## 其它
1. 用国内cdn需要备案，可以用对象存储进行替换，不过价格就贵了许多

## proxies
### 网站
1. 清理别人的预设，留出漏网之鱼
2. gate走电报信息
   ```
     - DOMAIN-SUFFIX,gate.io, 📲 电报信息
     - DOMAIN-SUFFIX,gatedata.org,📲 电报信息
     - DOMAIN-SUFFIX,gateio.services,📲 电报信息
     - DOMAIN-SUFFIX,gatetrace.com,📲 电报信息
     - DOMAIN-SUFFIX,gateimg.com,📲 电报信息
     - DOMAIN-SUFFIX,gateio.live,📲 电报信息
   ```
3. copilot走电报
   ```
     - DOMAIN-SUFFIX,githubcopilot.com, 📲 电报信息
   ```
3. intellij走国外媒体
   ```
     - DOMAIN-SUFFIX,jetbrains.com,🌍 国外媒体
     - DOMAIN-SUFFIX,intellij.net,🌍 国外媒体
   ```
4. meta走国外媒体
   ```
     - DOMAIN-SUFFIX,meta.com,🌍 国外媒体
   ```
5. openai走苹果服务
   ```
     - DOMAIN-SUFFIX,openai.com,🍎 苹果服务
     - DOMAIN-SUFFIX,openaiapi-site.azureedge.net,🍎 苹果服务
     - DOMAIN-SUFFIX,azurefd.net,🍎 苹果服务
   ```
### rule
1. 📲 电报信息 走新加坡，速度快
2. 🌍 国外媒体 走美国，地区要求高
3. 🌍 国外媒体 走南非，地区要求极高

## 参考资料
1. 知乎:
    1. [jsDelivr+Github 实现免费CDN加速](https://zhuanlan.zhihu.com/p/346643522)