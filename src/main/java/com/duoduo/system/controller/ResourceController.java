package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.Resource;
import com.duoduo.system.service.IResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统资源表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@RestController
@Api("/system/resource")
@RequestMapping("/system/resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    /**
     * 系统资源表查询
     * @return
     */
    @Log("系统资源表查询")
    @GetMapping("/{id}")
    @ApiOperation("系统资源表查询")
    public Result<Resource> get(@PathVariable("id") Long id){
        return Result.ok(resourceService.getById(id));
    }

    /**
     * 系统资源表列表查询(分页)
     * @return
     */
    @Log("系统资源表列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("系统资源表列表查询(分页)")
    public Result<IPage<Resource>> page(@RequestBody Resource resource){
        Page<Resource> page = new Page<>(resource.getCurrent(), resource.getSize());
        return Result.ok(resourceService.page(page,new QueryWrapper<>(resource)));
    }

    /**
     * 系统资源表列表查询
     * @return
     */
    @Log("系统资源表列表查询")
    @GetMapping("/list")
    @ApiOperation("系统资源表列表查询")
    public Result<List<Resource>> list(@RequestBody Resource resource){
        return Result.ok(resourceService.list(new QueryWrapper<>(resource)));
    }

    /**
     * 新增
     * @param resource
     * @return
     */
    @Log("系统资源表新增")
    @PostMapping
    @ApiOperation("系统资源表新增")
    public Result add(@RequestBody Resource resource){
        return Result.ok(resourceService.save(resource));
    }



    /**
     * 修改
     * @param id
     * @param resource
     * @return
     */
    @Log("系统资源表修改")
    @PutMapping("/{id}")
    @ApiOperation("系统资源表修改")
    public Result update(@PathVariable("id") Long id, @RequestBody Resource resource){
        return Result.ok(resourceService.updateById(resource));
    }

    /**
     * 系统资源表删除
     * @param id
     * @return
     */
    @Log("系统资源表删除")
    @DeleteMapping("/{id}")
    @ApiOperation("系统资源表删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(resourceService.removeById(id));
    }

    /**
     * 系统资源树
     * @return
     */
    @Log("系统资源树")
    @GetMapping("/tree")
    @ApiOperation("系统资源树")
    public Result<List<Resource>> tree(){
        return Result.ok(resourceService.tree());
    }



}
