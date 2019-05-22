package com.duoduo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.system.entity.Role;
import com.duoduo.system.entity.User;
import com.duoduo.system.mapper.RoleMapper;
import com.duoduo.system.mapper.UserMapper;
import com.duoduo.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {

    /**
     * 角色mapper
     */
    @Autowired
    private RoleMapper roleMapper;
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = baseMapper.selectOne(new QueryWrapper<>(new User().setUsername(username)));
        if (user != null) {
            List<Role> roleList = roleMapper.selectListByUserId(user.getId());
            user.setAuthorities(roleList);
        }
        return user;
    }
}
