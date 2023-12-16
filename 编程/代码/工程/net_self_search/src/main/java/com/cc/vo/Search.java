package com.cc.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Search {
    private String URL;
    private String description;
}
