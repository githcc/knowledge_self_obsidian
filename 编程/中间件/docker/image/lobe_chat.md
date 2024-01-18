docker run -d -p 3210:3210 \
-e OPENAI_API_KEY=sk-xxxx \
-e OPENAI_PROXY_URL=https://api.openai-proxy.com/v1 \
-e ACCESS_CODE=cc \
--name lobe-chat \
lobehub/lobe-chat