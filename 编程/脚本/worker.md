## cf workder
```
export default {
  fetch(request) {
    const requestUrl = new URL(request.url)
    requestUrl.host = "proxy-googleapis.vercel.app"
    requestUrl.searchParams.append('key', '<api-key>')
    request = new Request(requestUrl, request)
    return fetch(request)
   }
 }
```