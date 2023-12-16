package com.cc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    public static HashMap<String, String> engineURL;
    public static HashMap<String, String> engineReferer;
    public static HashMap<String, String> engineCookie;

    static {
        engineURL = new HashMap<>();
        engineURL.put("bing", "https://www.bing.com/search?q=");
        engineURL.put("sogou", "https://www.sogou.com/web?ie=utf8&query=");
        engineURL.put("yandex", "https://yandex.com/search/?text=");
//        map.put("duckduckgo", "https://duckduckgo.wyswydx.workers.dev/?q=");
//        map.put("google", "https://www.google.com/search?q=");
//        map.put("bing", "https://www.bing.com/search?q=");
//        map.put("baidu", "https://www.baidu.com/s?wd=");
        //这种要在前端实现
//        map.put("favorites", "edge://favorites/?q=");
//        map.put("history", "edge://history/all?q=");
//        map.put("syncedTabs", "edge://history/syncedTabs?q=");

        engineReferer = new HashMap<>();
        engineReferer.put("bing", "https://www.bing.com");
        engineReferer.put("sogou", "https://www.sogou.com");
        engineReferer.put("yandex", "https://yandex.com");


        engineCookie = new HashMap<>();
        engineCookie.put("bing", "");
        engineCookie.put("sogou", "");
        engineCookie.put("yandex", "");
    }

    public static String sendHttpGetRequest(String engine, String query) throws IOException {
        query = URLEncoder.encode(query, StandardCharsets.UTF_8);
        URL url = new URL(engineURL.get(engine).concat(query));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0");
        conn.setRequestProperty("Referer", engineReferer.get(engine));
        conn.setRequestProperty("Cookie", engineCookie.get(engine));

        int responseCode = conn.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            Map<String, List<String>> headerFields = conn.getHeaderFields();
            if (headerFields.containsKey("Set-Cookie")) {
                List<String> cookies = headerFields.get("Set-Cookie");
                // Process or store the cookies as needed
                // For example, you can join the cookies into a single string
                String cookieString = String.join("; ", cookies);
                // Return both the response and the extracted cookies
                engineCookie.put("Cookie",cookieString);
                System.out.println(cookieString);
            }
            conn.disconnect();
            return response.toString();
        } else {
            throw new IOException("HTTP请求未成功，响应码：" + responseCode);
        }
    }
}
