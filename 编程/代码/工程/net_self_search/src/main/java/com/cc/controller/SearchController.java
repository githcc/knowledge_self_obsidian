package com.cc.controller;

import com.cc.service.impl.*;
import com.cc.utils.HttpUtil;
import com.cc.vo.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    BingService bingService;

    @Autowired
    BaiduService baiduService;

    @Autowired
    SogouService sogouService;

    @Autowired
    GoogleService googleService;

    @Autowired
    YandexService yandexService;

    @GetMapping("baidu")
    public Object baidu(@RequestParam("query")String query) {
        try {
            // 使用Jsoup解析HTML并提取文本内容并返回
            return baiduService.parseHtml(query);

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Search> searches = new ArrayList<>();
        return searches.add(Search.builder().URL("bing.com").description("发生异常，没有内容").build());
    }

    @GetMapping("google")
    public Object google(@RequestParam("query")String query) {
        try {
            // 使用Jsoup解析HTML并提取文本内容并返回
            return googleService.parseHtml(query);

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Search> searches = new ArrayList<>();
        return searches.add(Search.builder().URL("bing.com").description("发生异常，没有内容").build());
    }

    @GetMapping("bing")
    public Object bing(@RequestParam("query")String query) {
        try {
            // 使用Jsoup解析HTML并提取文本内容并返回
            return bingService.parseHtml(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Search> searches = new ArrayList<>();
        return searches.add(Search.builder().URL(HttpUtil.engineReferer.get("bing")).description("发生异常，没有内容").build());
    }

    @GetMapping("sogou")
    public Object sogou(@RequestParam("query")String query) {
        try {
            // 使用Jsoup解析HTML并提取文本内容并返回
            return sogouService.parseHtml(query);

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Search> searches = new ArrayList<>();
        return searches.add(Search.builder().URL(HttpUtil.engineReferer.get("sogou")).description("发生异常，没有内容").build());
    }

    @GetMapping("yandex")
    public Object yandex(@RequestParam("query")String query) {
        try {
            // 使用Jsoup解析HTML并提取文本内容并返回
            return yandexService.parseHtml(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Search> searches = new ArrayList<>();
        return searches.add(Search.builder().URL(HttpUtil.engineReferer.get("yandex")).description("发生异常，没有内容").build());
    }
}
