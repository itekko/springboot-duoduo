package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.Log;
import com.duoduo.system.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@RestController
@Api("/system/log")
@RequestMapping("/system/log")
public class LogController {

    @Autowired
    private ILogService logService;

    /**
     * 系统日志表查询
     * @return
     */
    @com.duoduo.common.annotation.Log("系统日志表查询")
    @GetMapping("/{id}")
    @ApiOperation("系统日志表查询")
    public Result<Log> get(@PathVariable("id") Long id){
        return Result.ok(logService.getById(id));
    }

    /**
     * 系统日志表列表查询(分页)
     * @return
     */
    @com.duoduo.common.annotation.Log("系统日志表列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("系统日志表列表查询(分页)")
    public Result<IPage<Log>> page(@RequestBody Log log){
        Page<Log> page = new Page<>(log.getCurrent(), log.getSize());
        return Result.ok(logService.page(page,new QueryWrapper<>(log)));
    }

    /**
     * 系统日志表列表查询
     * @return
     */
    @com.duoduo.common.annotation.Log("系统日志表列表查询")
    @GetMapping("/list")
    @ApiOperation("系统日志表列表查询")
    public Result<List<Log>> list(@RequestBody Log log){
        return Result.ok(logService.list(new QueryWrapper<>(log)));
    }

    /**
     * 新增
     * @param log
     * @return
     */
    @com.duoduo.common.annotation.Log("系统日志表新增")
    @PostMapping
    @ApiOperation("系统日志表新增")
    public Result add(@RequestBody Log log){
        return Result.ok(logService.save(log));
    }



    /**
     * 修改
     * @param id
     * @param log
     * @return
     */
    @com.duoduo.common.annotation.Log("系统日志表修改")
    @PutMapping("/{id}")
    @ApiOperation("系统日志表修改")
    public Result update(@PathVariable("id") Long id, @RequestBody Log log){
        return Result.ok(logService.updateById(log));
    }

    /**
     * 系统日志表删除
     * @param id
     * @return
     */
    @com.duoduo.common.annotation.Log("系统日志表删除")
    @DeleteMapping("/{id}")
    @ApiOperation("系统日志表删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(logService.removeById(id));
    }

}
