package com.duoduo.common.config;

import lombok.Data;

/**
 * @author lixiaolong
 * @create 2019-05-06 11:27
 */
@Data
public class RequestItem {

    /**
     * 请求地址
     */
    private String url;

    /**
     * 1.post
     * 2.get
     */
    private Integer method;


}
