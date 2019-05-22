package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.Area;
import com.duoduo.system.service.IAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统地区表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@RestController
@Api("/system/area")
@RequestMapping("/system/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    /**
     * 系统地区表查询
     * @return
     */
    @Log("系统地区表查询")
    @GetMapping("/{id}")
    @ApiOperation("系统地区表查询")
    public Result<Area> get(@PathVariable("id") Long id){
        return Result.ok(areaService.getById(id));
    }

    /**
     * 系统地区表列表查询(分页)
     * @return
     */
    @Log("系统地区表列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("系统地区表列表查询(分页)")
    public Result<IPage<Area>> page(@RequestBody Area area){
        Page<Area> page = new Page<>(area.getCurrent(), area.getSize());
        return Result.ok(areaService.page(page,new QueryWrapper<>(area)));
    }

    /**
     * 系统地区表列表查询
     * @return
     */
    @Log("系统地区表列表查询")
    @GetMapping("/list")
    @ApiOperation("系统地区表列表查询")
    public Result<List<Area>> list(@RequestBody Area area){
        return Result.ok(areaService.list(new QueryWrapper<>(area)));
    }

    /**
     * 新增
     * @param area
     * @return
     */
    @Log("系统地区表新增")
    @PostMapping
    @ApiOperation("系统地区表新增")
    public Result add(@RequestBody Area area){
        return Result.ok(areaService.save(area));
    }



    /**
     * 修改
     * @param id
     * @param area
     * @return
     */
    @Log("系统地区表修改")
    @PutMapping("/{id}")
    @ApiOperation("系统地区表修改")
    public Result update(@PathVariable("id") Long id, @RequestBody Area area){
        return Result.ok(areaService.updateById(area));
    }

    /**
     * 系统地区表删除
     * @param id
     * @return
     */
    @Log("系统地区表删除")
    @DeleteMapping("/{id}")
    @ApiOperation("系统地区表删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(areaService.removeById(id));
    }

}
