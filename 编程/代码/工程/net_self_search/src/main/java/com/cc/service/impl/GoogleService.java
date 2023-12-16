package com.cc.service.impl;

import com.cc.service.ParseInterface;
import com.cc.utils.HttpUtil;
import com.cc.vo.Search;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class GoogleService implements ParseInterface {
    public List<Search> parseHtml(String query) throws IOException {

        // 发起HTTP GET请求
        String response = HttpUtil.sendHttpGetRequest("google", query);
        System.out.println(response); //谷歌报timeout
        List<Search> lists = new ArrayList<>();
        return lists;
    }
}