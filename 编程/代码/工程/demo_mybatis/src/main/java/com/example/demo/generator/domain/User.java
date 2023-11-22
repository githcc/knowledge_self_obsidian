package com.example.demo.generator.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

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