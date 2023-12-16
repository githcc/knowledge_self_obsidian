package com.cc.service.impl;

import com.cc.service.ParseInterface;
import com.cc.utils.HttpUtil;
import com.cc.vo.Search;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class BaiduService implements ParseInterface {
    public List<Search> parseHtml(String query) throws IOException {

        // 发起HTTP GET请求
        String response = HttpUtil.sendHttpGetRequest("baidu", query);
        System.out.println(response); //百度安全验证需要特殊处理
        List<Search> lists = new ArrayList<>();
        return lists;
    }
}