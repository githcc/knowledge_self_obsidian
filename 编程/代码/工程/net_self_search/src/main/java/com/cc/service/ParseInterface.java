package com.cc.service;

import com.cc.vo.Search;

import java.io.IOException;
import java.util.List;

public interface ParseInterface {
    // 对html字符串的报文进行解析为实体类
    List<Search> parseHtml(String html) throws IOException;
}
