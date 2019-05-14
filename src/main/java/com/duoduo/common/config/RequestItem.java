package com.duoduo.common.config;

import lombok.Data;

/**
 * @author lixiaolong
 * @company 深圳和而泰智能控制股份有限公司
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
