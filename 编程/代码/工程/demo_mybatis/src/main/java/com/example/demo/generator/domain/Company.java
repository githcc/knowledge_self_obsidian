package com.example.demo.generator.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName company
 */
@Data
public class Company implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司法人
     */
    private Integer uId;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 标注 1-删除 0-正常
     */
    private Integer deleteFlag;

    /**
     * 插入时间
     */
    private LocalDateTime insertTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}