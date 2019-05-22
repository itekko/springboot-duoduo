package com.duoduo.system.service.impl;

import com.duoduo.system.entity.UserRole;
import com.duoduo.system.mapper.UserRoleMapper;
import com.duoduo.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户角色中间表 服务实现类
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
