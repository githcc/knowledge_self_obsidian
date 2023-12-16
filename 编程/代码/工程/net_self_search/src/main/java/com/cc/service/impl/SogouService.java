package com.cc.service.impl;

import com.cc.service.ParseInterface;
import com.cc.utils.HttpUtil;
import com.cc.vo.Search;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Service
public class SogouService implements ParseInterface {
    public List<Search> parseHtml(String query) throws IOException {

        // 发起HTTP GET请求
        String response = HttpUtil.sendHttpGetRequest("sogou", query);
        Document doc = Jsoup.parse(response);

        // 获取所有类名为 "vr-title" 的元素
        Elements titles = doc.select(".vr-title");

        List<Search> lists = new ArrayList<>();
        for (Element title : titles) {
            Element link = title.select("a").first();
            String linkHref = ObjectUtils.isEmpty(link)?"":link.attr("href");
            String Text = ObjectUtils.isEmpty(link)?"":link.text();
            lists.add(Search.builder().URL(linkHref).description(Text).build());
        }
        return lists;
    }
}