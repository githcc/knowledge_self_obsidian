## 网站
1. 常见网站走OpenAI
   ```
     - 'DOMAIN-SUFFIX,google.com,OpenAI'
     - 'DOMAIN-SUFFIX,google.dev,OpenAI'
     - 'DOMAIN-SUFFIX,googleusercontent.com,OpenAI'
     - 'DOMAIN-SUFFIX,googleapis.com,OpenAI'
     - 'DOMAIN-SUFFIX,googlevideo.com,OpenAI'
     - 'DOMAIN-SUFFIX,withyoutube.com,OpenAI'
     - 'DOMAIN-SUFFIX,youtu.be,OpenAI'
     - 'DOMAIN-SUFFIX,youtube.com,OpenAI'
     - 'DOMAIN-SUFFIX,youtubeeducation.com,OpenAI'
     - 'DOMAIN-SUFFIX,youtubegaming.com,OpenAI'
     - 'DOMAIN-SUFFIX,youtubekids.com,OpenAI'
     - 'DOMAIN-SUFFIX,youtube-nocookie.com,OpenAI'
     - 'DOMAIN-SUFFIX,yt.be,OpenAI'
     - 'DOMAIN-SUFFIX,ytimg.com,OpenAI'
     - 'DOMAIN,youtubei.googleapis.com,OpenAI'
     - 'DOMAIN,yt3.ggpht.com,OpenAI'
     - 'DOMAIN-SUFFIX,azureedge.net,OpenAI'
     - 'DOMAIN-SUFFIX,microsoft.com,OpenAI'
     - 'DOMAIN-SUFFIX,twitter.com,OpenAI'
     - 'DOMAIN-SUFFIX,twimg.com,OpenAI'
     - 'DOMAIN-SUFFIX,t.co,OpenAI'
     - 'DOMAIN-SUFFIX,docker.com,OpenAI'
     - 'DOMAIN-SUFFIX,jetbrains.com,OpenAI'
     - 'DOMAIN-SUFFIX,intellij.net,OpenAI'
     - 'DOMAIN-SUFFIX,githubcopilot.com, OpenAI'
     - 'DOMAIN-SUFFIX,openai.com, OpenAI'
     - 'DOMAIN-SUFFIX,oaistatic.com, OpenAI'
     - 'DOMAIN-SUFFIX,statsigapi.net, OpenAI'
     - 'DOMAIN-SUFFIX,gravatar.com, OpenAI'
     - 'DOMAIN-SUFFIX,tweetdeck.com,OpenAI'
     - 'DOMAIN-SUFFIX,twimg.co,OpenAI'
     - 'DOMAIN-SUFFIX,twimg.com,OpenAI'
     - 'DOMAIN-SUFFIX,twitpic.com,OpenAI'
     - 'DOMAIN-SUFFIX,twitter.com,OpenAI'
     - 'DOMAIN-SUFFIX,github.com,OpenAI'
     - 'DOMAIN-SUFFIX,vimeo.com,OpenAI'
     - 'DOMAIN-SUFFIX,github.io,OpenAI'
     - 'DOMAIN-SUFFIX,cloudflare.com,OpenAI'
     - 'DOMAIN-SUFFIX,githubusercontent.com,OpenAI'
     - 'DOMAIN-SUFFIX,soundcloud.com,OpenAI'
     - 'DOMAIN-KEYWORD,-spotify-com,OpenAI'
     - 'DOMAIN-SUFFIX,spotify.com,OpenAI'
     - 'DOMAIN-SUFFIX,spotifycdn.com,OpenAI'
     - 'DOMAIN-SUFFIX,spoti.fi,OpenAI'
     - 'DOMAIN-SUFFIX,sonatype.com,OpenAI'
     - 'DOMAIN-SUFFIX,bing.com,OpenAI'
     - 'DOMAIN-SUFFIX,poe.com,OpenAI'
     - 'DOMAIN-SUFFIX,scdn.co,OpenAI'
   ```
2. 小众专用走OpenAI
   ```
     - 'DOMAIN-SUFFIX,auth0.com,OpenAI'
     - 'DOMAIN-SUFFIX,parsevideo.com,OpenAI'
     - 'DOMAIN-SUFFIX,arthub.ai,OpenAI'
     - 'DOMAIN-SUFFIX,apkcombo.com,OpenAI'
     - 'DOMAIN-SUFFIX,androidcombo.com,OpenAI'
     - 'DOMAIN-SUFFIX,githubassets.com,OpenAI'
     - 'DOMAIN-SUFFIX,zhongziso365.xyz,OpenAI'
     - 'DOMAIN-SUFFIX,zendesk.com,OpenAI'
     - 'DOMAIN-SUFFIX,mynoise.net,OpenAI'
   ```
3. gate走OpenAI
   ```
     - 'DOMAIN-SUFFIX,gate.io, OpenAI'
     - 'DOMAIN-SUFFIX,gatedata.org,OpenAI'
     - 'DOMAIN-SUFFIX,gateio.services,OpenAI'
     - 'DOMAIN-SUFFIX,gatetrace.com,OpenAI'
     - 'DOMAIN-SUFFIX,gateimg.com,OpenAI'
     - 'DOMAIN-SUFFIX,gateio.live,OpenAI'
     - 'DOMAIN-SUFFIX,201704.xyz,OpenAI'
   ```
4. pikPak走OpenAI
   ```
     - 'IP-CIDR,111.230.189.174/8,OpenAI'
     - 'IP-CIDR,202.118.1.130/8,OpenAI'
     - 'IP-CIDR,202.112.31.197/8,OpenAI'
     - 'IP-CIDR,157.148.61.140/8,OpenAI'
     - 'IP-CIDR,139.199.214.202/8,OpenAI'
     - 'IP-CIDR,43.134.111.34/8,OpenAI'
     - 'IP-CIDR,47.236.10.67/8,OpenAI'
     - 'DOMAIN-SUFFIX,jsd.nn.ci,OpenAI'
     - 'DOMAIN-SUFFIX,bugsnag.com,OpenAI'
     - 'DOMAIN-SUFFIX,unpkg.com,OpenAI'
     - 'DOMAIN-SUFFIX,ycyup.cn,OpenAI'
     - 'DOMAIN-SUFFIX,immersivetranslate.com,OpenAI'
     - 'DOMAIN-SUFFIX,bootstrapcdn.com,OpenAI'
     - 'DOMAIN-SUFFIX,ip.me,OpenAI'
     - 'DOMAIN-SUFFIX,mypikpak.com,OpenAI'
   ```
5. meta走Meta
   ```
     - 'DOMAIN-SUFFIX,meta.com,Meta'
     - 'DOMAIN-SUFFIX,alicdn.com,Meta'
     - 'DOMAIN-SUFFIX,xx.fbcdn.net,Meta'
     - 'DOMAIN-SUFFIX,wps.cn,REJECT'
     - 'DOMAIN-SUFFIX,kdocs.cn,REJECT'
     - 'DOMAIN-SUFFIX,kakao.com,REJECT'
     - 'DOMAIN-SUFFIX,edge4k.com,REJECT'
     - 'DOMAIN-SUFFIX,pepsicola.cc,REJECT'
     - 'DOMAIN-SUFFIX,xmind.cn,REJECT'
     - 'DOMAIN-SUFFIX,xmind.net,REJECT'
   ```
6. 直链
   ```
     - 'IP-CIDR,119.91.23.0/8,DIRECT'
     - 'DOMAIN-KEYWORD,localhost,DIRECT'
   ```

### rule
1. 直链 走pac
2. OpenAI 走新加坡，速度快，固定地区
3. Meta 走美国，固定地区
