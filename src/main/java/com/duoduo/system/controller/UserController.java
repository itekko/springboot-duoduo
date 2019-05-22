package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duoduo.common.annotation.Log;
import com.duoduo.common.util.Result;
import com.duoduo.system.entity.User;
import com.duoduo.system.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@RestController
@RequestMapping("/system/user")
@Api("/system/user")
public class UserController{

    @Autowired
    private IUserService userService;


    /**
     * 查询
     * @return
     */
    @Log("用户查询")
    @GetMapping("/{id}")
    @ApiOperation("用户查询")
    public Result<User> get(@PathVariable("id") Long id){
        return Result.ok(userService.getById(id));
    }

    /**
     * 用户列表查询
     * @return
     */
    @Log("用户列表查询(分页)")
    @GetMapping("/page")
    @ApiOperation("用户列表查询(分页)")
    public Result<IPage<User>> page(@RequestBody User user){
        Page<User> page = new Page<>(user.getCurrent(), user.getSize());
        IPage<User> userIPage = userService.page(page,new QueryWrapper<>(user));
        if (userIPage != null ) {
            List<User> records = userIPage.getRecords();
            if(!CollectionUtils.isEmpty(records)){
                records.stream().forEach(item -> item.setPassword(null));
            }
        }
        return Result.ok(userIPage);
    }

    /**
     * 用户列表查询
     * @return
     */
    @Log("用户列表查询")
    @GetMapping("/list")
    @ApiOperation("用户列表查询")
    public Result<List<User>> list(@RequestBody User user){
        List<User> list = userService.list(new QueryWrapper<>(user));
        if(!CollectionUtils.isEmpty(list)){
            list.stream().forEach(item -> item.setPassword(null));
        }
        return Result.ok(list);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @Log("用户新增")
    @PostMapping
    @ApiOperation("用户新增")
    public Result add(@RequestBody User user){
        return Result.ok(userService.save(user));
    }



    /**
     * 修改
     * @param id
     * @param user
     * @return
     */
    @Log("用户修改")
    @PutMapping("/{id}")
    @ApiOperation("用户修改")
    public Result update(@PathVariable("id") Long id, @RequestBody User user){
        return Result.ok(userService.updateById(user));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Log("用户删除")
    @DeleteMapping("/{id}")
    @ApiOperation("用户删除")
    public Result remove(@PathVariable("id") Long id){
        return Result.ok(userService.removeById(id));
    }

}
