package com.duoduo.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duoduo.common.annotation.Log;
import com.duoduo.system.entity.User;
import com.duoduo.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.api.ApiController;

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
public class UserController extends ApiController {

    @Autowired
    private IUserService userService;


    /**
     * 查询
     * @return
     */
    @Log("用户查询")
    @GetMapping("/{id}")
    public R<User> get(@PathVariable("id") Long id){
        return success(userService.getById(id));
    }

    /**
     * 用户列表查询
     * @return
     */
    @Log("用户列表查询")
    @GetMapping
    public R<IPage<User>> list(){
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = userService.page(page);
        return success(userIPage);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @Log("用户新增")
    @PostMapping
    public R add(@RequestBody User user){
        return success(userService.save(user));
    }



    /**
     * 修改
     * @param id
     * @param user
     * @return
     */
    @Log("用户修改")
    @PutMapping("/{id}")
    public R update(@PathVariable("id") Long id, @RequestBody User user){
        return success(userService.updateById(user));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Log("用户删除")
    @DeleteMapping("/{id}")
    public R remove(@PathVariable("id") Long id){
        return success(userService.removeById(id));
    }

}
