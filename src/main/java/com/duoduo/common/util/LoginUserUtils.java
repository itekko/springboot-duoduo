package com.duoduo.common.util;

import com.duoduo.system.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前登录的用户工具类
 */
public final class LoginUserUtils {

    private LoginUserUtils(){}

    /**
     * 获取当前登录的用户方法
     * @return
     */
    public static User getLoginUser(){
        User user = null;
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(principal instanceof User){
            user = (User) principal;
        }
        return user;

    }



}
