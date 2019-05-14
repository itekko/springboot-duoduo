package com.duoduo.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lixiaolong
 * @company 深圳和而泰智能控制股份有限公司
 * @create 2019-05-06 10:08
 */
@Data
@Component
@ConfigurationProperties(prefix = "duoduo.baidu")
public class BaiduProperties {

    private Map<String,Object> ocr;

    private Map<String,Object> token;

    private Map<String,RequestItem> urlMap;

}
