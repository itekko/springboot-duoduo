package com.duoduo.system.service;

import com.duoduo.system.entity.Resource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IResourceServiceTest {

    @Autowired
    private IResourceService resourceService;

    /**
     * 添加菜单
     */
    @Test
    public void addResource(){
        Resource resource = new Resource();
        resource.setPid(0L);
        resource.setName("系统管理");
        resource.setPermission("system");
        resource.setType(0);
        resource.setSort(1);
        resource.setRemark("系统管理");
        resourceService.save(resource);

        List<Resource> resources = Lists.newArrayList();
        Resource resource1 = new Resource();
        resource1.setPid(resource.getId());
        resource1.setName("用户管理");
        resource1.setPermission("system:user");
        resource1.setType(0);
        resource1.setSort(1);
        resource1.setRemark("用户管理");
        resources.add(resource1);

        Resource resource2 = new Resource();
        resource2.setPid(resource.getId());
        resource2.setName("角色管理");
        resource2.setPermission("system:role");
        resource2.setType(0);
        resource2.setSort(1);
        resource2.setRemark("角色管理");
        resources.add(resource2);

        Resource resource3 = new Resource();
        resource3.setPid(resource.getId());
        resource3.setName("菜单管理");
        resource3.setPermission("system:resource");
        resource3.setType(0);
        resource3.setSort(1);
        resource3.setRemark("菜单管理");
        resources.add(resource3);

        Resource resource4 = new Resource();
        resource4.setPid(resource.getId());
        resource4.setName("组织管理");
        resource4.setPermission("system:organization");
        resource4.setType(0);
        resource4.setSort(1);
        resource4.setRemark("组织管理");
        resources.add(resource4);

        Resource resource5 = new Resource();
        resource5.setPid(resource.getId());
        resource5.setName("日志管理");
        resource5.setPermission("system:log");
        resource5.setType(0);
        resource5.setSort(1);
        resource5.setRemark("日志管理");
        resources.add(resource5);

        Resource resource6 = new Resource();
        resource6.setPid(resource.getId());
        resource6.setName("字典管理");
        resource6.setPermission("system:dictionary");
        resource6.setType(0);
        resource6.setSort(1);
        resource6.setRemark("字典管理");
        resources.add(resource6);

        Resource resource7 = new Resource();
        resource7.setPid(resource.getId());
        resource7.setName("API管理");
        resource7.setPermission("system:API");
        resource7.setType(0);
        resource7.setSort(1);
        resource7.setRemark("API管理");
        resources.add(resource7);

        resourceService.saveBatch(resources);
    }

    @Test
    public void testTree(){
        List<Resource> tree = resourceService.tree();
        log.info("树结构：{}",tree);
    }

}