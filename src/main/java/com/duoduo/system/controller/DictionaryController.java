package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.Dictionary;
import com.duoduo.system.service.IDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@RestController
@Api("/system/dictionary")
@RequestMapping("/system/dictionary")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 系统字典表查询
     * @return
     */
    @Log("系统字典表查询")
    @GetMapping("/{id}")
    @ApiOperation("系统字典表查询")
    public Result<Dictionary> get(@PathVariable("id") Long id){
        return Result.ok(dictionaryService.getById(id));
    }

    /**
     * 系统字典表列表查询(分页)
     * @return
     */
    @Log("系统字典表列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("系统字典表列表查询(分页)")
    public Result<IPage<Dictionary>> page(@RequestBody Dictionary dictionary){
        Page<Dictionary> page = new Page<>(dictionary.getCurrent(), dictionary.getSize());
        return Result.ok(dictionaryService.page(page,new QueryWrapper<>(dictionary)));
    }

    /**
     * 系统字典表列表查询
     * @return
     */
    @Log("系统字典表列表查询")
    @GetMapping("/list")
    @ApiOperation("系统字典表列表查询")
    public Result<List<Dictionary>> list(@RequestBody Dictionary dictionary){
        return Result.ok(dictionaryService.list(new QueryWrapper<>(dictionary)));
    }

    /**
     * 新增
     * @param dictionary
     * @return
     */
    @Log("系统字典表新增")
    @PostMapping
    @ApiOperation("系统字典表新增")
    public Result add(@RequestBody Dictionary dictionary){
        return Result.ok(dictionaryService.save(dictionary));
    }



    /**
     * 修改
     * @param id
     * @param dictionary
     * @return
     */
    @Log("系统字典表修改")
    @PutMapping("/{id}")
    @ApiOperation("系统字典表修改")
    public Result update(@PathVariable("id") Long id, @RequestBody Dictionary dictionary){
        return Result.ok(dictionaryService.updateById(dictionary));
    }

    /**
     * 系统字典表删除
     * @param id
     * @return
     */
    @Log("系统字典表删除")
    @DeleteMapping("/{id}")
    @ApiOperation("系统字典表删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(dictionaryService.removeById(id));
    }

}
