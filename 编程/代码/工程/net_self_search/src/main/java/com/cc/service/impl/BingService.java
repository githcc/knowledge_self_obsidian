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
public class BingService implements ParseInterface {

    public List<Search> parseHtml(String query) throws IOException {

        // 发起HTTP GET请求
        String response = HttpUtil.sendHttpGetRequest("bing", query);
        Document doc = Jsoup.parse(response);

        // 提取所有的li元素
        Elements liElements = doc.select("li.b_algo");

        List<Search> lists = new ArrayList<>();
        for (Element li : liElements) {
            // 提取链接
            Element link = li.selectFirst("a.tilk");
            String linkUrl = ObjectUtils.isEmpty(link)?"":link.attr("href");

            // 提取描述
            Element description = li.selectFirst("p.b_lineclamp4");
            String descriptionText = ObjectUtils.isEmpty(link)?"":description.text();

            lists.add(Search.builder().URL(linkUrl).description(descriptionText).build());
        }
        return lists;
    }
}
