package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.Role;
import com.duoduo.system.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@RestController
@Api("/system/role")
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 系统角色表查询
     * @return
     */
    @Log("系统角色表查询")
    @GetMapping("/{id}")
    @ApiOperation("系统角色表查询")
    public Result<Role> get(@PathVariable("id") Long id){
        return Result.ok(roleService.getById(id));
    }

    /**
     * 系统角色表列表查询(分页)
     * @return
     */
    @Log("系统角色表列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("系统角色表列表查询(分页)")
    public Result<IPage<Role>> page(@RequestBody Role role){
        Page<Role> page = new Page<>(role.getCurrent(), role.getSize());
        return Result.ok(roleService.page(page,new QueryWrapper<>(role)));
    }

    /**
     * 系统角色表列表查询
     * @return
     */
    @Log("系统角色表列表查询")
    @GetMapping("/list")
    @ApiOperation("系统角色表列表查询")
    public Result<List<Role>> list(@RequestBody Role role){
        return Result.ok(roleService.list(new QueryWrapper<>(role)));
    }

    /**
     * 新增
     * @param role
     * @return
     */
    @Log("系统角色表新增")
    @PostMapping
    @ApiOperation("系统角色表新增")
    public Result add(@RequestBody Role role){
        return Result.ok(roleService.save(role));
    }



    /**
     * 修改
     * @param id
     * @param role
     * @return
     */
    @Log("系统角色表修改")
    @PutMapping("/{id}")
    @ApiOperation("系统角色表修改")
    public Result update(@PathVariable("id") Long id, @RequestBody Role role){
        return Result.ok(roleService.updateById(role));
    }

    /**
     * 系统角色表删除
     * @param id
     * @return
     */
    @Log("系统角色表删除")
    @DeleteMapping("/{id}")
    @ApiOperation("系统角色表删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(roleService.removeById(id));
    }

}
