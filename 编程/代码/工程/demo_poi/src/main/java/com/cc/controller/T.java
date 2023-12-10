package com.cc.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.cc.vo.User;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class T {
    @GetMapping("download")
    public void downTemplate(HttpServletResponse response) throws IOException {
        // 表头
        Map<String, String> map = new HashMap<>();
        map.put("name", "名字");
        map.put("age", "年龄");
//Unfortunately, AI Assistant is currently unavailable in your location
        // 文件名
        String fileName = "用户列表.xlsx";
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replace("+", "%20");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);

        // 列表
        List<User> list = new ArrayList<>();
        list.add(new User("张三",18));
        list.add(new User("李四",28));

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:template.xlsx");
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        try (ExcelWriter writer = EasyExcel.write(response.getOutputStream()).withTemplate(resource.getInputStream()).build()) {
            WriteSheet sheet = EasyExcel.writerSheet().build();
            writer.fill(map, sheet);
            writer.fill(list, fillConfig, sheet);
        }
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

}
