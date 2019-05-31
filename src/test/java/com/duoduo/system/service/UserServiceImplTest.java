package com.duoduo.system.service;

import cn.hutool.core.lang.Snowflake;
import com.duoduo.system.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IRoleResourceService roleResourceService;

    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IUserOrganizationService userOrganizationService;
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

        List<Role> roles = Lists.newArrayList();
        // 新增角色
        Role role = new Role();
        role.setRolename("超级管理员");
        role.setRemark("超级管理员");
        roles.add(role);


        Role role2 = new Role();
        role2.setRolename("平台管理员");
        role2.setRemark("平台管理员");
        roles.add(role2);
        roleService.saveBatch(roles);

        // 保存中间表
        UserRole userRole = new UserRole();
        userRole.setRoleId(role.getId());
        userRole.setUserId(user.getId());

        List<UserRole> list = Lists.newArrayList();
        list.add(userRole);

        userRoleService.saveBatch(list);

        // 菜单列表
        List<Resource> resources = resourceService.list();
        if(!CollectionUtils.isEmpty(list)){
            List<RoleResource> roleResources = Lists.newArrayList();

            roles.forEach(item ->{
                      resources.forEach(resource -> {
                          RoleResource roleResource = new RoleResource();
                          roleResource.setResourceId(resource.getId());
                          roleResource.setRoleId(item.getId());
                          roleResources.add(roleResource);
                      });
                    }
                );

            roleResourceService.saveBatch(roleResources);
        }

        // 组织
        Organization organization = new Organization();
        organization.setPid(0L);
        organization.setName("多多科技");
        organization.setCode("G" + new Snowflake(1,1).nextId()+ "");
        organization.setSort(1);
        organization.setType(0);//公司
        organization.setRemark("多多科技");
        organization.setStatus(1L);
        organization.setVersion(1);
        organization.setDeleted(0);
        organizationService.save(organization);

        Organization organization1 = new Organization();
        organization1.setPid(organization.getId());
        organization1.setName("技术开发部");
        organization1.setCode("D" + new Snowflake(1,1).nextId()+ "");
        organization1.setSort(1);
        organization1.setType(1);//部门
        organization1.setRemark("技术开发部");
        organization1.setStatus(1L);
        organization1.setVersion(1);
        organization1.setDeleted(0);
        organizationService.save(organization1);


        //用户组织
        UserOrganization userOrganization = new UserOrganization();
        userOrganization.setOrganizationId(organization1.getId());
        userOrganization.setUserId(user.getId());
        userOrganizationService.save(userOrganization);



    }


}