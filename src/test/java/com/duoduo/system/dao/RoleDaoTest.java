//package com.duoduo.system.dao;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author lixiaolong
// * @company 深圳和而泰智能控制股份有限公司
// * @create 2019-05-08 14:48
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class RoleDaoTest {
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    /**
//     * 测试新增
//     */
//    @Test
//    public void add(){
//
//        Role role = new Role();
//        role.setRolename("超级管理员");
//        role.setRemark("**管理严***");
//        role.setStatus(0L);
//        roleMapper.insert(role);
//    }
//
//    /**
//     * 测试乐观锁
//     */
//    @Test
//    public void update(){
//        Role role = new Role();
//        role.setId(1126017356405587969L);
//        role.setRolename("超级管理员");
//        role.setRemark("超级管理员111");
//        role.setVersion(1);
//        roleMapper.updateById(role);
//    }
//
//
//}