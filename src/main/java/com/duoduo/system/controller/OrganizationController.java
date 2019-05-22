package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.Organization;
import com.duoduo.system.service.IOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统组织表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@RestController
@Api("/system/organization")
@RequestMapping("/system/organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    /**
     * 系统组织表查询
     * @return
     */
    @Log("系统组织表查询")
    @GetMapping("/{id}")
    @ApiOperation("系统组织表查询")
    public Result<Organization> get(@PathVariable("id") Long id){
        return Result.ok(organizationService.getById(id));
    }

    /**
     * 系统组织表列表查询(分页)
     * @return
     */
    @Log("系统组织表列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("系统组织表列表查询(分页)")
    public Result<IPage<Organization>> page(@RequestBody Organization organization){
        Page<Organization> page = new Page<>(organization.getCurrent(), organization.getSize());
        return Result.ok(organizationService.page(page,new QueryWrapper<>(organization)));
    }

    /**
     * 系统组织表列表查询
     * @return
     */
    @Log("系统组织表列表查询")
    @GetMapping("/list")
    @ApiOperation("系统组织表列表查询")
    public Result<List<Organization>> list(@RequestBody Organization organization){
        return Result.ok(organizationService.list(new QueryWrapper<>(organization)));
    }

    /**
     * 新增
     * @param organization
     * @return
     */
    @Log("系统组织表新增")
    @PostMapping
    @ApiOperation("系统组织表新增")
    public Result add(@RequestBody Organization organization){
        return Result.ok(organizationService.save(organization));
    }



    /**
     * 修改
     * @param id
     * @param organization
     * @return
     */
    @Log("系统组织表修改")
    @PutMapping("/{id}")
    @ApiOperation("系统组织表修改")
    public Result update(@PathVariable("id") Long id, @RequestBody Organization organization){
        return Result.ok(organizationService.updateById(organization));
    }

    /**
     * 系统组织表删除
     * @param id
     * @return
     */
    @Log("系统组织表删除")
    @DeleteMapping("/{id}")
    @ApiOperation("系统组织表删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(organizationService.removeById(id));
    }

}
