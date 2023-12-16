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
import java.util.ArrayList;
import java.util.List;


@Service
public class YandexService implements ParseInterface {
    public List<Search> parseHtml(String query) throws IOException {

        // 发起HTTP GET请求
        String response = HttpUtil.sendHttpGetRequest("yandex", query);
        Document doc = Jsoup.parse(response);

        // 提取所有的li元素
        Elements liElements = doc.select("li.serp-item");

        List<Search> lists = new ArrayList<>();
        for (Element li : liElements) {
            // 提取链接
            Element linkElement = li.selectFirst("a[href]");
            String link = ObjectUtils.isEmpty(linkElement)?"":linkElement.attr("href");

            // 提取描述
            Element descElement = li.selectFirst(".OrganicTextContentSpan");
            String description = ObjectUtils.isEmpty(descElement)?"":descElement.text();

            lists.add(Search.builder().URL(link).description(description).build());
        }
        return lists;
    }
}