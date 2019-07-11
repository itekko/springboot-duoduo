package com.duoduo.system.controller;

import com.duoduo.system.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author lixiaolong
 * @create 2019-06-03 14:54
 */
@Controller
public class IndexController {

    @Autowired
    private IResourceService resourceService;

    @GetMapping("/index")
    public String index(Map<String,Object> params){
        params.put("tree",resourceService.tree());
        return "index.html";
    }
}
