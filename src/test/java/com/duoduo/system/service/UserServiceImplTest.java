package com.duoduo.system.service;

import com.duoduo.system.entity.Role;
import com.duoduo.system.entity.User;
import com.duoduo.system.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lixiaolong
 * @company 深圳和而泰智能控制股份有限公司
 * @create 2019-05-08 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRoleService userRoleService;

    @Test
    public void add (){
        User user = new User();
        user.setUsername("admin");
        String password = passwordEncoder.encode("admin");
        user.setPassword(password);
        user.setPhone("1351956953");
        user.setEmail("ekkoit@outlook.com");
        user.setRemark("屌丝");
        user.setStatus(0L);
        userService.saveOrUpdate(user);

    }

    @Test
    public void useradd (){

        // 新增用户
        User user = new User();
        user.setUsername("admin");
        String password = passwordEncoder.encode("admin");
        user.setPassword(password);
        user.setPhone("1351956953");
        user.setEmail("ekkoit@outlook.com");
        user.setRemark("屌丝");
        user.setStatus(0L);
        userService.saveOrUpdate(user);

        // 新增角色
        Role role = new Role();
        role.setRolename("超级管理员");
        role.setRemark("超级管理员");

        roleService.saveOrUpdate(role);

        Role role2 = new Role();
        role2.setRolename("平台管理员");
        role2.setRemark("平台管理员");

        roleService.saveOrUpdate(role2);

        UserRole userRole = new UserRole();
        userRole.setRoleId(role.getId());
        userRole.setUserId(user.getId());

        UserRole userRole2 = new UserRole();
        userRole2.setRoleId(role2.getId());
        userRole2.setUserId(user.getId());
        List<UserRole> list = Lists.newArrayList();
        list.add(userRole);
        list.add(userRole2);

        userRoleService.saveBatch(list);


    }


}