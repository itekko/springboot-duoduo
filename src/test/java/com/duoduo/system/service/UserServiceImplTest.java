package com.duoduo.system.service;

import com.duoduo.system.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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

    @Test
    public void add (){
        User user = new User();
        user.setUsername("ekko");
        user.setPassword("123456");
        user.setPhone("1351956953");
        user.setEmail("ekkoit@outlook.com");
        user.setRemark("屌丝");
        user.setStatus(0L);
        userService.saveOrUpdate(user);

    }


}