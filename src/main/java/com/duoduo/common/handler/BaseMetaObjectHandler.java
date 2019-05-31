package com.duoduo.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.duoduo.common.util.LoginUserUtils;
import com.duoduo.system.entity.User;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 填充器数据
 *
 * @author ekko 2018-08-10 22:59:23.
 */
//@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMetaObjectHandler.class);



    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        User user = LoginUserUtils.getLoginUser();
        if (user != null) {
            this.setFieldValByName("createBy", user.getId(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");
        User user = LoginUserUtils.getLoginUser();
        if (user != null) {
            this.setFieldValByName("updateBy", user.getId(), metaObject);
        }
    }
}
