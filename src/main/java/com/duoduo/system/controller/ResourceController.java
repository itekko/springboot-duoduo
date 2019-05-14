package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duoduo.common.annotation.Log;
import com.duoduo.system.entity.Resource;
import com.duoduo.system.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.api.ApiController;

/**
 * <p>
 * 系统资源表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */

@RestController
@RequestMapping("/system/resource")
public class ResourceController extends ApiController {


    @Autowired
    private IResourceService resourceService;


    /**
     * 查询
     * @return
     */
    @Log("系统查询")
    @GetMapping("/{id}")
    public R<Resource> get(@PathVariable("id") Long id){
        return success(resourceService.getById(id));
    }

    /**
     * 系统列表查询
     * @return
     */
    @Log("系统列表查询")
    @GetMapping
    public R<IPage<Resource>> list(){
        Page<Resource> page = new Page<>(1, 5);
        IPage<Resource> resourceIPage = resourceService.page(page);
        return success(resourceIPage);
    }

    /**
     * 新增
     * @param resource
     * @return
     */
    @Log("系统新增")
    @PostMapping
    public R add(@RequestBody Resource resource){
        return success(resourceService.save(resource));
    }



    /**
     * 修改
     * @param id
     * @param resource
     * @return
     */
    @Log("系统修改")
    @PutMapping("/{id}")
    public R update(@PathVariable("id") Long id, @RequestBody Resource resource){
        return success(resourceService.updateById(resource));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Log("系统删除")
    @DeleteMapping("/{id}")
    public R remove(@PathVariable("id") Long id){
        return success(resourceService.removeById(id));
    }
}
