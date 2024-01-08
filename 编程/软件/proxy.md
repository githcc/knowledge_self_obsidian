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

## 使用PAC
   ```
   function FindProxyForURL(url, host) {
     // 直连本地网络
     if (isPlainHostName(host) ||
         shExpMatch(host, "*.local") ||
         isInNet(dnsResolve(host), "10.0.0.0", "255.0.0.0") ||
         isInNet(dnsResolve(host), "172.16.0.0", "255.240.0.0") ||
         isInNet(dnsResolve(host), "192.168.0.0", "255.255.0.0")) {
       return "DIRECT";
     }
   
     // 使用代理服务器访问GitHub
     if (dnsDomainIs(host, "github.com")) {
       return "PROXY ip:port"; // 更换为你的代理地址和端口
     }
   
     // 默认情况下直接连接
     return "DIRECT";
   }
   ```

## 使用jsDelivr代理
1. 将内容放到github
2. 在github发布release
3. 通过jsDelivr引用资源，https://cdn.jsdelivr.net/gh/你的用户名/你的仓库名@发布的版本号/文件路径
4. github有时被墙，这就体现了jsDelivr的优势，但jsDelivr有时也会被墙

## OpenAI API 免代理
1. [OpenAI API 代理](https://www.openai-proxy.com/)
   1. 之前请求报文被限制为1M，音频转文字接口可能会调用失败，其它场景还是不错的
2. 中转host
   转发Host1: https://api.chatanywhere.tech (国内中转，延时更低，host1和host2二选一)
   转发Host2: https://api.chatanywhere.com.cn (国内中转，延时更低，host1和host2二选一)
   转发Host3: https://api.chatanywhere.cn (国外使用,国内需要全局代理)

## gemini 代理
1. proxy-googleapis.vercel.app

## 其它
1. 用国内cdn需要备案，可以用对象存储进行替换，不过价格就贵了许多

## proxies
### 不走代理，特地加了微软的
```
localhost;127.*;10.*;172.16.*;172.17.*;172.18.*;172.19.*;172.20.*;172.21.*;172.22.*;172.23.*;172.24.*;172.25.*;172.26.*;172.27.*;172.28.*;172.29.*;172.30.*;172.31.*;192.168.*;221.194.*
```

### 网站
1. 清理别人的预设，留出漏网之鱼
2. 小众专用
   ```
     - DOMAIN-SUFFIX,parsevideo.com,📲 电报信息
     - DOMAIN-SUFFIX,arthub.ai,📲 电报信息
     - DOMAIN-SUFFIX,github.io,📲 电报信息
     - DOMAIN-SUFFIX,cloudflare.com,📲 电报信息
   ```
3. gate走coin
   ```
     - DOMAIN-SUFFIX,gate.io, ฿ coin
     - DOMAIN-SUFFIX,gatedata.org,฿ coin
     - DOMAIN-SUFFIX,gateio.services,฿ coin
     - DOMAIN-SUFFIX,gatetrace.com,฿ coin
     - DOMAIN-SUFFIX,gateimg.com,฿ coin
     - DOMAIN-SUFFIX,gateio.live,฿ coin
     - DOMAIN-SUFFIX,201704.xyz,฿ coin
   ```
4. copilot走coin
   ```
     - DOMAIN-SUFFIX,githubcopilot.com, ฿ coin
   ```
5. intellij走国外媒体
   ```
     - DOMAIN-SUFFIX,jetbrains.com,🌍 国外媒体
     - DOMAIN-SUFFIX,intellij.net,🌍 国外媒体
     - DOMAIN-SUFFIX,google.com,🌍 国外媒体
   ```
6. meta走国外媒体
   ```
     - DOMAIN-SUFFIX,meta.com,🌍 国外媒体
   ```
7. openai走gpt
   ```
     - DOMAIN-SUFFIX,openai.com,🤖 gpt
     - DOMAIN-SUFFIX,openaiapi-site.azureedge.net,🤖 gpt
     - DOMAIN-SUFFIX,azurefd.net,🤖 gpt
   ```
8. 禁止联网
   ```
   - DOMAIN-SUFFIX,wps.cn,🍃 应用净化
   - DOMAIN-SUFFIX,kdocs.cn,🍃 应用净化
   ```
### rule
1. 📲 电报信息 走自动选择，速度快
2.  ฿ coin 走新加坡，速度快，固定地区
3. 🌍 国外媒体 走美国，固定地区
4. 🤖 gpt 走南非，地区要求极高
5. 🍃 应用净化 REJECT

### 其它
1. 不想使用wps的联网功能可以把wpscloudsvr.exe 删除

## 参考资料
1. 知乎:
    1. [jsDelivr+Github 实现免费CDN加速](https://zhuanlan.zhihu.com/p/346643522)
2. github:
   1. [GPT_API_free](https://github.com/chatanywhere/GPT_API_free)
   2. [proxy-googleapis](https://github.com/githcc/proxy-googleapis)
3. 博客：
   1. [Vercel反向代理Google PaLM](https://simonmy.com/posts/%E4%BD%BF%E7%94%A8vercel%E5%8F%8D%E5%90%91%E4%BB%A3%E7%90%86google-palm-api.html)